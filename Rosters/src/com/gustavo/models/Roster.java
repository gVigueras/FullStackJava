package com.gustavo.models;

import java.util.ArrayList;
import java.util.List;

public class Roster {
	
	private static List<Teamdb> teams = new ArrayList<>();

	public static List<Teamdb> getTeams() {
		return teams;
	}

	public static void addTeam(String teamName) {
		Teamdb team = new Teamdb();
		team.setName(teamName);
		team.setId(teams.size());
		Roster.teams.add(team);
	}
	public static void removeTeam(Teamdb team) {
		Roster.teams.remove(team.getId());
		for (int i = 0; i < teams.size(); i++) {
			teams.get(i).setId(i);
		}
	}
}
