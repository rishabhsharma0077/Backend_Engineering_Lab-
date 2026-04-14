package in.ashokit.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.ashokit.request.binding.Passenger;
import in.ashokit.response.binding.Ticket;
@Service
public class BookingServiceImpl implements BookingService {
	private Map<Integer, Ticket> ticketMap = new HashMap<>();
	private Integer ticketNum = 1;

	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setCost(680.00);
		t.setStatus("Confirmed");
		t.setTicketNum(ticketNum);
		ticketMap.put(ticketNum, t);
		ticketNum++;

		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {
		if (ticketMap.containsKey(ticketNum)) {
			return ticketMap.get(ticketNum);
		}

		return null;
	}

}
