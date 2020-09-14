package com.co.fraud.domain;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class Rate implements Serializable {

    private String USD;
    private String EUR;

}
