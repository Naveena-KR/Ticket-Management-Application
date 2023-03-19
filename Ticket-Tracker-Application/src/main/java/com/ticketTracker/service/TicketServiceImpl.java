package com.ticketTracker.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketTracker.model.Ticket;
import com.ticketTracker.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	public TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public List<Ticket> findByTitleContainingIgnoreCase(String title) {
		// TODO Auto-generated method stub
		return ticketRepository.findByTitleContainingIgnoreCase(title);
	}

	@Override
	public List<Ticket> findByShortDescriptionContainingIgnoreCase(String shortDescription) {
		// TODO Auto-generated method stub
		return ticketRepository.findByShortDescriptionContainingIgnoreCase(shortDescription);
	}

	@Override
	public Ticket findById(int id) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(id).get();
	}

	@Override
	public void save(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketRepository.save(ticket);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(id);
	}

}
