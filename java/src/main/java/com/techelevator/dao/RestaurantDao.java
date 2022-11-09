package com.techelevator.dao;

import com.techelevator.model.Restaurant;

import java.util.List;

public interface RestaurantDao {

    List<Restaurant> list();

    Restaurant get(int id);

    Restaurant create(Restaurant restaurant);

    List<Restaurant> findAllRestaurants();

    List<Restaurant> findRestaurantByCity(String city);

    List<Restaurant> findRestaurantByZip(Integer zipCode);

    List<Restaurant> findRestaurantByCuisine(String cuisineType);
}
