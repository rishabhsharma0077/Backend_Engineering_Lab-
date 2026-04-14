package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.request.binding.Passenger;
import in.ashokit.response.binding.Ticket;
import in.ashokit.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
    @Autowired
    private MakeMyTripService service;

    @GetMapping("/")
    public String loadForm(Model model) {
        model.addAttribute("passenger", new Passenger());
        return "index";
    }

    @PostMapping("/book-Ticket")
    public String bookTicket(@ModelAttribute("passenger") Passenger passenger, Model model) {
        System.out.println(passenger);
        Ticket ticket = service.bookTicket(passenger);
        model.addAttribute("msg", "Your Ticket Book With Id: " + ticket.getTicketNum());
        return "index";
    }

    @GetMapping("/ticket")
    public String getTicketForm(Model model) {
        model.addAttribute("ticket", null); // Explicitly set ticket to null
        return "ticket";
    }

    @GetMapping("/get-ticket")
    public String getTicket(@RequestParam Integer ticketnumber, Model model) {
        Ticket ticketByNumber = service.getTicketByNumber(ticketnumber);
        model.addAttribute("ticket", ticketByNumber); // Null is handled in template
        return "ticket";
    }
}