package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class holds the City type objects in a list
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a city object to the cities list.
     * @param city This is a City object we want to add to the list
     * @throws IllegalArgumentException if the city already is in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This method sorts the list of cities and returns it.
     * @return a sorted list of the cities
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Check whether a given city is in the city list.
     * @param city The city to check for.
     * @return true if the city is in the list, false otherwise.
     */
    public boolean hasCity(City city) {
        for (City c : cities) {
            if (c.equals(city)) return true;
        }
        return false;
    }

    /**
     * Deletes the given city from the list.
     * @param city The city to delete.
     * @throws IllegalArgumentException if the city is not in the list.
     */
    public void delete(City city) {
        // See if the city is in there and remove it if it is
        for (City c : cities) {
            if (c.equals(city)) {
                cities.remove(c);
                return;
            }
        }

        // If we get here, then the city is not in there
        throw new IllegalArgumentException();
    }

    /**
     * Counts the number of cities stored in the list.
     * @return the number of cities.
     */
    public int countCities() {
        return cities.size();
    }
}
