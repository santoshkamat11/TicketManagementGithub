package com.infotech.book.ticket.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infotech.book.ticket.app.entities.Ticket;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TicketBookingManagementAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketBookingManagementAppApplicationTests {
	
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();


	@Test
	public void test1_createTicket() {
		
		Ticket ticket = new Ticket();
		
		ticket.setTicketId(1);
		ticket.setSourceStation("Pune");
		ticket.setPassengerName("Santosh");
		ticket.setEmail("pranav@gmail.com");
		ticket.setDestStation("Hyderabad");
		ticket.setBookingDate(new Date(2323223232L));
		
		HttpEntity<Ticket> entity = new HttpEntity<Ticket>(ticket, headers);

		ResponseEntity<Ticket> response = restTemplate.exchange(
				createURLWithPort("/api/tickets/create"),
				HttpMethod.POST, entity, Ticket.class);
		
		
		
		assertEquals(ticket.toString(), response.getBody().toString());
		
	}
	
	@Test
	public void test2_getAllTickets() throws JsonProcessingException {
		
		
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/api/tickets/ticket/alltickets"),
				HttpMethod.GET, entity, String.class);
		
		System.out.println(response.getBody());
		
		String expected = "[{\"ticketId\":1,\"passengerName\":\"Santosh\",\"bookingDate\":2323223232,\"sourceStation\":\"Pune\",\"destStation\":\"Hyderabad\",\"email\":\"pranav@gmail.com\"}]";
		System.out.println(expected);
		assertTrue(expected.equals(response.getBody()));
		
	}
	
	
	
	@Test
	public void test3_getTicketById() {
		
		Ticket ticket = new Ticket();
		
		ticket.setTicketId(2);
		ticket.setSourceStation("Pune");
		ticket.setPassengerName("Pranav");
		ticket.setEmail("pranav@gmail.com");
		ticket.setDestStation("Hyderabad");
		ticket.setBookingDate(new Date());
		
		HttpEntity<Ticket> entity = new HttpEntity<Ticket>(ticket, headers);

		restTemplate.exchange(createURLWithPort("/api/tickets/create"),
							  HttpMethod.POST, entity, Ticket.class);
		
		
		ResponseEntity<Ticket> response = restTemplate.exchange(
				createURLWithPort("/api/tickets/ticket/2"),
				HttpMethod.GET, entity, Ticket.class);
		
		assertEquals(response.getBody().toString(), ticket.toString());

		
	}
	
	@Test
	public void test4_deleteTicket() {
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/tickets/ticket/2"),
				  HttpMethod.DELETE, entity, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		
	}
	
	@Test
	public void test5_updateTicket() {
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/tickets/ticket/1/update@gmail.com"),
				  HttpMethod.PUT, entity, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
