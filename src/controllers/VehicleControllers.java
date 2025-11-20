package controllers;

import data.repository.VehicleRepository;
import dtos.requests.RegisterVehicleRequest;
import dtos.responses.RegisterVehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.VehicleService;
import services.VehicleServiceImpl;

@RestController
public class VehicleControllers {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest registerVehicleRequest) {
        return vehicleService.registerVehicle(registerVehicleRequest);
    }
}
