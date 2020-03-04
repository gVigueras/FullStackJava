package cl;

public class PokeTest {

	public static void main(String[] args) {

		Pokedex pokedex = new Pokedex();
		Pokemon a = pokedex.createPokemon("Bulbasaur", 100, "Hoja");
		Pokemon b = pokedex.createPokemon("Squirtle", 100, "Agua");
		
		a.attackPokemon(b);
		pokedex.listPokemon();
		
	}

}
