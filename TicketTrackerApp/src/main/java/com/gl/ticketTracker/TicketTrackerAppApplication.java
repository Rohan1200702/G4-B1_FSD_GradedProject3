/**
 * @author Rohan Chakraborty, Lalita Choudhary
 * Date: 17-04-2023
 * This is the main application class of springboot
 */
package com.gl.ticketTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketTrackerAppApplication.class, args);
		System.out.println("Server Start. . . ");
	}

}
