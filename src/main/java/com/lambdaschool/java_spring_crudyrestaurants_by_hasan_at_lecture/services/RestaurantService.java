package com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.services;

import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAll();
    Restaurant findById(long id);
    Restaurant save(Restaurant restaurant);
    Restaurant update(Restaurant restaurant,long id);
    void delete(long id);
}
