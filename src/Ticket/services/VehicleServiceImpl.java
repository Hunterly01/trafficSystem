package Ticket.services;

import Ticket.data.models.Vehicle;
import Ticket.data.repository.VehicleRepository;
import Ticket.dtos.requests.RegisterVehicleRequest;
import Ticket.dtos.responses.RegisterVehicleResponse;
import Ticket.exceptions.VehicleExistsException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static Ticket.utils.Mapper.map;
import static Ticket.utils.Mapper.map1;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class VehicleServiceImpl implements  VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;



    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
        Vehicle vehicle = map(request);
        if(vehicleRepository.findBychasisNumber(vehicle.getChasisNumber()).isPresent()){
            throw new VehicleExistsException("Vehicle already exists");
        }
       Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return map1(savedVehicle);
    }
}
