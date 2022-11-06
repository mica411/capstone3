package com.techelevator.controller;

import com.techelevator.dao.RestaurantDao;
import com.techelevator.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}

// I need a second set of eyes When someone has a chance to check my code off of the git repo. I can't figure out why I'm still getting a 404 in Postman.