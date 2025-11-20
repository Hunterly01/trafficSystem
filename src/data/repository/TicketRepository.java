package data.repository;

import data.models.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket,String> {

        Ticket save(Ticket ticket);
        Ticket findById(int id);
        List<Ticket> findAll();
        void deleteById(int id);
        void deleteAll();
        void delete(Ticket ticket);
        long count();
    }


