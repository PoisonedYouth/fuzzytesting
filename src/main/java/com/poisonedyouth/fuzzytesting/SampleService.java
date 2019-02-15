package com.poisonedyouth.fuzzytesting;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

	public boolean doSomething(String value) {
		return value != null;
	}

	public int sum(int a, int b) {
		return a + b;
	}

	public String printUser(User user) {
		return "Firstname: " + user.getFirstName() + ", Lastname: " + user.getLastName() + ", Age: " + user.getAge();
	}
}
