package com.project.runnerclub.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.runnerclub.entities.Ticket;
import com.project.runnerclub.requests.TicketBuyRequest;
import com.project.runnerclub.requests.TicketCancelRequest;
import com.project.runnerclub.requests.TicketPostponeRequest;
import com.project.runnerclub.responses.TicketResponse;
import com.project.runnerclub.services.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	private TicketService ticketService;
	
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@GetMapping
	public List<TicketResponse> getAllTickets(@RequestParam Optional<Long> userId){
		return ticketService.getAllTickets(userId);
	}
	
	@PostMapping
	public Ticket buyOneTicket(@RequestBody TicketBuyRequest newTicketRequest) {
		return ticketService.buyOneTicket(newTicketRequest);
	}
	
	@PutMapping("/{ticketId}")
	public Ticket postponeOneTicket(@PathVariable Long ticketId, @RequestBody TicketPostponeRequest postponeTicket) {
		return ticketService.postponeOneTicket(ticketId, postponeTicket);
	}
	
	@PutMapping("/{ticketId}")
	public Ticket cancelOneTicket(@PathVariable Long ticketId, @RequestBody TicketCancelRequest cancelTicket) {
		return ticketService.cancelOneTicket(ticketId, cancelTicket);
	}
}
