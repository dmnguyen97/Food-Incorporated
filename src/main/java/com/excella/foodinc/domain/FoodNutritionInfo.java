package com.excella.foodinc.domain;

import lombok.*;
import org.springframework.data.annotation.Id;


@Value
public class FoodNutritionInfo {

    @Id private Long id;
    String name;
    int calories;
    int protein;
    int fat;
    int carbs;

    public FoodNutritionInfo(Long id, String name, int calories, int protein, int fat, int carbs) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }

}
