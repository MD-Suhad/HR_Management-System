package com.alibou.security.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private int countryId;
    private String name;
    private String continent;



}
