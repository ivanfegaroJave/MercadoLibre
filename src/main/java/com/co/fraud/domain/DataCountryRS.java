package com.co.fraud.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Builder
public class DataCountryRS implements Serializable {

    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private String capital;
    private String region;
    private double[] latlng;
    private List <Currency> currencies;
    private List <Language> languages;
    private String cioc;
    private String nativeName;
    private String numericCode;
    private String[] timezones;


}
