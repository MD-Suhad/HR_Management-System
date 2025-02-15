package com.alibou.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
public class Country {
    private int countryId;

    private String name;

    private String continent;

    public Country(int countryId, String name, String continent) {
    }

    public void setCountryId(int countryId) {
    }

    public void setName(String name) {
    }

    public void setContinent(String continent) {
    }

    public String getName() {
        return null;
    }

    public String getContinent() {
        return null;
    }

    public Object getCountryId() {
        return null;
    }
}
