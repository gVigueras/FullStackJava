package cl.dd;

import cl.dd.classes.*;

public class ddTest {

	public static void main(String[] args) {
		Samurai a = new Samurai();
		Wizard b = new Wizard();
		Ninja c = new Ninja();
		a.deathBlow(b);
		b.heal(b);
		b.fireBall(c);
		c.steal(a);
		System.out.println(a.getHealth()+" | "+b.getHealth()+" | "+c.getHealth());
	}

}
