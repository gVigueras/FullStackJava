package cl.dd.classes;

import cl.dd.Human;

public class Samurai extends Human{

	private int health = 200;
	
	public void deathBlow(Human human) {
		human.setHealth(0);
		this.setHealth(this.getHealth()/2);
	}
	
	public void meditate() {
		this.setHealth(this.getHealth()*3/2);
	}
	
	public int howMany() {
		return this.getHealth();
	}
}
