package com.gustavo.web.models;

public class Cat extends Animal implements Pet {

	public Cat(String name, String breed, int weight) {
		super(name, breed, weight);
	}

	@Override
	public void showAffection() {
		System.out.println("Meooow!");
	}

}
