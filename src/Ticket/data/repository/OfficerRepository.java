package Ticket.data.repository;

import Ticket.data.models.Officer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficerRepository extends MongoRepository<Officer, String> {

    Optional <Officer> findByOffNumber(String offNumber);


}
