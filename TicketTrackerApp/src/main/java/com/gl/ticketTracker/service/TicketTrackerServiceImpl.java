/**
 * @author Rohan Chakraborty, Lalita Choudhary
 * Date: 17-04-2023
 * This is service class to perform the CRUD operations through repository interface 
 */
package com.gl.ticketTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.ticketTracker.dao.TicketTrackerDao;
import com.gl.ticketTracker.model.TicketTracker;

@Service
public class TicketTrackerServiceImpl implements TicketTrackerService {
	TicketTrackerDao ticketDao;

	public TicketTrackerServiceImpl(TicketTrackerDao ticketDao) {
		super();
		this.ticketDao = ticketDao;
	}

	@Override
	public List<TicketTracker> getAllTickets() {
		return ticketDao.findAll();
	}

	@Override
	public TicketTracker createTicket(TicketTracker ticket) {
		return ticketDao.save(ticket);
	}

	@Override
	public TicketTracker getTicketById(int id) {
		return ticketDao.findById(id).get();
	}

	@Override
	public TicketTracker editTicket(TicketTracker ticket, int id) {
		TicketTracker oldTicket = ticketDao.findById(id).get();
		oldTicket.setTitle(ticket.getTitle());
		oldTicket.setDescription(ticket.getDescription());
		oldTicket.setContent(ticket.getContent());
		return ticketDao.save(oldTicket);
	}

	@Override
	public void deleteTicket(int id) {
		ticketDao.deleteById(id);
	}

	// method to perform the search operation using keyword
	@Override
	public List<TicketTracker> search(String keyword) {
		if (keyword != null) {
			return ticketDao.search(keyword);
		}
		return ticketDao.findAll();
	}

}
