package com.alibou.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties

public class Country {
    private int countryId;

    private String name;

    private String continent;



}
