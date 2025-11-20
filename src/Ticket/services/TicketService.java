package Ticket.services;

import Ticket.dtos.requests.IssueTicketRequest;
import Ticket.dtos.requests.SettleTicketRequest;
import Ticket.dtos.requests.ViewTicketsRequest;
import Ticket.dtos.responses.IssueTicketResponse;
import Ticket.dtos.responses.SettleTicketResponse;
import Ticket.dtos.responses.ViewTicketResponse;

import java.util.List;


public interface TicketService {
    IssueTicketResponse issueTicket(IssueTicketRequest request);
    SettleTicketResponse settleTicket(SettleTicketRequest request);
    List<ViewTicketResponse> viewTickets(String id);
}
