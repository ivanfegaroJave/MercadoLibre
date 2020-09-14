package com.co.fraud.entrypoint.service.implement;

import com.co.fraud.crosscuting.constants.Constants;
import com.co.fraud.crosscuting.exception.NotNameCurrencyValidException;
import com.co.fraud.crosscuting.exception.ValidationException;
import com.co.fraud.crosscuting.helper.Distance;
import com.co.fraud.crosscuting.helper.IpAddressValidator;
import com.co.fraud.crosscuting.helper.TimeZoneHelper;
import com.co.fraud.domain.*;
import com.co.fraud.domain.Currency;
import com.co.fraud.entrypoint.client.DetailCountryServiceClient;
import com.co.fraud.entrypoint.client.ExchangeServiceClient;
import com.co.fraud.entrypoint.service.AddressIpService;
import com.co.fraud.entrypoint.client.CountryServiceClient;
import com.co.fraud.jpa.entity.CountryDao;
import com.co.fraud.jpa.repository.CountryRepository;
import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.*;


/**
 * Class in charge to implement the logic of get the data of ip Address
 *
 * @author Iván García
 * @version v1
 */
@Service
@RequiredArgsConstructor
public class AddressIpServiceImpl implements AddressIpService {

    private static final Logger log = LoggerFactory.getLogger(AddressIpServiceImpl.class);

    private final CountryServiceClient countryServiceClient;
    private final DetailCountryServiceClient detailCountryServiceClient;
    private final ExchangeServiceClient exchangeServiceClient;
    private final CountryRepository countryRepository;


    /**
     * Call different Method for fill in the data for the response
     *
     * @param ip
     * @returns StatisticsRs that contains all the data for the IP
     */
    @Override
    public StatisticsRs getDataCountryRs(String ip) {

        if (IpAddressValidator.isValid(ip)) {
            /*bring the country of the ip Address */
            String name = getDataCountryServiceAddress(ip);
            /* bring the data for the Country*/
            List<DataCountryRS> dataCountry = getDataCountry(name);
            /* bring the Kilometers since Buenos Aires to the Ip Consulted*/
            double distance = getDistance(dataCountry);

            return getExchangeValue(dataCountry, distance, ip);
        } else {
            throw new ValidationException(Constants.ERROR_IP);
        }
    }

    /**
     * Call the country from the DB which bring the country more far
     *
     * @returns CountryDao that contains all the data for the IP
     */
    @Override
    public CountryDao getDaaMaxValueCountry() {
        return countryRepository.findFirstByOrderByDistanceCountryDesc();
    }

    /**
     * Call the country from the DB which bring the country more near
     *
     * @returns CountryDao that contains all the data for the IP
     */
    @Override
    public CountryDao getDataMinValueCountry() {
        return countryRepository.findFirstByOrderByDistanceCountryAsc();
    }

    /**
     * Call the method that calculate the average for all data store in the DB
     *
     * @returns AverageRs that contains the avergae for all cpuntries peticions
     */
    @Override
    public AverageRs getDataAverageConsults() {
        return AverageRs.builder()
                .AverageDistance(Constants.AVERAGE_MESSAGE + calculateAverage()).build();
    }

    /**
     * Call the client that bring the country for the IP address consulted
     *
     * @param ip
     * @returns the name of the country that bring since the client
     */
    private String getDataCountryServiceAddress(String ip) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(ip, null);
        CountryRs countryRs = countryServiceClient.getCountry(parameters).getBody();
        return countryRs.getCountryName();
    }

    /**
     * get the detail of each country from the client
     *
     * @param name
     * @returns list to the details for each country based on the name
     */

    private List<DataCountryRS> getDataCountry(String name) {
        return detailCountryServiceClient.getCountry(name);
    }

    /**
     * bring the distance in km , based in latitude and longitude
     *
     * @param dataCountryRS list of details of the country
     * @returns double. the distance of realized the consult from the origin to Buenos aires
     */

    public double getDistance(List<DataCountryRS> dataCountryRS) {
        double[] latLong = new double[0];
        for (DataCountryRS dataCountry : dataCountryRS) {
            latLong = dataCountry.getLatlng();
            if (latLong == null) {
                throw new NotNameCurrencyValidException(Constants.ERROR_NAME_CURRENCY_INVALID);
            }
        }
        return Distance.distance(Constants.LAT1, Constants.LON1, latLong[0], latLong[1]);

    }

    /**
     * bring the distance in km , based in latitude and longitude
     *
     * @param dataCountry list of details of the country
     * @param distance      distance for the country (IP) consulted
     * @param ip      IP consulted
     * @returns StatisticsRs. Details for the IP address
     */
    public StatisticsRs getExchangeValue(List<DataCountryRS> dataCountry, double distance, String ip) {
        for (DataCountryRS countryRS : dataCountry) {
            for (Currency currency : countryRS.getCurrencies()) {
                if (StringUtils.isNotBlank(currency.getCode()) && StringUtils.isNotBlank(countryRS.getCapital())) {
                    saveStatistics(countryRS.getNumericCode(), countryRS.getName(), distance);
                    ExchangeRs exchangeRs = exchangeServiceClient.getExchangeByCountry(currency.getCode());
                    for (Language language : countryRS.getLanguages()) {

                        return StatisticsRs.builder()
                                .ip(ip)
                                .pais(countryRS.getName())
                                .isoCode(countryRS.getNumericCode())
                                .hora(TimeZoneHelper.hora(countryRS.getTimezones()[0]))
                                .fechaActual(TimeZoneHelper.fecha(countryRS.getTimezones()[0]))
                                .idioma(language.getNativeName())
                                .distancia(distance + Constants.KM)
                                .moneda(String.format(Constants.EXCHANGE_CURRENCY, currency.getCode()) + exchangeRs.getRates().getUSD())
                                .build();

                    }
                }
            }
        }
        return StatisticsRs.builder().build();
    }


    /**
     * save statistics in the DB
     *
     * @param numCode ISO code for each country
     * @param distance       distance for the country (IP) consulted
     * @param name      name for the country that we are going to save
     */
    public CountryDao saveStatistics(String numCode, String name, double distance) {
        CountryDao countryNew = new CountryDao();
        Optional<CountryDao> countryDao = countryRepository.findByNumberCode(numCode);
        if (countryDao.isPresent()) {
            countryNew = countryDao.get();
            countryNew.setNumberTimes(countryDao.get().getNumberTimes() + Constants.INITIAL_VALUE);
            countryRepository.save(countryNew);
        } else {
            countryNew.setId(UUID.randomUUID());
            countryNew.setNumberCode(numCode);
            countryNew.setDistanceCountry(distance);
            countryNew.setNameCountry(name);
            countryNew.setNumberTimes(Constants.INITIAL_VALUE);
            countryRepository.save(countryNew);
        }
        return countryNew;
    }

    /**
     * method that calculate the average for each country from the DB
     *
     * @returns double. average for all the data to is storage in the DB
     * ((Distance* invoke) + (Distance+ invoke))/sum(invoke)
     */

    public double calculateAverage() {
        List<CountryDao> countryDaoList = countryRepository.findAll();
        List<Double> distance = new ArrayList<>();
        double totalValue = countryDaoList.stream().mapToDouble(value -> value.getNumberTimes()).sum();
        for (CountryDao countryDao : countryDaoList) {
            double sum = countryDao.getDistanceCountry() * countryDao.getNumberTimes();
            distance.add(sum);
        }
        return distance.stream().mapToDouble(Double::doubleValue).sum() / totalValue;

    }


}
