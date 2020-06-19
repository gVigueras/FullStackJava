package com.gustavo.models;

import java.util.Random;

public class User {
	private int attempts = 0;
	private int number = Integer.MIN_VALUE;
	private int lastTry = (int)Double.NaN;
	
	//-1 si es menor, 1 si es mayor, 0 si acertó, 2 si se acabaron los intentes.
	private String flag = "";

	public User(int attempts, int minor, int mayor) {
		this.attempts = attempts;
		this.number = this.generateNumber(minor, mayor);
	}

	public int generateNumber(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getLastTry() {
		return lastTry;
	}

	public void setLastTry(int lastTry) {
		this.lastTry = lastTry;
		if(this.attempts == 9)
			setFlag("Te quedaste sin intentos!");
		else if(lastTry == this.number)
			setFlag("Lo lograste!");
		else if(lastTry > this.number)
			setFlag("Muy Alto!");
		else
			setFlag("Muy bajo!");
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
