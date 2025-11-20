package Ticket.services;

import Ticket.dtos.requests.RegisterOfficerRequest;
import Ticket.dtos.responses.RegisteOfficerResponse;


public interface OfficerService  {
    RegisteOfficerResponse registerOfficer(RegisterOfficerRequest registerOfficerRequest);
}
