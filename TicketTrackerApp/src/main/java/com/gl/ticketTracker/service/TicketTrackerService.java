/**
 * @author Rohan Chakraborty, Lalita Choudhary
 * Date: 17-04-2023
 * This is the interface of service class to ensure the encapsulation of methods
 */
package com.gl.ticketTracker.service;

import java.util.List;
import com.gl.ticketTracker.model.TicketTracker;

// interface for CRUD operation services
public interface TicketTrackerService {
	public List<TicketTracker> getAllTickets();

	public TicketTracker createTicket(TicketTracker ticket);

	public TicketTracker getTicketById(int id);

	public TicketTracker editTicket(TicketTracker ticket, int id);

	public void deleteTicket(int id);

	public List<TicketTracker> search(String keyword);

}
