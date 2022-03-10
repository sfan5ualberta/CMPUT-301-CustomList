import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.countCities();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(listSize+1, list.countCities());
    }

    @Test
    void testHasCity() {
        City city = new City("Edmonton", "Alberta");
        assertFalse(list.hasCity(city));
        City city_2 = new City("Vancouver", "British Columbia");
        assertFalse(list.hasCity(city_2));
        list.add(city_2);
        assertTrue(list.hasCity(city_2));
    }

    @Test
    void testDelete() {
        City city = new City("Vancouver", "British Columbia");
        list.add(city);
        assertTrue(list.hasCity(city));
        list.delete(city);
        assertFalse(list.hasCity(city));
        City city_3 = new City("Calgary", "Alberta");
        assertThrows(IllegalArgumentException.class, ()->{
            list.delete(city_3);
        });
    }

    @Test
    void testCountCities(){
        assertEquals(0, list.countCities());
        City city = new City("Vancouver", "British Columbia");
        list.add(city);
        assertEquals(1, list.countCities());
        list.delete(city);
        assertEquals(0, list.countCities());
        City city_2 = new City("Calgary", "Alberta");
        list.add(city_2);
        City city_3 = new City("Iqaluit", "Nunavut");
        list.add(city_3);
        assertEquals(2, list.countCities());
    }




}
