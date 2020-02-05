package com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.controllers;

import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.models.Restaurant;
import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.services.RestaurantService;
import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    // GET http://localhost:PORT/rastaurants/restaurants
    @GetMapping(value = "/restaurants", produces =  {"application/json"})
    public ResponseEntity<?> listAllRestaurants(){
        return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
    }

    // GET http://localhost:PORT/rastaurants/restaurant/{id}
    @GetMapping(value = "/restaurant/{id}" , produces = {"application/json"})
    public ResponseEntity<?> getRestaurantById(@PathVariable long id){
        return new ResponseEntity<>(restaurantService.findById(id),HttpStatus.OK);
    }

    // POST http://localhost:PORT/rastaurants/restaurant //create restaurant
    @PostMapping(value = "/restaurant", consumes = {"application/json"})//consumes mean post request will have json object in its body so we want to wrap it
    public ResponseEntity<?> addNewRestaurant(@RequestBody Restaurant newRestaurant){//jackson framework is working here @RequestBody Restaurant newRestaurant to convert json to java object
        newRestaurant = restaurantService.save(newRestaurant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT http://localhost:PORT/rastaurants/restaurant/{id}  //update restaurant row data
    @PutMapping(value = "/restaurant/{id}" ,consumes = {"application/json"})
    public ResponseEntity<?> updateRestaurantById(@RequestBody Restaurant restaurant,
                                                  @PathVariable long id){
        restaurantService.update(restaurant,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE http://localhost:PORT/rastaurant/{id}
    @DeleteMapping(value = "/restaurant/{id}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable long id){
        restaurantService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
