package cl.zoo;

public class Bat extends Mammal{
	private int energyLevel = 300;

	public void fly() {
		System.out.println("flap flap flap flap flap");
		this.energyLevel = this.energyLevel-50;
	}
	
	public void eatHumans() {
		System.out.println("Bueno...no importa");
		this.energyLevel = this.energyLevel+25;
	}
	
	public void attackTown() {
		System.out.println("Porque la calle bota fuego, fuego, ¡fire, fire!");
		this.energyLevel = this.energyLevel-100;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
