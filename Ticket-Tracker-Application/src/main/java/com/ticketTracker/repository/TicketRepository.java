package com.ticketTracker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ticketTracker.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	// Fetches records from table by searching title name.
	@Query("SELECT t FROM Ticket t WHERE t.title LIKE %:title% ")
	public List<Ticket> findByTitleContainingIgnoreCase(String title);

	// Fetches records from table by searching Description name.
	@Query("SELECT t FROM Ticket t WHERE t.shortDescription LIKE %:shortDescription% ")
	public List<Ticket> findByShortDescriptionContainingIgnoreCase(String shortDescription);
}
