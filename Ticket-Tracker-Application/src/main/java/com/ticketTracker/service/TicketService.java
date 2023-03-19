package com.ticketTracker.service;

import java.util.List;

import com.ticketTracker.model.Ticket;

public interface TicketService {

	public List<Ticket> findAll();

	public List<Ticket> findByTitleContainingIgnoreCase(String title);

	public List<Ticket> findByShortDescriptionContainingIgnoreCase(String shortDescription);

	public Ticket findById(int id);

	public void save(Ticket ticket);

	public void deleteById(int id);
}
