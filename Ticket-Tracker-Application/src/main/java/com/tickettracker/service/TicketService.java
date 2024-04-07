package com.tickettracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettracker.dao.TicketRepository;
import com.tickettracker.entity.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	public Ticket findById(int id) {
		Optional<Ticket> result = ticketRepository.findById(id);
		Ticket ticket = null;
		if (result.isPresent()) {
			ticket = result.get();
		} else {
			throw new RuntimeException("Did not find the ticket ");
		}
		return ticket;

	}
	public void save(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	// update
//	public List<Employee> update() {
//
//	}

	// delete
	public void deleteById(int Id) {
		ticketRepository.deleteById(Id);
	}

}
