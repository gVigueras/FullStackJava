package cl.dd.classes;

import cl.dd.Human;

public class Wizard extends Human{
	private int health = 50;
	private int intelligence = 8;
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public void heal(Human human) {
		human.setHealth(human.getHealth()+this.getIntelligence());
	}
	
	public void fireBall(Human human) {
		human.setHealth(human.getHealth()-(this.getIntelligence()*3));
	}
}
