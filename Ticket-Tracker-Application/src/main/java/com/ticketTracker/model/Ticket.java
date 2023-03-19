package com.ticketTracker.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "title")
	private String title;

	@Column(name = "shortDescription")
	private String shortDescription;

	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "content")
	private String content;

}
