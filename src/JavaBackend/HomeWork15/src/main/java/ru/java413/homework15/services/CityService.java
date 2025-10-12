package ru.java413.homework15.services;

import ru.java413.homework15.entities.City;
import ru.java413.homework15.repository.CityRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private Faker faker;

    public List<City> addFifteenCities() {
        if (cityRepository.count() < 15) {
            List<City> cities = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                String name = faker.address().cityName();
                cities.add(new City(name));
            }
            return cityRepository.saveAll(cities);
        }
        return null;
    }

    public City getCityById() {
        Random random = new Random();
        Long id = random.nextLong(15) + 1;
        return cityRepository.getReferenceById(id);
    }
}
