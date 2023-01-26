package com.project.runnerclub.requests;

import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class TicketBuyRequest {
	
	Long userId;
	Long id;
	String startingLocation;
	String destination;
	int hour;
	int seatNo;
	
	String pattern = "yyyy/MM/dd";
	SimpleDateFormat date = new SimpleDateFormat(pattern);
}
