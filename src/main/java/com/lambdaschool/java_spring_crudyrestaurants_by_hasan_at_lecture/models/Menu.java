package com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuid;

    @Column(nullable = false)
    private String dish;

    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurantid", nullable = false)
    @JsonIgnoreProperties("menus") // without this returned json object will contain infinite recursive restaurant -> menue -> restaurant -> menue ..and so on , so it telling jackson to ignore printing this property in json
                                    //"menus" because the name of Menue list field inside Restaurant is named menus , so we braking the loop inside printed json object
    private Restaurant restaurant;

    public Menu() {
    }

    public Menu(String dish, double price, Restaurant restaurant) {
        this.dish = dish;
        this.price = price;
        this.restaurant = restaurant;
    }

    public long getMenuid() {
        return menuid;
    }

    public void setMenuid(long menuid) {
        this.menuid = menuid;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
