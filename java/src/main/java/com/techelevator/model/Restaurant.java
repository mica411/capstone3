package com.techelevator.model;

public class Restaurant {

    // properties
    public Long resId;

    public String restaurantName;

    public String cuisineType;

    public String streetAddress;

    public String city;

    public String state;

    public Long zipCode;

    public String phoneNumber;

    public Long days;

    public Long hours;

    // constructors
    public Restaurant() {

    }
    public Restaurant(Long resId, String restaurantName, String cuisineType, String streetAddress, String city, String state, Long zipCode, String phoneNumber, Long days, Long hours) {
        this.resId = resId;
        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.days = days;
        this.hours = hours;
    }

    // getters and setters

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "resId=" + resId +
                ", restaurantName='" + restaurantName + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", days=" + days +
                ", hours=" + hours +
                '}';
    }
}
