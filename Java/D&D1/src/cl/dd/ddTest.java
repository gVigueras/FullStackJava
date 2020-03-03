package cl.dd;

public class ddTest {

	public static void main(String[] args) {
		Human a = new Human();
		Human b = new Human();
		
		a.attack(b);
		System.out.println(b.getHealth());
	}

}
