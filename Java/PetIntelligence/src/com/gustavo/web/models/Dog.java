package com.gustavo.web.models;

public class Dog extends Animal implements Pet {

	public Dog(String name, String breed, int weight) {
		super(name, breed, weight);
	}

	@Override
	public void showAffection() {
		System.out.println("Woof woof");
	}

}
