package cl.dd;

public class Human {
	
	private int intelligence = 3;
	private int stealth = 3;
	private int strength = 3;
	private int health = 100;

	public void attack(Human human) {
		human.setHealth(human.getHealth()-this.getStrength());
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getStealth() {
		return stealth;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
