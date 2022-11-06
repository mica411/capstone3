package com.techelevator.controller;

import com.techelevator.dao.RestaurantDao;
import com.techelevator.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    List<Restaurant> restaurants;

    @Autowired
    RestaurantDao restaurantDao;

    public RestaurantController(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> findAll() {
        return restaurantDao.findAll();
    }

    @RequestMapping(value = "/{zipCode}", method = RequestMethod.GET)
    public List<Restaurant> findRestaurantByZip(@PathVariable Integer zipCode) {
        return restaurantDao.findRestaurantByZip(zipCode);
    }

//    @RequestMapping(value = "/{city}", method = RequestMethod.GET)
//    public List<Restaurant> findRestaurantByCity(@PathVariable String city) {
//        return restaurantDao.findRestaurantByCity(city);
//    }

//    @RequestMapping(value = "/{cuisineType}", method = RequestMethod.GET)
//    public List<Restaurant> findRestaurantByCuisine(@RequestParam String cuisineType) {
//        return restaurantDao.findRestaurantByCuisine(cuisineType);
//    }
}
