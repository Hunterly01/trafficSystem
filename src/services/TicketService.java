package services;

import data.models.Ticket;
import dtos.requests.IssueTicketRequest;
import dtos.responses.IssueTicketResponse;
import dtos.responses.SettleTicketResponse;
import dtos.responses.ViewTicketResponse;


public interface TicketService {
    IssueTicketResponse issueTicket(IssueTicketRequest request);
    SettleTicketResponse settleTicket(int ticketId, int fees);
    ViewTicketResponse viewTickets(int vehicleId);
}
