package Ticket.controllers;

import Ticket.dtos.requests.RegisterVehicleRequest;
import Ticket.dtos.responses.RegisterVehicleResponse;
import Ticket.services.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Ticket.services.VehicleService;

@RestController
public class VehicleControllers {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/create")
    public RegisterVehicleResponse registerVehicle( @RequestBody RegisterVehicleRequest registerVehicleRequest) {
        return vehicleService.registerVehicle(registerVehicleRequest);
    }
}
