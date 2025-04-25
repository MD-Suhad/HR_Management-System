package com.alibou.security.dbo;

import com.alibou.security.entity.Country;
import com.alibou.security.utils.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl implements CountryDAO{


    @Override
    public List<Country> findAll(String search, int offset, int recordPerPage) throws SQLException {
        List<Country> countries = new ArrayList<Country>();
        Connection connection = DatabaseConfig.getConnection();
        String SQL = "SELECT * FROM country WHERE name LIKE ? OR continent LIKE ? ORDER BY country_id ASC LIMIT ?,?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, "%" + search + "%");
        preparedStatement.setString(2, "%" + search + "%");
        preparedStatement.setInt(3, offset);
        preparedStatement.setInt(4, recordPerPage);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Country country = new Country();
            country.setCountryId(resultSet.getInt("country_id"));
            country.setName(resultSet.getString("name"));
            country.setContinent(resultSet.getString("continent"));
            countries.add(country);
        }
        return countries;
    }

    @Override
    public boolean save(Country country) throws SQLException {
        Connection connection = DatabaseConfig.getConnection();
        String SQL = "INSERT INTO country(name, continent) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, country.getName());
        preparedStatement.setString(2, country.getContinent());
        return preparedStatement.executeUpdate() > 0;
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
