/**
 * @author Rohan Chakraborty, Lalita Choudhary
 * Date: 17-04-2023
 * This is repository class to perform the CRUD operation
 */
package com.gl.ticketTracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gl.ticketTracker.model.TicketTracker;

public interface TicketTrackerDao extends JpaRepository<TicketTracker, Integer> {

	// Custom query created for the search operation
	@Query(value = "SELECT * FROM ticket_tracker t WHERE t.ticke_Id like %:keyword% or t.create_on like %:keyword% or t.description like %:keyword% or t.title like %:keyword%", nativeQuery = true)
	public List<TicketTracker> search(@Param("keyword") String keyword);
}
