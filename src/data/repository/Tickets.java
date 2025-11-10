package data.repository;

import data.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Tickets implements TicketRepository {
    private List<Ticket> tickets = new ArrayList<>();
    private int count = 0;

    @Override
    public Ticket save(Ticket ticket) {
        tickets.add(ticket);
        count++;
        return ticket;
    }

    @Override
    public Ticket findById(int id) {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void delete(Ticket ticket) {

    }

    @Override
    public long count() {
        return count;
    }


}
