package cl;

import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {

	private int myPokemons = Pokemon.getCount();
	private ArrayList<Pokemon> pokeList = new ArrayList<Pokemon>();

	public void listPokemon() {
		for (int i = 0; i < pokeList.size(); i++) {
			if(pokeList.get(i).getHealth()<=0)
				pokeList.remove(i);
		}
		System.out.println("--------------");
		for (Pokemon pokemon : pokeList) {
			System.out.println(super.pokemonInfo(pokemon)+"\n--------------");
		}
	}

	public int getMyPokemons() {
		return myPokemons;
	}

	public void setMyPokemons(int myPokemons) {
		this.myPokemons = myPokemons;
	}

	public ArrayList<Pokemon> getPokeList() {
		return pokeList;
	}

	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon pokemon = super.createPokemon(name, health, type);
		this.pokeList.add(pokemon);
		return pokemon;
	}

}
