package in.ashokit.service;

import in.ashokit.request.binding.Passenger;
import in.ashokit.response.binding.Ticket;

public interface BookingService {
	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicket(Integer ticketNum);

}
