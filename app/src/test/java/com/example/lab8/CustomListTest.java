package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        list = MockCityList();
        City city1 = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city1);

        City city2 = new City("Charlottetown", "Maine");

        assertEquals(true, list.hasCity(city1));
        assertEquals(true, list.hasCity(city2));
    }

    @Test
    void testDeleteCity() {
        list = MockCityList();
        City city1 = new City("Charlottetown", "Prince Edward Island");
        City city2 = new City("Charlottetown", "Maine");
        list.addCity(city1);
        list.deleteCity(city2);
        assertEquals(list.getCities().size(),1);

        City city3 = new City("Paris", "Ille-de-France");
    }

    @Test
    void testCountCities() {
        list = MockCityList();
        assertEquals(list.countCities(), 0);
        City city1 = new City("Charlottetown", "Prince Edward Island");
        City city2 = new City("Lloydminster", "Alberta");
        list.addCity(city1);
        list.addCity(city2);
        assertEquals(list.countCities(), 2);
    }
}
