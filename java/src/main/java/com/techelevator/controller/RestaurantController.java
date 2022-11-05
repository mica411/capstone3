package com.techelevator.controller;

import com.techelevator.dao.RestaurantDao;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/restaurants")
public class RestaurantController {

    private RestaurantDao restaurantDao;


}
