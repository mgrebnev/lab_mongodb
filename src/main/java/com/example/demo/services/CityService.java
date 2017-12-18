package com.example.demo.services;


import com.example.demo.models.City;
import com.example.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    public List<City> getAll(){
        return cityRepository.getAllCities();
    }

    public void saveCity(City city){
        cityRepository.saveCity(city);
    }

    public void removeCity(City city){
        cityRepository.removeCity(city);
    }
}
