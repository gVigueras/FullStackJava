package cl.zoo;

public class Mammal {
	private int energyLevel = 100;

	void displayEnergy() {
		System.out.println("El nivel de energ�a es: "+this.energyLevel);
	}

	protected int getEnergy() {
		return energyLevel;
	}

	protected void setEnergy(int energy) {
		this.energyLevel = energy;
	}
}
