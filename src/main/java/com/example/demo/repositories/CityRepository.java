package com.example.demo.repositories;


import com.example.demo.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<City> getAllCities(){
        return mongoTemplate.findAll(City.class);
    }

    public void saveCity(City city){
        mongoTemplate.save(city);
    }

    public void removeCity(City city){
        mongoTemplate.remove(city);
    }
}
