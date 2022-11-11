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
//    List<Restaurant> restaurants = new ArrayList<>();
    // The DAO calls the JDBC Template
    private JdbcTemplate jdbcTemplate;
    // The DAO constructor sets the JDBC Template based on the datasource we've provided in the application properties
    public JdbcRestaurantDao(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
//        this.restaurants = findAllRestaurants();
    }
    // The DAO can list all of the restaurants currently populating the 'restaurants' Database
    @Override
    public List<Restaurant> list() {
        return findAllRestaurants(); // this method is called within this class (for now?), see below
    }
    // get & create were added in keeping with what appears to be a general model, and may not be necessary for an MVP
    // The DAO cannot yet return a Restaurant based on Id
    @Override
    public Restaurant get(int id) {
        return null;
    }

    // The DAO cannot yet create a Restaurant
    @Override
    public Restaurant create(Restaurant restaurant) {
        return null;
    }

    // This method will query the database and populate a list of restaurants with the results
    @Override
    public List<Restaurant> findAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();           // make a list
        String sql = "select * from restaurants";                   // write a SQL query
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);       // make a row_set object and query the database
        while (results.next()) {                                    // ↓ while the row_set finds a new line ↓
            restaurants.add(mapRowToRestaurant(results));           // add the current row from results to restaurants list
        }
        return restaurants;                                         // send back the data
    }
    @Override
    public List<Restaurant> findRestaurantByCity(String city) {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "select * from restaurants " +
                    "WHERE city ILIKE '?';";
        String searchCity = "%" + city + "%";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchCity);
        while (results.next()) {
            restaurants.add(mapRowToRestaurant(results));
        }
        List<Restaurant> matchCity = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getCity().equals(searchCity)) {
                matchCity.add(restaurant);
            }
        }
        return matchCity;
    }

    @Override
    public List<Restaurant> findRestaurantByZip(Integer searchZip) {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM restaurants " +
                "WHERE zip = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchZip);
        while (results.next()) {
            restaurants.add(mapRowToRestaurant(results));
        }
        List<Restaurant> matchZip = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getZipCode().equals(searchZip)) {
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
        // r.setDays(result.getLong("open_days"));
        // r.setHours(result.getLong("open_hours"));
        return r;
    }
}
