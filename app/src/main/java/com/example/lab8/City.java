package com.example.lab8;

public class City implements Comparable{

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * A city is equal to another city if it's city string is equal
     */
    private Boolean cityEquals(City cityobj) {
        return this.city.equals(cityobj.city);
    }

    /**
     * Two cities have equal hashcodes if their city strings have equal hashcodes
     */
    @Override
    public int hashCode() {
        return this.city.hashCode();
    }
    /**
     * A city is equal to another city if it's city string is equal
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof City) {
            return cityEquals((City) o);
        }
        else {
            return false;
        }
    }
}
