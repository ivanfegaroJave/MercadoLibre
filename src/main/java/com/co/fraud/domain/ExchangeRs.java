package com.co.fraud.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Builder
public class ExchangeRs implements Serializable {

    private Rate rates;
    private String base;
    private String date;


}
