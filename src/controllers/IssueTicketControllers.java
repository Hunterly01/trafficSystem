package controllers;

import dtos.requests.IssueTicketRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketsRequest;
import dtos.responses.IssueTicketResponse;
import dtos.responses.SettleTicketResponse;
import dtos.responses.ViewTicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.TicketService;
import services.TicketServiceImpl;

@RestController
public class IssueTicketControllers {
    @Autowired
    private TicketService ticketService;
    @PostMapping
    public IssueTicketResponse issueTicket(IssueTicketRequest issueTicketRequest) {
        return ticketService.issueTicket(issueTicketRequest);
    }
    @PostMapping
    public SettleTicketResponse settleTicketResponse(SettleTicketRequest settleTicketRequest) {
        return  ticketService.settleTicket(settleTicketRequest);
    }
    @GetMapping
    public ViewTicketResponse viewTicketResponse(ViewTicketsRequest viewTicketsRequest) {
        return (ViewTicketResponse) ticketService.viewTickets(viewTicketsRequest);
    }
}
