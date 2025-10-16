package com.example.listycity;

import java.util.Objects;

/**
 * This class represents a City
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructs a new city object from the given information
     * @param city The city name
     * @param province The province of the city
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the province name
     * @return the province name
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method compares City objects based on their cityname field.
     * @param city The city to compare against.
     * @return 0, less than 1, or greater than 1 if the two cities are equal,
     *         a less than b, or a greater than b respectively.
     */
    @Override
    public int compareTo(City city) {
        return this.getCity().compareTo(city.getCity());
    }

    /**
     * Checks whether a given object is equal to this City. Compares the city name and
     * province attributes.
     * @param o The object to compare with
     * @return true if it is equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        City city = (City) o;
        return Objects.equals(getCity(), city.getCity())
                && Objects.equals(getProvince(), city.getProvince());
    }
}
