package com.gustavo.models;

import java.util.ArrayList;
import java.util.List;

public class Timer {

	private static List<TimerLog> list = new ArrayList<>();

	public static List<TimerLog> getList() {
		return list;
	}

	public static void setList(List<TimerLog> list) {
		Timer.list = list;
	}

	public static void addLog(TimerLog timer) {
		list.add(timer);
	}
	
	public static void reset() {
		while(!list.isEmpty()) {
			list.remove(0);	
		}
	}
}
