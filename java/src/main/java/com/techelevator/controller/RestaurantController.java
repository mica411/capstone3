package com.techelevator.controller;

import com.techelevator.dao.JdbcRestaurantDao;
import com.techelevator.dao.RestaurantDao;
import com.techelevator.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// We have declared this as a RestController and implemented the top level API request mapping
@RestController
@CrossOrigin
@RequestMapping("/api/restaurants")
public class RestaurantController {

//    List<Restaurant> restaurants;

    @Autowired
    RestaurantDao restaurantDao;

    public RestaurantController(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Restaurant> list() {
        return restaurantDao.list();
    }

    @RequestMapping(path = "zip/{zipCode}", method = RequestMethod.GET)
    public List<Restaurant> findRestaurantByZip(@PathVariable Integer zipCode) {
        return restaurantDao.findRestaurantByZip(zipCode);
    }

    @RequestMapping(path = "city/{city}", method = RequestMethod.GET)
    public List<Restaurant> findRestaurantByCity(@PathVariable String city) {
        return restaurantDao.findRestaurantByCity(city);
    }

    @RequestMapping(value = "cuisine/{cuisineType}", method = RequestMethod.GET)
    public List<Restaurant> findRestaurantByCuisine(@PathVariable String cuisineType) {
        return restaurantDao.findRestaurantByCuisine(cuisineType);
    }
}
