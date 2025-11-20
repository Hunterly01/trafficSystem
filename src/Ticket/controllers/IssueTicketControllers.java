package Ticket.controllers;

import Ticket.dtos.requests.IssueTicketRequest;
import Ticket.dtos.requests.SettleTicketRequest;
import Ticket.dtos.requests.ViewTicketsRequest;
import Ticket.dtos.responses.IssueTicketResponse;
import Ticket.dtos.responses.SettleTicketResponse;
import Ticket.dtos.responses.ViewTicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Ticket.services.TicketService;

import java.util.List;

@RestController
public class IssueTicketControllers{
    @Autowired
    private TicketService ticketService;

    @PostMapping("/issue")
    public IssueTicketResponse issueTicket(@RequestBody IssueTicketRequest issueTicketRequest) {
        return ticketService.issueTicket(issueTicketRequest);
    }


    @PostMapping("/Settle")
    public SettleTicketResponse settleTicketResponse( @RequestBody SettleTicketRequest settleTicketRequest) {
        return  ticketService.settleTicket(settleTicketRequest);
    }


    @GetMapping("/view/{vehicleId}")
    public List<ViewTicketResponse> viewTicketResponse(@PathVariable("vehicleId") String vehicleId) {
        return ticketService.viewTickets(vehicleId);
    }
}
