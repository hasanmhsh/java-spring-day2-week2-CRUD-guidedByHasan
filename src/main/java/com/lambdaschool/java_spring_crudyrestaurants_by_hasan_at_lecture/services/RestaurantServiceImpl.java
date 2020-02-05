package com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.services;

import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.models.Menu;
import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.models.Restaurant;
import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "restaurantService")
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restrepo;

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> rtnList = new ArrayList<>();
        restrepo.findAll()
                .iterator()
                .forEachRemaining(rtnList::add);//(rtnList::add) is similar to (item->rtnList.add(item))
        return rtnList;
    }

    @Override
    public Restaurant findById(long id) {
        //You can do any thing with Optional object except converting it to java object
        return restrepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found " + id));
    }

    //@Transactional //means that all method statements must executed correctly with no errors , other wise don't execute any statement
    //@Transactional->commit when everything is successful and rolling back if anything goes wrong
    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant) {
        Restaurant newRestaurant = new Restaurant();

        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setState(restaurant.getState());
        newRestaurant.setTelephone(restaurant.getTelephone());

        //Doesnt work you need new object and sub objects
        //newRestaurant.setMenus(restaurant.getMenus());

        restaurant.getMenus().forEach(
                menu->{
                    newRestaurant.getMenus().add(new Menu(
                        menu.getDish(),
                        menu.getPrice(),
                        newRestaurant
                    ));
                }
        );
        return restrepo.save(newRestaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant, long id) {
        return restrepo.save(restaurant);
    }

    @Override
    public void delete(long id) {
        restrepo.deleteById(id);
    }
}
