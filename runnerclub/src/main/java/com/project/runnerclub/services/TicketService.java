package com.project.runnerclub.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.runnerclub.entities.Ticket;
import com.project.runnerclub.entities.User;
import com.project.runnerclub.repo.TicketRepo;
import com.project.runnerclub.requests.TicketBuyRequest;
import com.project.runnerclub.requests.TicketCancelRequest;
import com.project.runnerclub.requests.TicketPostponeRequest;
import com.project.runnerclub.responses.TicketResponse;

@Service
public class TicketService {

	private TicketRepo ticketRepo;
	private UserService userService;

	public TicketService(TicketRepo postRepo,UserService userService) {
		this.ticketRepo = ticketRepo;
		this.userService = userService;
	}

	public List<TicketResponse> getAllTickets(Optional<Long> userId) {
		List<Ticket> list;
		if(userId.isPresent()) {
			list = ticketRepo.findByUserId(userId.get());
		}else {
			list = ticketRepo.findAll();
		}
		return list.stream().map(t -> new TicketResponse(t)).collect(Collectors.toList());
	}
	
	public Ticket buyOneTicket(TicketBuyRequest newTicketRequest) {
		User user = userService.getOneUserById(newTicketRequest.getUserId());
		if(user == null) {
			return null;
		}
		Ticket toSave = new Ticket();
		toSave.setId(newTicketRequest.getId());
		toSave.setStartingLocation(newTicketRequest.getStartingLocation());
		toSave.setDestination(newTicketRequest.getDestination());
		toSave.setHour(newTicketRequest.getHour());
		toSave.setDate(newTicketRequest.getDate());
		toSave.setStatus("Active");
		toSave.setUser(user);
		return ticketRepo.save(toSave);
	}

	public Ticket postponeOneTicket(Long ticketId, TicketPostponeRequest postponeTicket) {
		Optional<Ticket> ticket = ticketRepo.findById(ticketId);
		if(ticket.isPresent()) {
			Ticket toUpdate = ticket.get();
			toUpdate.setStartingLocation(postponeTicket.getDestination());
			toUpdate.setDestination(postponeTicket.getDestination());
			toUpdate.setHour(postponeTicket.getHour());
			toUpdate.setDate(postponeTicket.getDate());
			toUpdate.setStatus("Postponed!");
			ticketRepo.save(toUpdate);
			return toUpdate;
		}
		return null;
	}
	public Ticket cancelOneTicket(Long ticketId, TicketCancelRequest cancelTicket) {
		Optional<Ticket> ticket = ticketRepo.findById(ticketId);
		if(ticket.isPresent()) {
			Ticket toUpdate = ticket.get();
			toUpdate.setStatus("Canceled!");
			ticketRepo.save(toUpdate);
			return toUpdate;
		}
		return null;
	}
}
