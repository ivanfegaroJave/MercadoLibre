package com.co.fraud.entrypoint.client;

import com.co.fraud.crosscuting.constants.Constants;
import com.co.fraud.domain.DataCountryRS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * Class in charge to bring the details for each country
 *
 * @author Iván García
 * @version v1
 */

@FeignClient(url = "${services.detail-country}", name = "detailCountryServiceClient")
public interface DetailCountryServiceClient {

    @GetMapping( path = Constants.NAME, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<DataCountryRS> getCountry(@PathVariable(Constants.COUNTRY) String name);

}
