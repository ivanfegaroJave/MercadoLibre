package com.co.fraud.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CountryRs {

    private String countryCode;
    private String countryCode3;
    private String countryName;
    private String countryEmoji;

}
