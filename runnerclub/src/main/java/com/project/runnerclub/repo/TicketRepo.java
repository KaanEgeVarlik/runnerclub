package com.project.runnerclub.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.runnerclub.entities.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long>{

	List<Ticket> findByUserId(Long long1);

}
