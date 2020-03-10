package com.gustavo.models;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;

public class User {
	private int clicks = 0;
	private Date date = null;
	private String word = "";

	public User(int clicks) {
		this.clicks = clicks;
	}

	public String generateWord() {
		String word = "";
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			word+= (char)('a' + rand.nextInt(26));
		}

			return word;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}


}
