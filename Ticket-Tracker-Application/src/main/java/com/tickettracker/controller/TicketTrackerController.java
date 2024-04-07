package com.tickettracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tickettracker.entity.Ticket;
import com.tickettracker.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketTrackerController {

	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/showtickets")
	public String ShowTickets(Model model) {
		List<Ticket> ticket = ticketService.findAll();
		model.addAttribute("tickets",ticket);
		return "tickets/ticket-list";		
	}
//	@GetMapping("/showticketById")
//	public String showticketById(@RequestParam("ticketId") int id, Model model) {
//		Optional<Ticket> ticket = Optional.ofNullable(ticketService.findById(id));
//		model.addAttribute("ticket", ticket);
//		return "tickets/showtickets";
//	}
	
	@PostMapping("/saveticket")
	public String SaveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.save(ticket);
		return "redirect:/tickets/showtickets";
	}
	
	@GetMapping("/showFormToAdd")
	public String ShowFormToAdd(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "tickets/create-ticket-form";
	}
	
	@PostMapping("/showFormToUpdate")
	public String ShowFormToUpdate(@RequestParam("ticketId") int id, Model model) {
		Ticket ticket = ticketService.findById(id);
		model.addAttribute("ticket", ticket);
		return "tickets/create-ticket-form";
	}
	

	@PostMapping("/delete")
	public String DeleteEmployee(@RequestParam("ticketId") int id) {
		ticketService.deleteById(id);
		return "redirect:/tickets/showtickets";
	}
	
}
