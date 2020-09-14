package com.co.fraud.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Language {

    private String iso639_1;
    private String iso639_2;
    private String name;
    private String nativeName;


}
