package com.excella.foodinc.controller;

import com.excella.foodinc.object.Food;
import com.excella.foodinc.service.FoodService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class FoodController {

    private FoodService foodService = new FoodService();

    @RequestMapping(value="/nutrition")
    public Food retrieveFood(@RequestParam(value="name", required=false, defaultValue="pho") String name) {
        foodService.Initialize();
        return foodService.getFood(name);
    }


}
