package cl.zoo.animal;

public class Mammal {
	private int energyLevel = 100;

	public void displayEnergy() {
		System.out.println("El nivel de energía es: "+this.getEnergy());
	}

	protected int getEnergy() {
		return energyLevel;
	}

	protected void setEnergy(int energy) {
		this.energyLevel = energy;
	}
}
