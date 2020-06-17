package com.gustavo.web.models;

public class Dog extends Animal implements Pet {

	public Dog(String name, String breed, int weight) {
		super(name, breed, weight);
	}

	@Override
	public String showAffection() {
		if(this.getWeight()<30)
			return (this.getName()+" saltó emocionado a tus brazos!");
		else
			return (this.getName()+" se pasea entre tus piernas.");
	}

}
