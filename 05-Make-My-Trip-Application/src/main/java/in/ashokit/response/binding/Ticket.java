package in.ashokit.response.binding;

import lombok.Data;

@Data
public class Ticket {
	 private Integer ticketNum;
	    private String name;
	    private String from;
	    private String to;
	    private String doj; // Consider LocalDate if date parsing is needed
	    private String status;
	    private Double cost;
}
