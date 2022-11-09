package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

// We have labeled this as a REST Component and implemented the DAO Interface
@Component
public class JdbcRestaurantDao implements RestaurantDao {

    // The DAO has native list of Restaurants it will generally return to the user
        // Declaring it here should allow us to populate and unpopulate it based on how the user searches. I hope.
    List<Restaurant> restaurants = new ArrayList<>();
    // The DAO calls the JDBC Template
    private JdbcTemplate jdbcTemplate;
    // The DAO constructor sets the JDBC Template based on the datasource we've provided in the application properties
    public JdbcRestaurantDao(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }
    // The DAO can list all of the restaurants currently populating its 'restaurants' List<Restaurant>
    @Override
    public List<Restaurant> list() {
        return restaurants;
    }
    // The DAO cannot yet return a Restaurant based on Id
    @Override
    public Restaurant get(int id) {
        return null;
    }
    // The DAO cannot yet create a Restaurant and may not be necessary for an MVP
        // this was added in keeping with what appears to be a general model
    @Override
    public Restaurant create(Restaurant restaurant) {
        return null;
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        String sql = "SELECT * FROM restaurants;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            restaurants.add(mapRowToRestaurant(results));
        }
        return restaurants;
    }
    @Override
    public List<Restaurant> findRestaurantByCity(String city) {
//        List<Restaurant> r = new ArrayList<>();
//        String sql = "select * from restaurants " +
//                    "WHERE city = '?';";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, city);
//        while (results.next()) {
//            r.add(mapRowToRestaurant(results));
//        }
        return null;
    }

    @Override
    public List<Restaurant> findRestaurantByZip(Integer searchZip) {
        String sql = "SELECT * FROM restaurants " +
                "WHERE zip = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchZip);
        while (results.next()) {
            restaurants.add(mapRowToRestaurant(results));
        }
        List<Restaurant> matchZip = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getZipCode() == searchZip) {
                matchZip.add(restaurant);
            }
        }
        return matchZip;
    }

    @Override
    public List<Restaurant> findRestaurantByCuisine(String cuisineType) {
//        List<Restaurant> r = new ArrayList<>();
//        String sql = "SELECT * FROM restaurants " +
//                    "WHERE cuisine_type = '?';";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cuisineType);
//        while (results.next()) {
//            r.add(mapRowToRestaurant(results));
//        }
        return null;
    }

    private Restaurant mapRowToRestaurant(SqlRowSet result) {
        Restaurant r = new Restaurant();
        r.setResId(result.getLong("res_id"));
        r.setRestaurantName(result.getString("restaurant_name"));
        r.setCuisineType(result.getString("cuisine_type"));
        r.setStreetAddress(result.getString("street"));
        r.setCity(result.getString("city"));
        r.setState(result.getString("state_name"));
        r.setZipCode(result.getInt("zip"));
        r.setPhoneNumber(result.getString("phone_number"));
        r.setDays(result.getLong("open_days"));
        r.setHours(result.getLong("open_hours"));
        return r;
    }
}
