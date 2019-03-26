package com.excella.foodinc.service;


import com.excella.foodinc.object.Food;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import java.util.HashMap;

@Service
public class FoodService {

    private HashMap<String, Food> food;

    public Mono<Food> getFood(String name) {
        this.food = new HashMap<>();
        Food pizza = new Food("pizza", 10, 20, 30, 40);
        Food rice = new Food("rice", 200, 5, 2, 50);
        Food pho = new Food("pho", 600, 20, 50, 60);
        this.food.put("pizza", pizza);
        this.food.put("rice", rice);
        this.food.put("pho", pho);

        if ("pizza".equals(name)){
            return Mono.just(food.get("pizza"));
        } else if ("rice".equals(name)) {
            return Mono.just(food.get("rice"));
        } else {
            return Mono.just(food.get("pho"));
        }
    }

}
