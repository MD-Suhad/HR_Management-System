package com.alibou.security.entity;


import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private String type;
    private String registration;
    private String color;
    @OneToOne
    private Slot slot;
}
