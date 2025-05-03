package com.alibou.security.controller;

import com.alibou.security.service.Country.CountryService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CountryControllerAll {

    @Autowired
    private CountryService countryService;

    @GetMapping("/account-funds")
    public Response<Object> index()
    {
        return Response.ok().setPayload(this.accountFundService.index());
    }



}
