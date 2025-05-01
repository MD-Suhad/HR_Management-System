package com.alibou.security.service.Country;

import com.alibou.security.dbo.CountryDAO;
import com.alibou.security.entity.Country;

import java.sql.SQLException;
import java.util.List;

public class CountryServiceImpl implements CountryService {

    @Override
    public List<CountryDAO> findAll() throws SQLException {
         return null;
    }

    @Override
    public String Store(CountryDAO countryDAO) throws SQLException {

        Country country = new Country();
        return null;
    }

    @Override
    public boolean save(Country country) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Country country) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Country findById(int id) throws SQLException {
        return null;
    }

    @Override
    public int count() throws SQLException {
        return 0;
    }
}
