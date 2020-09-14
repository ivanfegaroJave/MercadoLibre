package com.co.fraud.entrypoint.client;

import com.co.fraud.domain.CountryRs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CountryClientFallBack
        implements CountryServiceClient
{

    public ResponseEntity<CountryRs> getCountry(Map<String, String> apiClient) {
        return new ResponseEntity<CountryRs>(CountryRs.builder().build(), HttpStatus.NOT_FOUND);
    }
}
