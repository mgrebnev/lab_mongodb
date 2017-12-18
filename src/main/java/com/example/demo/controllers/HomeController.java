package com.example.demo.controllers;

import com.example.demo.models.City;
import com.example.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private CityService cityService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/city")
    public String city(Map<String, Object> model){
        List<City> cityList = cityService.getAll();
        model.put("cities",cityList);
        return "city";
    }

    @PostMapping("/city/update")
    public String updateCity(@RequestParam("id") String id, @RequestParam("city") String city){
        cityService.saveCity(new City(id,city));
        return "redirect:/home/city";
    }

    @PostMapping("/city/add")
    public String addCity(@RequestParam("nameCity") String city){
        cityService.saveCity(new City(null,city));
        return "redirect:/home/city";
    }

    @GetMapping("/city/delete")
    public String deleteCity(@RequestParam("id") String id){
        cityService.removeCity(new City(id,null));
        return "redirect:/home/city";
    }
}
