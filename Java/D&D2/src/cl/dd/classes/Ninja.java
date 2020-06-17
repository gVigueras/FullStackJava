package cl.dd.classes;

import cl.dd.Human;

public class Ninja extends Human{
	private int stealth = 10;

	public void steal(Human human) {
		if(human.getHealth()>this.getStealth()) {
			this.setHealth(this.getHealth()+this.getStealth());
			human.setHealth(human.getHealth()-this.getStealth());
		}else if(human.getHealth()>0){
			this.setHealth(this.getHealth()+human.getHealth());
			human.setHealth(0);
		}
	}

	public void runAway() {
		this.setHealth(this.getHealth()-10);
	}
	
	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

}
