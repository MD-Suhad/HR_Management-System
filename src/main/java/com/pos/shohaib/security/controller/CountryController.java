package com.pos.shohaib.security.controller;

import com.pos.shohaib.security.domain.model.Country;
import com.pos.shohaib.security.service.Country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@Validated
public class CountryController {

    @Autowired
    private CountryService countryService;

//    @GetMapping("/country-all")
//    public ResponseEntity<Object> findAll() throws SQLException {
//        return ResponseEntity.ok(countryService.findAll());
//    }

    @PostMapping("/country-store")
    public ResponseEntity<Object> save( @PathVariable StoreAndUpdateCountryController storeAndUpdateCountryController ) throws SQLException{
        Country country = new Country();
         country.setCountryId(storeAndUpdateCountryController.getCountryId());
         country.setName(storeAndUpdateCountryController.getName());
        country.setContinent(storeAndUpdateCountryController.getContinent());
        return ResponseEntity.ok(countryService.save(country));
    }




}
