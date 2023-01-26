package com.project.runnerclub.responses;

import java.text.SimpleDateFormat;

import com.project.runnerclub.entities.Ticket;

import lombok.Data;

@Data
public class TicketResponse {

	Long id;
	Long userId;
	String startingLocation;
	String destination;
	String status;
	int hour;
	int seatNo;
	String pattern = "yyyy/MM/dd";
	SimpleDateFormat date = new SimpleDateFormat(pattern);
	
	public TicketResponse(Ticket entity) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.startingLocation = entity.getStartingLocation();
		this.destination = entity.getDestination();
		this.status = entity.getStatus();
		this.date = entity.getDate();
		this.seatNo = entity.getSeatNo();
	}
}
