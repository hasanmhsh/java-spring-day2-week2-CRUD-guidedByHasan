package com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.repositories;

import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
//RestaurantRepository reads relational data in db amd maps it to java object
//itis object relational mapper ORM - Executed by Hibernate
public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {//Long is primary key type

}
