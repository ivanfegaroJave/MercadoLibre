package com.co.fraud.entrypoint.client;

import com.co.fraud.crosscuting.constants.Constants;
import com.co.fraud.domain.ExchangeRs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class in charge to bring the exchange for each currency of the country
 *
 * @author Iván García
 * @version v1
 */

@FeignClient(url = "${services.exchange}", name = "exchangeServiceClient")
public interface ExchangeServiceClient {

    @GetMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    ExchangeRs getExchangeByCountry(@RequestParam(Constants.EXCHANGE) String currency);


}
