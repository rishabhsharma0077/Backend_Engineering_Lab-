package in.ashokit.service;

import org.springframework.stereotype.Service;

import in.ashokit.request.binding.Passenger;
import in.ashokit.response.binding.Ticket;
@Service
public interface MakeMyTripService {
	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicketByNumber(Integer Ticketnumber);

}
