package com.poisonedyouth.fuzzytesting;

public class UserFactory {

	public static User create(String firstName, String lastName, int age) {
		return new User(firstName, lastName, age);
	}
}
