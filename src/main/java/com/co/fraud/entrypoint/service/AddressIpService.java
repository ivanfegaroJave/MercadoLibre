package com.co.fraud.entrypoint.service;

import com.co.fraud.domain.AverageRs;
import com.co.fraud.domain.StatisticsRs;
import com.co.fraud.jpa.entity.CountryDao;

/**
 * Interface class that describes the methods that get the data from the each ip Address
 *
 * @author Iván García
 * @version v1
 */

public interface AddressIpService {

    /**
     * This method captures the requests that seek to validate products for a specific coupon
     *
     * @param ip to validate, this contain the ip address that you want to consult the origin of the same
     * @return data related from the ip address.
     */

    StatisticsRs getDataCountryRs (String ip);

    /**
     * Interface of the method that  bring the data country more far
     *
     * @returns CountryDao that contains all the data for the IP
     */
    CountryDao getDaaMaxValueCountry();
    /**
     * Interface that call the country from the DB which bring the country more near
     *
     * @returns CountryDao that contains all the data for the IP
     */

    CountryDao getDataMinValueCountry();
    /**
     * interface of  the method that calculate the average for all data store in the DB
     *
     * @returns AverageRs that contains the avergae for all cpuntries peticions
     */

    AverageRs getDataAverageConsults();
}
