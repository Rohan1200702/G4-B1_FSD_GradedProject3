/**
 * @author Rohan Chakraborty, Lalita Choudhary
 * Date: 17-04-2023
 * This is entity class to create the table inn database
 */
package com.gl.ticketTracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

//This is the entity class based on which table will be created in database
@Entity
public class TicketTracker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tickeId;
	private String title;
	private String description;
	/*
	 * 1. Date column is created with default value in table 
	 * 2. Specifying no valuec will be passed from spring to database 
	 * 3. Using type date only without time
	 */
	@ColumnDefault("(CURRENT_DATE)")
	@Column(insertable = false)
	@Temporal(TemporalType.DATE)
	private Date createOn;
	private String content;

	public TicketTracker(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public TicketTracker() {
		super();
	}

	public int getTickeId() {
		return tickeId;
	}

	public void setTickeId(int tickeId) {
		this.tickeId = tickeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
