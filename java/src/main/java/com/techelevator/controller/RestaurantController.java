package com.techelevator.controller;

import com.techelevator.dao.RestaurantDao;
import com.techelevator.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
        return restaurants;
    }
}

