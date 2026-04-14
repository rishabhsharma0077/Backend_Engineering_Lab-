package in.ashokit.bookticket.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.request.binding.Passenger;
import in.ashokit.response.binding.Ticket;
import in.ashokit.service.BookingService;

@RestController
public class BookTicketRestController {
	@Autowired
	private BookingService service;

	@PostMapping(value = "/ticket", consumes = "application/json", produces = "application/json"

	)
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) {
		System.out.println(passenger);
		Ticket bookTicket = service.bookTicket(passenger);
		return new ResponseEntity<>(bookTicket, HttpStatus.CREATED);
	}

	@GetMapping(value = "/ticket/{ticketNum}", produces = "application/json")
	public Ticket getTicket(@PathVariable Integer ticketNum) {
		return service.getTicket(ticketNum);

	}

}
