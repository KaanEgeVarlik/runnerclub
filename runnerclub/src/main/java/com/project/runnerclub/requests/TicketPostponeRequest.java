package com.project.runnerclub.requests;

import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class TicketPostponeRequest {
	
	String status;
	String destination;
	int hour;
	
	String pattern = "yyyy/MM/dd";
	SimpleDateFormat date = new SimpleDateFormat(pattern);
}
