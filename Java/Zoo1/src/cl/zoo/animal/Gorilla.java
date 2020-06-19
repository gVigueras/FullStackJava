package cl.zoo.animal;

public class Gorilla extends Mammal{
	public void throwSomething() {
		super.setEnergy(super.getEnergy()-5);
		System.out.println("¡El gorila ha lanzado algo!");
	}

	public void eatBananas() {
		System.out.println("El gorila se ve muy satisfecho con la banana que comió");
		super.setEnergy(super.getEnergy()+10);
	}

	public void climb() {
		System.out.println("¡El gorila trepó a la cima del árbol!");
		super.setEnergy(super.getEnergy()-10);
	}
}
