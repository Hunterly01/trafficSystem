package Ticket.services;


import Ticket.dtos.requests.RegisterVehicleRequest;
import Ticket.dtos.responses.RegisterVehicleResponse;

public interface VehicleService  {
    RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request);
}
