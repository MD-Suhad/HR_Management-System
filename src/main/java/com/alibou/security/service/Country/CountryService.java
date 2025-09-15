package com.alibou.security.service.Country;

import com.alibou.security.domain.model.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryService {
    List<Country> findAll(String search, int offset, int recordPerPage) throws SQLException;
    String Store(Country country) throws SQLException;

    boolean save(Country country) throws SQLException;

    boolean update(Country country) throws SQLException;

    boolean delete(int id) throws SQLException;

    Country findById(int id) throws SQLException;

    int count() throws SQLException;
}
