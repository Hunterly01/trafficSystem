package utils;

import data.models.Owner;
import data.models.Vehicle;
import dtos.requests.RegisterVehicleRequest;



public class Mapper {
    public static Vehicle map(RegisterVehicleRequest request) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(request.getVehicleName());
        vehicle.setColor(request.getVehicleColor());
        vehicle.setModel(request.getVehicleModel());
        vehicle.setChasisNumber(request.getChasisNumber());

        Owner owner = new Owner();
        owner.setAddress(request.getOwnerAddress());
        owner.setName(request.getOwnerName());
        owner.setEmail(request.getOwnerEmail());
        owner.setPhone(request.getOwnerPhone());

        return vehicle;
    }
}
