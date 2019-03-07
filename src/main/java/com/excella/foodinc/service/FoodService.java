package com.excella.foodinc.service;


import com.excella.foodinc.object.Food;
import java.util.HashMap;


public class FoodService {

    private HashMap<String, Food> food;

    public void Initialize(){
       this.food = new HashMap<>();
       Food pizza = new Food("pizza", 10, 20, 30, 40);
       Food rice = new Food("rice", 200, 5, 2, 50);
       Food pho = new Food("pho", 600, 20, 50, 60);
       this.food.put("pizza", pizza);
       this.food.put("rice", rice);
       this.food.put("pho", pho);
   }

    public Food getFood(String name) {
        if ("pizza".equals(name)){
            return this.food.get("pizza");
        } else if ("rice".equals(name)) {
            return this.food.get("rice");
        } else {
            return this.food.get("pho");
        }
    }

}
