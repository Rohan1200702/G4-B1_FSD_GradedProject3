/**
 * @author Rohan Chakraborty
 * Date: 17-04-2023
 */
package com.gl.ticketTracker.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/")
	public String showHome(Model model) {
		System.out.println("Time ...");
		model.addAttribute("date", new Date());
		return "home";
	}
}
