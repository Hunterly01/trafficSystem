package controllers;

import dtos.requests.RegisterOfficerRequest;
import dtos.responses.RegisteOfficerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.OfficerService;
import services.OficerServiceImpl;

@RestController
public class OfficerControllers {

    @Autowired
    private OfficerService officerService;

    @PostMapping
    public RegisteOfficerResponse registeOfficerResponse(RegisterOfficerRequest registerOfficerRequest) {
        return officerService.registerOfficer(registerOfficerRequest);
    }
}
