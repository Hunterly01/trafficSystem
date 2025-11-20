package Ticket.data.repository;

import Ticket.data.models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle,String> {

    Optional <Vehicle> findBychasisNumber(String chassiNumber);
}
