package com.gustavo.models;

import java.util.ArrayList;
import java.util.List;

public class Teamdb {
	
	private int id;
	private String Name;
	private List<Player> players = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	public void removePlayer(Player player) {
		this.players.remove(player.getId());
		for (int i = 0; i < this.players.size(); i++) {
			this.players.get(i).setId(i);
		}
	}
	
}
