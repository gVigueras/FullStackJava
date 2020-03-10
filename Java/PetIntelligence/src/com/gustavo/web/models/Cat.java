package com.gustavo.web.models;

public class Cat extends Animal implements Pet {

	public Cat(String name, String breed, int weight) {
		super(name, breed, weight);
	}

	@Override
	public String showAffection() {
		return (this.getName()+" parece mirarte con algo de afecto");
	}

}
