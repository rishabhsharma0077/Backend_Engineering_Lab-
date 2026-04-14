package in.ashokit.response.binding;

import lombok.Data;

@Data
public class Ticket {
	private Integer ticketNum;
	private String name;
	private Double cost;
	private String from;
	private String to;
	private String doj;
	private String status;

}
