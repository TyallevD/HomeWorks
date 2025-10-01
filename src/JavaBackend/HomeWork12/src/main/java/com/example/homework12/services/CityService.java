package com.example.homework12.services;

import com.example.homework12.entities.City;
import com.example.homework12.repository.CityRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

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
}
