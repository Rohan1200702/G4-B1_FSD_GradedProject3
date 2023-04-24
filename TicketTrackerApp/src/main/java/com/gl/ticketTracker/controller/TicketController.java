/**
 * @author Rohan Chakraborty, Lalita Choudhary
 * Date: 17-04-2023
 * This is controller class to map the web end points
 */
package com.gl.ticketTracker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.ticketTracker.model.TicketTracker;
import com.gl.ticketTracker.service.TicketTrackerService;

@Controller
@RequestMapping("/admin/tickets")
public class TicketController {
	TicketTrackerService ticketService;
	boolean update, view;
	int ticketId;

	public TicketController(TicketTrackerService ticketService) {
		super();
		this.ticketService = ticketService;
	}

	// show all tickets from database
	@GetMapping("")
	public String showEmpList(Model model) {
		model.addAttribute("tick", ticketService.getAllTickets());
		return "ticket";
	}

	// display new page to create new tickets
	@GetMapping("/newTickets")
	public String createNewTicket(Model model) {
		model.addAttribute("ticket", new TicketTracker());
		return "newticket";
	}

	// save new ticket to database when creating only
	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("ticket") TicketTracker ticket) {
		if (update)
			ticketService.editTicket(ticket, ticketId);
		else if (view)
			System.out.println("Viewing...");
		else
			ticketService.createTicket(ticket);
		update = view = false;
		System.out.println("Saved...");
		return "redirect:/admin/tickets";
	}

	// delete ticket
	@GetMapping("/delete/{id}")
	public String deleteTicket(Model model, @PathVariable int id) {
		ticketService.deleteTicket(id);
		return "redirect:/admin/tickets";
	}

	// update ticket
	@GetMapping("/update/{id}")
	public String updateTicket(Model model, @PathVariable int id) {
		TicketTracker ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		update = true;
		ticketId = id;
		return "newticket";
	}

	// view ticket
	@GetMapping("/view/{id}")
	public String viewTicket(Model model, @PathVariable int id) {
		TicketTracker ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		view = true;
		return "newticket";
	}

	// search operation for searching ticket
	@GetMapping("/search")
	public String searchticket(Model model, @RequestParam("query") String keyword) {
		List<TicketTracker> searchTickets = ticketService.search(keyword);
		model.addAttribute("tick", searchTickets);
		model.addAttribute("query", keyword);
		return "ticket";

	}

}
