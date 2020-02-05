package com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture;

//this class to initialize database with sample data at first run

import com.github.javafaker.Faker;
import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.models.Menu;
import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.models.Restaurant;
import com.lambdaschool.java_spring_crudyrestaurants_by_hasan_at_lecture.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
//CommandLineRunner
//CommandLineRunner is an interface used to indicate that a bean should run when it is contained within a SpringApplication. A Spring Boot application can have multiple beans implementing CommandLineRunner. These can be ordered with @Order.
// is a special interface in spring that runs once and runs before spring boot takes off
@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    /**
     * Connects the Restaurant Service to this process
     */
    @Autowired
    private RestaurantService restaurantService;



    /**
     * A Random generator is needed to randomly generate faker data.
     */
    private Random random = new Random();

    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Override
    public void run(String[] args)
    {
        // This will print to the console the seed data
        List<Restaurant> printList = restaurantService.findAll();
        System.out.println("\n********** From data.sql SEED DATA **********");
        for (Restaurant r : printList)
        {
            System.out.println(r);
        }
        System.out.println("********** From data.sql SEED DATA **********\n");


        // Restaurant String name, String address, String city, String state, String telephone
        // scope of r variables
        {
            Restaurant r1 = new Restaurant("Apple",
                    "123 Main Street",
                    "City",
                    "ST",
                    "555-555-1234");
            r1.getMenus()
                    .add(new Menu("Mac and Cheese",
                            6.95,
                            r1));
            r1.getMenus()
                    .add(new Menu("Lasagna",
                            8.50,
                            r1));
            r1.getMenus()
                    .add(new Menu("Meatloaf",
                            7.77,
                            r1));
            r1.getMenus()
                    .add(new Menu("Tacos",
                            8.49,
                            r1));
            r1.getMenus()
                    .add(new Menu("Chef Salad",
                            12.50,
                            r1));

            restaurantService.save(r1);
        }

        Restaurant r2 = new Restaurant("Eagle Cafe",
                "321 Uptown Drive",
                "Town",
                "ST",
                "555-555-5555");
        r2.getMenus()
                .add(new Menu("Tacos",
                        10.49,
                        r2));
        r2.getMenus()
                .add(new Menu("Barbacoa",
                        12.75,
                        r2));
        restaurantService.save(r2);

        Restaurant r3 = new Restaurant("Number 1 Eats",
                "565 Side Avenue",
                "Village",
                "ST",
                "555-123-1555");
        r3.getMenus()
                .add(new Menu("Pizza",
                        15.15,
                        r3));
        restaurantService.save(r3);

        // This will print to the console the seed data
        printList = restaurantService.findAll();
        System.out.println("\n********** Standard SEED DATA **********");
        for (Restaurant r : printList)
        {
            System.out.println(r);
        }
        System.out.println("********** Standard SEED DATA **********\n");


        // using JavaFaker create a bunch of regular users
        // https://www.baeldung.com/java-faker
        // https://www.baeldung.com/regular-expressions-java




        // This will print to the console the seed data
        printList = restaurantService.findAll();
        System.out.println("\n********** Final SEED DATA **********");
        for (Restaurant r : printList)
        {
            System.out.println(r);
        }
        System.out.println("********** Final SEED DATA **********\n");
    }
}

