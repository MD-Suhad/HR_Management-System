package com.alibou.security.service.Country;

import com.alibou.security.dbo.CountryDAO;
import com.alibou.security.entity.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryService {
    List<CountryDAO> findAll() throws SQLException;

    boolean save(Country country) throws SQLException;

    boolean update(Country country) throws SQLException;

    boolean delete(int id) throws SQLException;

    Country findById(int id) throws SQLException;

    int count() throws SQLException;
}
