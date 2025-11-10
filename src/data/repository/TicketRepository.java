package data.repository;

import data.models.Ticket;

import java.util.List;

public interface TicketRepository {

        Ticket save(Ticket ticket);
        Ticket findById(int id);
        List<Ticket> findAll();
        void deleteById(int id);
        void deleteAll();
        void delete(Ticket ticket);
        long count();
    }


