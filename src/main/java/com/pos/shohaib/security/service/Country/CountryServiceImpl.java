package com.pos.shohaib.security.service.Country;

import com.pos.shohaib.security.dbo.CountryDAO;
import com.pos.shohaib.security.domain.model.Country;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryDAO countryDAO;

    @Override
    public List<Country> findAll(String search, int offset, int recordPerPage) throws SQLException {
         return countryDAO.findAll(search,offset,recordPerPage);
    }

    @Override
    public String Store(Country country) throws SQLException {
//
//        return countryDAO.save(country);
        return null;

    }

    @Override
    public boolean save(Country country) throws SQLException {
        return countryDAO.save(country);
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
