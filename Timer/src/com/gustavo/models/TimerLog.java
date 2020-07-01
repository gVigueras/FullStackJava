package com.gustavo.models;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class TimerLog {

	private LocalTime startTime;
	private LocalTime endTime;
	private String total;
	
	public TimerLog(LocalTime start) {
		this.startTime = start.truncatedTo(ChronoUnit.SECONDS);
		this.endTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		long millis = this.startTime.until(this.endTime, ChronoUnit.MILLIS);;
		this.total = String.format("%02d min, %02d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(millis),
			    TimeUnit.MILLISECONDS.toSeconds(millis) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
			);
	}
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	
}
