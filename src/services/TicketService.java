package services;

import data.models.Ticket;
import dtos.requests.IssueTicketRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketsRequest;
import dtos.responses.IssueTicketResponse;
import dtos.responses.SettleTicketResponse;
import dtos.responses.ViewTicketResponse;

import java.util.List;


public interface TicketService {
    IssueTicketResponse issueTicket(IssueTicketRequest request);
    SettleTicketResponse settleTicket(SettleTicketRequest request);
    List<ViewTicketResponse> viewTickets(ViewTicketsRequest request);
}
