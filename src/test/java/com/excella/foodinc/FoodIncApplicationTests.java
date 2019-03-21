package com.excella.foodinc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.excella.foodinc.controller.FoodController;
import com.excella.foodinc.object.Food;
import com.excella.foodinc.service.FoodService;
import reactor.test.StepVerifier;
import reactor.core.publisher.Mono;
import org.assertj.core.api.Assertions;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodIncApplicationTests {

	@MockBean
	private FoodService foodService;

	@Autowired
	private FoodController retrieveFood;

	@Test
	public void testShouldGetPizza() {

		Food testPizza = new Food("pizza", 10, 20, 30, 40);
		Food dummyPizza = new Food("pizza", 10, 20, 30, 40);
		Mono<Food> monoPizza = Mono.just(testPizza);

		when(foodService.getFood("pizza")).thenReturn(dummyPizza);

		StepVerifier.create(monoPizza)
				.assertNext(compare -> Assertions.assertThat(compare).isEqualToComparingFieldByField(testPizza))
				.verifyComplete();
	}

	@Test
	public void testShouldGetRice() {
		Food testRice = new Food("rice", 200, 5, 2, 50);
		Food dummyRice = new Food("rice", 200, 5, 2, 50);
		Mono<Food> monoRice = Mono.just(testRice);

		when(foodService.getFood("rice")).thenReturn(dummyRice);

		StepVerifier.create(monoRice)
				.assertNext(compare -> Assertions.assertThat(compare).isEqualToComparingFieldByField(testRice))
				.verifyComplete();

	}

	@Test
	public void testShouldGetPho() {
		Food testRice = new Food("pho", 200, 5, 2, 50);
		Food dummyRice = new Food("pho", 200, 5, 2, 50);
		Mono<Food> monoRice = Mono.just(testRice);

		when(foodService.getFood("rice")).thenReturn(dummyRice);

		StepVerifier.create(monoRice)
				.assertNext(compare -> Assertions.assertThat(compare).isEqualToComparingFieldByField(testRice))
				.verifyComplete();

	}


}

