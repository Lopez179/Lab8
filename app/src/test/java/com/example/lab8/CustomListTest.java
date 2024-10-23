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
        CustomList cityList = MockCityList();
        City city1 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city1);

        City city2 = new City("Charlottetown", "Maine");

        assertEquals(true, cityList.hasCity(city1));
        assertEquals(true, cityList.hasCity(city2));
    }

    @Test
    void testDeleteCity() {
        CustomList cityList = MockCityList();
        City city1 = new City("Charlottetown", "Prince Edward Island");
        City city2 = new City("Charlottetown", "Maine");
        cityList.add(city1);
        cityList.deleteCity(city2);
        assertEquals(cityList.getCities().size(),1);

        City city3 = new City("Paris", "Ille-de-France");
        assertThrows(IllegalArgumentException.class, () -> {cityList.deleteCity(city3);});
    }

    @Test
    void testCountCities() {
        CustomList cityList = MockCityList();
        assertEquals(cityList.CountCities(), 0);
        City city1 = new City("Charlottetown", "Prince Edward Island");
        City city2 = new City("Lloydminster", "Alberta");
        cityList.addCity(city1);
        cityList.addCity(city2);
        assertEquals(cityList.CountCities(), 2);
    }
}
