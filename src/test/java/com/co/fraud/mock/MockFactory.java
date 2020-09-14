package com.co.fraud.mock;

import com.co.fraud.domain.*;
import com.co.fraud.jpa.entity.CountryDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MockFactory {


    private static double[] latlng = {38, -97};
    private static String[] timezones = {"UTC-12:00"};


    public static CountryDao countryDaoMock() {
        CountryDao countryDao = new CountryDao();
        countryDao.setId(UUID.randomUUID());
        countryDao.setNumberCode("724");
        countryDao.setDistanceCountry(10034.52);
        countryDao.setNameCountry("Spain");
        countryDao.setNumberTimes(3);

        return countryDao;

    }

    public static StatisticsRs StatisticsRsMock() {
        return StatisticsRs
                .builder()
                .build();
    }

    public static List<CountryDao> countryDaoListMock() {
        List<CountryDao> countryDaoList = new ArrayList<>();
        countryDaoList.add(countryDaoMock());
        return countryDaoList;

    }

    public static Optional<CountryDao> countryDaoOptionalMock() {
        return Optional.of(countryDaoMock());
    }

    public static List<DataCountryRS> dataCountryRSListMock() {
        List<DataCountryRS> dataCountryRS = new ArrayList<>();
        dataCountryRS.add(dataCountryRSMock());
        return dataCountryRS;
    }

    public static DataCountryRS dataCountryRSMock() {

        return DataCountryRS.builder()
                .name("United States of America")
                .alpha2Code("US")
                .alpha3Code("USA")
                .capital("Washington, D.C.")
                .region("Americas")
                .currencies(currenciesMock())
                .latlng(latlng)
                .languages(languagesListMock())
                .cioc("USA")
                .nativeName("United States")
                .numericCode("840")
                .timezones(timezones).build();
    }

    public static Currency currencyMock() {
        return Currency.builder()
                .code("USD")
                .name("United States dollar")
                .symbol("$")
                .build();
    }

    public static Language languageMock() {
        return Language.builder()
                .iso639_1("en")
                .iso639_2("eng")
                .name("English")
                .nativeName("English")
                .build();

    }

    public static List<Language> languagesListMock() {
        List<Language> languages = new ArrayList<>();
        languages.add(languageMock());
        return languages;

    }

    public static List<Currency> currenciesMock() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(currencyMock());
        return currencies;
    }

    public static ExchangeRs exchangeRsMock(){
        return ExchangeRs.builder()
                .rates(ratesMock())
                .build();
    }

    public static Rate ratesMock(){
        return Rate.builder()
                .USD("0.98745")
                .build();

    }

    public static DataCountryRS dataCountryRSMockNodata() {
        return DataCountryRS.builder().build();
    }

    public static List<DataCountryRS> dataCountryRSListMockNodata() {
        List<DataCountryRS> dataCountryRS = new ArrayList<>();
        dataCountryRS.add(dataCountryRSMockNodata());
        return dataCountryRS;
    }




}
