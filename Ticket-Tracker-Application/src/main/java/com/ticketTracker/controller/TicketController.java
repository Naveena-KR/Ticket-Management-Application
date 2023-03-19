package com.ticketTracker.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ticketTracker.model.Ticket;
import com.ticketTracker.service.TicketServiceImpl;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	public TicketServiceImpl ticketServiceImpl;

	// Fetches all record from table
	@RequestMapping("/list")
	public String getAllTickets(Model model) {
		List<Ticket> tickets = ticketServiceImpl.findAll();
		model.addAttribute("tickets", tickets);
		return "view-Tickets";
	}

	// Fetches record by its id
	@RequestMapping("/getById")
	public String getById(@RequestParam("tId") int id, Model model) {
		Ticket ticket = ticketServiceImpl.findById(id);
		model.addAttribute("tickets", ticket);
		return "view-Tickets";
	}

	// Fetches records by searching title or description names from table
	@RequestMapping("/listBytitleORshortDescri")
	public String getAllTicketsByTitle(@RequestParam("titleORshortDescri") String titleORshortDescri, Model model) {
		List<Ticket> ticketsByTitle = ticketServiceImpl.findByTitleContainingIgnoreCase(titleORshortDescri);
		List<Ticket> tickets = ticketsByTitle;
		List<Ticket> ticketsByDes = ticketServiceImpl.findByShortDescriptionContainingIgnoreCase(titleORshortDescri);
		tickets.addAll(ticketsByDes);
		model.addAttribute("tickets", tickets);
		return "view-Tickets";
	}

	// Shows the form to enter details of new record or existing record
	Date previousDate;

	@RequestMapping("/showForm")
	public String showForm(@RequestParam("tId") int id, Model model) {
		Ticket ticket = new Ticket();
		if (id != 0) {
			ticket = ticketServiceImpl.findById(id);
			previousDate = ticket.getCreatedDate(); // previousDate variable holds previous Date and Time of Existing
													// record
			model.addAttribute("ticket", ticket);
		} else {
			model.addAttribute("ticket", ticket);
		}
		return "show-Form";
	}

	// Inserts or updates the record
	@RequestMapping("/save")
	public String save(@ModelAttribute Ticket ticket) {
		if (ticket.getId() != 0) {
			ticket.setCreatedDate(previousDate);// Setting existing Date and Time for Existing Record
			ticketServiceImpl.save(ticket);
		} else {
			Date date = new Date();
			ticket.setCreatedDate(date);// Setting New Date and Time for New Record
			ticketServiceImpl.save(ticket);
		}
		return "redirect:/ticket/list";
	}

	// Deletes record from table by its Id
	@RequestMapping("/deleteById")
	public String deleteById(@RequestParam("tId") int id) {
		ticketServiceImpl.deleteById(id);
		return "redirect:/ticket/list";
	}
}
