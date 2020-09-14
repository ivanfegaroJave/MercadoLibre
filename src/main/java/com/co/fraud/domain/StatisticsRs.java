package com.co.fraud.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class StatisticsRs {

    private String ip;
    private String fechaActual;
    private String pais;
    private String isoCode;
    private String idioma;
    private String moneda;
    private String hora;
    private String distancia;

}
