package com.example.demo.repositories;


import com.example.demo.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class InitRecordsRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void initRecords(){
        mongoTemplate.dropCollection("city");
        mongoTemplate.insert(new City(null,"Белгород"));
        mongoTemplate.insert(new City(null,"Москва"));
        mongoTemplate.insert(new City(null,"Санк-Петербург"));
    }
}
