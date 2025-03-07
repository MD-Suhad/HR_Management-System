package com.alibou.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@JsonIgnoreProperties

public class Country {
    private Long id;
    private int countryId;

    private String name;

    private String continent;



}
