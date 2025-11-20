package Ticket.controllers;

import Ticket.dtos.requests.RegisterOfficerRequest;
import Ticket.dtos.responses.RegisteOfficerResponse;
import Ticket.services.OficerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Ticket.services.OfficerService;

@RestController
public class OfficerControllers {

    @Autowired
    private OfficerService officerService;

    @PostMapping("/officer")
    public RegisteOfficerResponse registeOfficerResponse( @RequestBody RegisterOfficerRequest registerOfficerRequest) {
        return officerService.registerOfficer(registerOfficerRequest);
    }
}
