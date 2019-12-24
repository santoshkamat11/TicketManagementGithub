package com.infotech.book.ticket.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.infotech.book.ticket.app.entities.Ticket;


public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {

	List<Ticket> findByDestStation(String destStation);

	List<Ticket> findBySourceStationAndDestStation(String sourceStation, String destStation);

	List<Ticket> TicketByNameAndSourceStation(String passengerName, String sourceStation);

	List<Ticket> TicketByNameAndSourceStation_Method2(String passengerName, String sourceStation);

	@Query("select t from Ticket t where t.passengerName like %?1")
	List<Ticket> nameEndsWith(String end);

}
