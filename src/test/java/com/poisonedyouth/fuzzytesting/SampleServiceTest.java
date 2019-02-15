package com.poisonedyouth.fuzzytesting;

import com.redfin.fuzzy.Any;
import com.redfin.fuzzy.Generator;
import com.redfin.fuzzy.junit.FuzzyRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleServiceTest {

	// https://github.com/redfin/fuzzy#user-content-use-with-junit

	@Autowired
	private SampleService sampleService;

	@Rule
	public FuzzyRule fuzzyRule = FuzzyRule.DEFAULT;

	@Test
	public void doSomething() {
		Generator<String> myString = Generator.of(Any.string());

		String value = myString.get();
		System.out.println("Value:" + value);
		boolean result = sampleService.doSomething(value);
		assertThat(result).isTrue();
	}

	@Test
	public void sum() {
		Generator<Integer> valueA = Generator.of(Any.integer().inRange(1, 50));
		Generator<Integer> valueB = Generator.of(Any.integer().inRange(1, 50));

		Integer a = valueA.get();
		System.out.println("ValueA: " + a);
		Integer b = valueB.get();
		System.out.println("ValueB: " + b);
		Integer result = sampleService.sum(a, b);
		assertThat(result).isLessThanOrEqualTo(100);
	}

	@Test
	public void printUser() {
		Generator<String> firstName = Generator.of(Any.string().withOnlyAlphabetChars().withLength(16));
		Generator<String> lastName = Generator.of(Any.string().withOnlyAlphanumericChars().withLength(16));
		Generator<Integer> age = Generator.of(Any.integer().inRange(0, 100));

		String userPrint = sampleService.printUser(UserFactory.create(firstName.get(), lastName.get(), age.get()));
		System.out.println("User : " + userPrint);
		assertThat(userPrint).doesNotContain("null");
	}
}