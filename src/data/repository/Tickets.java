package data.repository;

import data.models.Ticket;
import exceptions.IdNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Tickets implements TicketRepository {
    private List<Ticket> tickets = new ArrayList<>();
    private int count = 0;

    @Override
    public Ticket save(Ticket ticket) {
        if (ticket.getId() == 0) {
            generateId();
            ticket.setId(count);
            tickets.add(ticket);
        }
        return ticket;
    }

    private void generateId() {
        ++count;
    }

    @Override
    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        throw new IdNotFoundException("ticket with id " + id + " not found");
    }

    @Override
    public List<Ticket> findAll() {
        return tickets;
    }

    @Override
    public void deleteById(int id) {
        tickets.removeIf(ticket -> ticket.getId() == id);

    }

    @Override
    public void deleteAll() {
        tickets.clear();

    }

    @Override
    public void delete(Ticket ticket) {
        tickets.remove(ticket);

    }

    @Override
    public long count() {
        return tickets.size();
    }


    @Override
    public String toString() {
        return "Tickets ="  + tickets;
    }
}
