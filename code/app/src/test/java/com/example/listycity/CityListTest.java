package com.example.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CityListTest {
    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        City c = new City("Calgary", "AB");

        // Test if the mock city is in there (it should)
        assertTrue(cityList.hasCity(mockCity()));

        // Calgary not in there yet
        assertFalse(cityList.hasCity(c));

        cityList.add(c);
        assertTrue(cityList.hasCity(c));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();

        City c = new City("Calgary", "AB");

        // Delete city thats not in there
        assertEquals(1, cityList.getCities().size());
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(c);
        });
        assertEquals(1, cityList.getCities().size());

        // Add and delete it
        cityList.add(c);
        cityList.delete(c);
        assertEquals(1, cityList.getCities().size());

        // Delete the mock city
        cityList.delete(mockCity());
        assertEquals(0, cityList.getCities().size());
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        City c1 = new City("Calgary", "AB");
        City c2 = new City("Vancouver", "BC");

        cityList.add(c1);
        assertEquals(2, cityList.countCities());

        cityList.delete(c1);
        assertEquals(1, cityList.countCities());

        cityList.add(c2);
        assertEquals(2, cityList.countCities());

        cityList.delete(mockCity());
        assertEquals(1, cityList.countCities());

        cityList.delete(c2);
        assertEquals(0, cityList.countCities());
    }
}
