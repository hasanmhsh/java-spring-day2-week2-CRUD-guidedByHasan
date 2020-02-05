package com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.repositories;

import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {//class version of id type is Long

}
