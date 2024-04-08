package com.tickettracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tickettracker.entity.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
