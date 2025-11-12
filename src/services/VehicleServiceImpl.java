package services;

import data.models.Owner;
import data.models.Vehicle;
import data.repository.VehicleRepository;
import data.repository.Vehicles;
import dtos.requests.RegisterVehicleRequest;
import dtos.responses.RegisterVehicleResponse;
import exceptions.VehicleExistsException;
import utils.*;


import static utils.Mapper.map;


public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository = new Vehicles();

    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
       Vehicle vehicle = map(request);
       if(vehicleRepository.findByChassiNumber(vehicle.getChasisNumber()) != null){
           throw new VehicleExistsException("Vehicle already exists");
       }
        vehicleRepository.save(vehicle);
        return new RegisterVehicleResponse();
    }
}
