package cl;

public class Pokemon {
	private int health;
	private String name;
	private String type;
	private static int count;
	
	public Pokemon(String name, int health, String type) {
		this.health = health;
		this.name = name;
		this.type = type;
		Pokemon.setCount(Pokemon.getCount() + 1);
	}

	public void attackPokemon(Pokemon pokemon) {
		pokemon.setHealth(pokemon.getHealth()-10);
		if(pokemon.getHealth()<=0)
			System.out.println("Se murió!");
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Pokemon.count = count;
	}
}
