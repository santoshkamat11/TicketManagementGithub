package com.infotech.book.ticket.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.TicketBookingDao;
import com.infotech.book.ticket.app.entities.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	public Ticket createTicket(Ticket ticket) {
		
		return ticketBookingDao.save(ticket);
	}

	public Ticket getTicketById(Integer ticketId) {
		
		return ticketBookingDao.findOne(ticketId);
	}

	public Iterable<Ticket> ticketBookingService() {
		
		return ticketBookingDao.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		
		ticketBookingDao.delete(ticketId);
	}

	public Ticket updateTicket(Integer ticketId, String newEmail) {
		
		Ticket ticketFromDb = ticketBookingDao.findOne(ticketId);
		ticketFromDb.setEmail(newEmail);
		Ticket updatedTicket = ticketBookingDao.save(ticketFromDb);
		return updatedTicket;
	}

	public List<Ticket> getTicketsByDestination(String destStation) {
		
		return ticketBookingDao.findByDestStation(destStation);
	}

	public List<Ticket> getTicketsBySourceAndDestination(String sourceStation, String destStation) {
		
		return ticketBookingDao.findBySourceStationAndDestStation(sourceStation,destStation);
	}

	public List<Ticket> TicketByNameAndSourceStation(String passengerName, String sourceStation) {
		
		return ticketBookingDao.TicketByNameAndSourceStation(passengerName,sourceStation);
	}

	public List<Ticket> TicketByNameAndSourceStation_Method2(String passengerName, String sourceStation) {
		
		return ticketBookingDao.TicketByNameAndSourceStation_Method2(passengerName,sourceStation);
	}

	public List<Ticket> nameEndsWith(String end) {
		
		return ticketBookingDao.nameEndsWith(end);
	}

}
