package com.excella.foodinc;

import com.excella.foodinc.controller.FoodController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.excella.foodinc.object.Food;
import com.excella.foodinc.service.FoodService;
import reactor.test.StepVerifier;
import reactor.core.publisher.Mono;
import org.assertj.core.api.Assertions;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodIncApplicationTests {

	@Autowired
	FoodController foodController;

	@MockBean
	private FoodService foodService;

	@Test
	public void testShouldGetPizza() {

		Food testPizza = new Food("pizza", 10, 20, 30, 40);
		Food dummyPizza = new Food("pizza", 10, 20, 30, 40);
		Mono<Food> monoPizza = Mono.just(dummyPizza);


		when(foodService.getFood("pizza")).thenReturn(monoPizza);

		StepVerifier.create(foodService.getFood("pizza"))
				.assertNext(compare -> Assertions.assertThat(compare).isEqualToComparingFieldByField(testPizza))
				.verifyComplete();
	}

	@Test
	public void testShouldGetRice() {
		Food testRice = new Food("rice", 200, 5, 2, 50);
		Food dummyRice = new Food("rice", 200, 5, 2, 50);
		Mono<Food> monoRice = Mono.just(dummyRice);

		when(foodService.getFood("rice")).thenReturn(monoRice);

		StepVerifier.create(foodService.getFood("rice"))
				.assertNext(compare -> Assertions.assertThat(compare).isEqualToComparingFieldByField(testRice))
				.verifyComplete();

	}

	@Test
	public void testShouldGetPho() {
		Food testPho = new Food("pho", 600, 20, 50, 60);
		Food dummyPho = new Food("pho", 600, 20, 50, 60);
		Mono<Food> monoPho = Mono.just(dummyPho);

		when(foodService.getFood("pho")).thenReturn(monoPho);

		StepVerifier.create(foodService.getFood("pho"))
				.assertNext(compare -> Assertions.assertThat(compare).isEqualToComparingFieldByField(testPho))
				.verifyComplete();

	}


}

