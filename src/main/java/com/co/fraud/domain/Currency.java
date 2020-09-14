package com.co.fraud.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Currency {

    private String code;
    private String name;
    private String symbol;

}
