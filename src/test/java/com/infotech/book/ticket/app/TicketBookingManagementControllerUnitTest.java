package com.infotech.book.ticket.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infotech.book.ticket.app.controller.TicketBookingController;
import com.infotech.book.ticket.app.entities.Ticket;
import com.infotech.book.ticket.app.service.TicketBookingService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TicketBookingController.class, secure = false)
public class TicketBookingManagementControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TicketBookingService ticketBookingService;
	
	
	
	@Test
	public void test1_getTicketById() throws Exception {
		
		Ticket ticket = new Ticket();
		
		ticket.setTicketId(1);
		ticket.setSourceStation("Pune");
		ticket.setPassengerName("Santosh");
		ticket.setEmail("pranav@gmail.com");
		ticket.setDestStation("Hyderabad");
		ticket.setBookingDate(new Date());
		
		String inputInJson = this.mapToJson(ticket);
		
		Mockito.when(
				ticketBookingService.getTicketById(2)).thenReturn(ticket);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/tickets/ticket/2").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse()
				.getContentAsString());
		
		assertEquals(result.getResponse()
				.getContentAsString(), inputInJson);

	}
	
	
	  @Test 
	  public void test2_createTicket() throws Exception {
	  
	  Ticket ticket = new Ticket();
	  ticket.setTicketId(1);
	  ticket.setPassengerName("Martin Bingel");
	  ticket.setSourceStation("Kolkata");
	  ticket.setDestStation("Delhi");
	  ticket.setBookingDate(new Date());
	  ticket.setEmail("martin.s2017@gmail.com");
	  
	  String inputInJson = this.mapToJson(ticket);
	  
	  String URI = "/api/tickets/create";
	  
	  Mockito.when(ticketBookingService.createTicket(Mockito.any(Ticket.class))).thenReturn(ticket);
	  
	  RequestBuilder requestBuilder = MockMvcRequestBuilders .post(URI)
	  .accept(MediaType.APPLICATION_JSON).content(inputInJson)
	  .contentType(MediaType.APPLICATION_JSON);
	  
	  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	  MockHttpServletResponse response = result.getResponse();
	  
	  String outputInJson = response.getContentAsString();
	  
	  assertThat(outputInJson).isEqualTo(inputInJson);
	  assertEquals(HttpStatus.OK.value(), response.getStatus());
	  
	  
	  
	  }
	  
	  
	 
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
