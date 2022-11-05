package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcRestaurantDao implements RestaurantDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM restaurant;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Restaurant r = mapRowToRestaurant(results);
            restaurants.add(r);
        }
        return restaurants;
    }

    @Override
    public List<Restaurant> findRestaurantByCity(String city) {
        return null;
    }

    @Override
    public List<Restaurant> findRestaurantByZip(Long zipCode) {
        return null;
    }

    private Restaurant mapRowToRestaurant(SqlRowSet result) {
        Restaurant r = new Restaurant();
        r.setResId(result.getLong("resId"));
        r.setRestaurantName(result.getString("restaurant_name"));
        r.setCuisineType(result.getString("cuisine_type"));
        r.setStreetAddress(result.getString("street"));
        r.setCity(result.getString("city"));
        r.setState(result.getString("state"));
        r.setZipCode(result.getLong("zip"));
        r.setPhoneNumber(result.getLong("phone"));
        r.setHours(result.getString("open_hour"));
        return r;
    }
}