package cl.zoo;

public class Gorilla extends Mammal{
	void throwSomething() {
		super.setEnergy(super.getEnergy()-5);
		System.out.println("¡El gorila ha lanzado algo!");
	}

	void eatBananas() {
		System.out.println("El gorila se ve muy satisfecho con la banana que comió");
		super.setEnergy(super.getEnergy()+10);
	}

	void climb() {
		System.out.println("¡El gorila trepó a la cima del árbol!");
		super.setEnergy(super.getEnergy()-10);
	}
}
