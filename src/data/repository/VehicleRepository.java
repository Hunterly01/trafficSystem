package data.repository;

import data.models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VehicleRepository extends MongoRepository<Vehicle,String> {
    Vehicle save(Vehicle vehicle);
    Vehicle findById(int id);
    List<Vehicle> findAll();
    void deleteById(int id);
    void deleteAll();
    void delete(Vehicle vehicle);
    long count();
    Vehicle findByChassiNumber(String chassiNumber);
}
