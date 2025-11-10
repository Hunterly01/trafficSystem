package data.repository;

import data.models.Vehicle;
import exceptions.IdNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Vehicles implements VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();
    private int count = 0;


    @Override
    public Vehicle save(Vehicle vehicle) {
        if (vehicle.getId() == 0) {
            generateId();
            vehicle.setId(count);
            vehicles.add(vehicle);
        }
        return vehicle;

    }


    @Override
    public Vehicle findById(int id) {
        for (Vehicle vehicle : vehicles) {
            if(vehicle.getId() == id){
                return vehicle;
            }
        }
        throw new IdNotFoundException("vehicle with id " + id + " not found");
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public void deleteById(int id) {
        vehicles.removeIf(vehicle -> vehicle.getId() == id);

    }

    @Override
    public void deleteAll() {
        vehicles.clear();
        }



    @Override
    public void delete(Vehicle vehicle) {
        vehicles.remove(vehicle);

    }

    @Override
    public long count() {
        return vehicles.size();

    }
    public void generateId() {
       ++count;
        }

    @Override
    public String toString() {
        return "vehicles =" + vehicles;
    }
}

