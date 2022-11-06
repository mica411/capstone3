package com.techelevator.dao;

import com.techelevator.model.Restaurant;

import java.util.List;

public interface RestaurantDao {

    List<Restaurant> findAll();

    List<Restaurant> findRestaurantByCity(String city);

    List<Restaurant> findRestaurantByZip(Integer zipCode);

    List<Restaurant> findRestaurantByCuisine(String cuisineType);
}
