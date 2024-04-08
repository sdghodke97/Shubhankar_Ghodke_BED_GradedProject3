package com.tickettracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="Ticket_Title")
	private String Ticket_Title;
	
	@Column(name="Ticket_Discription")
	private String Ticket_Discription;
	
	@Column(name="Created_Date")
	private String Created_Date;

	public Ticket(int id, String ticket_Title, String ticket_Discription, String created_Date) {
		super();
		Id = id;
		Ticket_Title = ticket_Title;
		Ticket_Discription = ticket_Discription;
		Created_Date = created_Date;
	}

	public Ticket() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTicket_Title() {
		return Ticket_Title;
	}

	public void setTicket_Title(String ticket_Title) {
		Ticket_Title = ticket_Title;
	}

	public String getTicket_Discription() {
		return Ticket_Discription;
	}

	public void setTicket_Discription(String ticket_Discription) {
		Ticket_Discription = ticket_Discription;
	}

	public String getCreated_Date() {
		return Created_Date;
	}

	public void setCreated_Date(String created_Date) {
		Created_Date = created_Date;
	}

	@Override
	public String toString() {
		return "Ticket [Id=" + Id + ", Ticket_Title=" + Ticket_Title + ", Ticket_Discription=" + Ticket_Discription
				+ ", Created_Date=" + Created_Date + "]";
	}
	

}
