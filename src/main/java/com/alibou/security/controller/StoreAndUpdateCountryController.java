package com.alibou.security.controller;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class StoreAndUpdateCountryController {
    private int countryId;
    private String name;
    private String continent;
}
