package com.co.fraud.entrypoint.client;


import com.co.fraud.crosscuting.constants.Constants;
import com.co.fraud.domain.CountryRs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Class in charge to bring the name of the country based in IP address
 *
 * @author Iván García
 * @version v1
 */

@FeignClient(url = "${services.country}", name = "countryServiceClient"
        , fallback = CountryClientFallBack.class
)
public interface CountryServiceClient {

    @GetMapping(path = Constants.IP, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CountryRs> getCountry(@RequestParam() Map<String, String> apiClient);

}
