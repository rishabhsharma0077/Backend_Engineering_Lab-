package in.ashokit.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.request.binding.Passenger;
import in.ashokit.response.binding.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {
	private String BOOK_TICKET_URL = "http://13.204.45.101:8080/ticket";
	private String GET_TICKET_URL = "http://13.204.45.101:8080/ticket/{ticketNum}";

	@Override
	public Ticket bookTicket(Passenger passenger) {
		/*
		 * RestTemplate rt = new RestTemplate(); ResponseEntity<Ticket> postForEntity =
		 * rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class); Ticket ticket =
		 * postForEntity.getBody(); return ticket;
		 */
		//get the instance of webclient (impl class) 
		WebClient webClient = WebClient.create();
		//send post request with passenger data
		//and map response to ticket object 
		Ticket ticket = webClient.post().uri(BOOK_TICKET_URL).bodyValue(passenger).retrieve().bodyToMono(Ticket.class)
				.block();
		return ticket;
	}

	@Override
	public Ticket getTicketByNumber(Integer ticketnumber) {
		/*
		 * RestTemplate rt = new RestTemplate(); ResponseEntity<Ticket> getforEntity =
		 * rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketnumber); Ticket ticket =
		 * getforEntity.getBody(); return ticket;
		 */

		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.get().uri(GET_TICKET_URL, ticketnumber).retrieve().bodyToMono(Ticket.class).block();
		return ticket;
	}
}
