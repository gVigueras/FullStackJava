package cl.zoo;

public class Mammal {
	private int energyLevel = 100;

	void displayEnergy() {
		System.out.println("El nivel de energía es: "+this.energyLevel);
	}

	public int getEnergy() {
		return energyLevel;
	}

	public void setEnergy(int energy) {
		this.energyLevel = energy;
	}
}
