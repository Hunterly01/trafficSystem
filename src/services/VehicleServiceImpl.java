package services;

import data.models.Vehicle;
import data.repository.VehicleRepository;
import dtos.requests.RegisterVehicleRequest;
import dtos.responses.RegisterVehicleResponse;
import exceptions.VehicleExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static utils.Mapper.map;
import static utils.Mapper.map1;

@Service
public class VehicleServiceImpl implements  VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public VehicleServiceImpl(){

    }


    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
        Vehicle vehicle = map(request);
        if(vehicleRepository.findByChassiNumber(vehicle.getChasisNumber()) != null){
            throw new VehicleExistsException("Vehicle already exists");
        }
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return map1(savedVehicle);
    }
}
