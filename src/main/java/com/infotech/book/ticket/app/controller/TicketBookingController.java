package com.infotech.book.ticket.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.book.ticket.app.entities.Ticket;
import com.infotech.book.ticket.app.service.TicketBookingService;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;
	
	@PostMapping(value = "/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.createTicket(ticket);
		
	}
	
	@GetMapping(value = "/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
		return ticketBookingService.getTicketById(ticketId);
		
	}
	
	@GetMapping(value="/ticket/alltickets")
	public Iterable<Ticket> ticketBookingService(){
		return ticketBookingService.ticketBookingService();
		
	}
	
	@DeleteMapping(value="/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId")Integer ticketId){
		ticketBookingService.deleteTicket(ticketId);
	}
	
	@PutMapping(value="/ticket/{ticketId}/{newEmail:.+}")
	public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId,@PathVariable("newEmail")String newEmail){
		return ticketBookingService.updateTicket(ticketId,newEmail);
	}
	
	// get records by destination station
	@GetMapping(value = "/ticket/destination/{destStation}")
	public List<Ticket> getTicketsByDestination(@PathVariable("destStation") String destStation){
		
		return ticketBookingService.getTicketsByDestination(destStation);
		
	}
	
	
	  // get records by arrival and destination stations
	  
	  @GetMapping(value = "/ticket/arrival/{sourceStation}/destination/{destStation}")
	  public List<Ticket> getTicketsBySourceAndDestination(@PathVariable("sourceStation") String sourceStation,@PathVariable("destStation") String destStation){
		return ticketBookingService.getTicketsBySourceAndDestination(sourceStation,destStation);
		  
	  }
	
	  
	  // named query
	  // get records by passenger name and source station
	  @GetMapping(value = "/ticket/namedQuery/name/{passengerName}/arrival/{sourceStation}")
	  public List<Ticket> getTicketsByNameAndSourceStation_Method1(@PathVariable("passengerName") String passengerName,@PathVariable("sourceStation") String sourceStation){
		
		  return ticketBookingService.TicketByNameAndSourceStation(passengerName,sourceStation);
		  
	  }
	  
	  
	  // named native query
	  // get records by passenger name and source station
	  @GetMapping(value = "/ticket/namedNativeQuery/name/{passengerName}/arrival/{sourceStation}")
	  public List<Ticket> getTicketsByNameAndSourceStation_method2(@PathVariable("passengerName") String passengerName,@PathVariable("sourceStation") String sourceStation){
		
		  return ticketBookingService.TicketByNameAndSourceStation_Method2(passengerName,sourceStation);
		  
	  }
	 
	  // query
	  // get records where passenger name ends with rat
	  @GetMapping(value = "/ticket/query/nameEndsWith/{end}")
	  public List<Ticket> nameEndsWith(@PathVariable("end") String end){
		
		  return ticketBookingService.nameEndsWith(end);
		  
	  }
	  
	
	
}
