package com.co.fraud.entrypoint.controller;

import com.co.fraud.crosscuting.constants.Constants;
import com.co.fraud.crosscuting.constants.ResourceEndpoint;
import com.co.fraud.domain.AverageRs;
import com.co.fraud.domain.StatisticsRs;
import com.co.fraud.entrypoint.service.AddressIpService;
import com.co.fraud.jpa.entity.CountryDao;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class in charge to capturing the ip address
 *
 * @author Iván García
 * @version v1
 */

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = Constants.CROSS_ORIGIN)
@RequestMapping(value = ResourceEndpoint.API)
public class AddressIPController {

    private static final Logger log = LoggerFactory.getLogger(AddressIPController.class);
    private final AddressIpService addressIpService;

    /**
     * This method captures the requests that seek the data for the specific ip address
     *
     * @param ip to validate, this contain the ip address that you want to consult the origin of the same
     * @return data related from the ip address.
     */

    @GetMapping(value = ResourceEndpoint.ADDRESS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatisticsRs> getDataIp(@RequestParam(value = Constants.IP) String ip) {
        return new ResponseEntity<>(addressIpService.getDataCountryRs(ip), HttpStatus.OK);
    }

    /**
     * This method captures the requests that seek the maximum distance since Buenos Aires
     *
     * @param
     * @return Country
     */

    @GetMapping(value = ResourceEndpoint.STATISTICS_MAX, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDao> getMaxCountry(){
        return new ResponseEntity<>(addressIpService.getDaaMaxValueCountry(), HttpStatus.OK);
    }

    /**
     * This method captures the requests that seek the minimum distance since Buenos Aires
     *
     * @param
     * @return Country
     */

    @GetMapping(value = ResourceEndpoint.STATISTICS_MIN, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDao> getMinCountry(){
        return new ResponseEntity<>(addressIpService.getDataMinValueCountry(), HttpStatus.OK);
    }

    /**
     * This method captures the requests that seek the average distance for all countries  since Buenos Aires
     *
     * @param
     * @return Country
     */

    @GetMapping(value = ResourceEndpoint.STATISTICS_AVERAGE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AverageRs> getAverageStatistics(){
        return new ResponseEntity<>(addressIpService.getDataAverageConsults(), HttpStatus.OK);
    }


}
