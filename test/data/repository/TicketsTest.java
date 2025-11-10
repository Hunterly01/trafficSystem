package data.repository;

import data.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketsTest {
    private TicketRepository ticket;


    @BeforeEach
    void setUp() {
        ticket = new Tickets();
    }

    @Test
    public void test_ticket_is_not_available() {
        assertEquals(0, ticket.count());
    }

    @Test
    public void test_ticket_add_ticket() {
        Ticket savedTicket = new Ticket();
        Ticket result = ticket.save(savedTicket);
        assertEquals(1, ticket.count());

    }

    @Test
    public void test_ticket_add_ticket_and_fimdById() {
        Ticket savedTicket = new Ticket();
        Ticket result = ticket.save(savedTicket);
        assertEquals(1, ticket.count());
        assertEquals(savedTicket, ticket.findById(savedTicket.getId()));

    }

    @Test
    public void test_ticket_add_ticket_and_deleteId() {
        Ticket savedTicket = new Ticket();
        Ticket result = ticket.save(savedTicket);
        ticket.delete(savedTicket);
        assertEquals(1, ticket.count());
    }

    @Test
    public void test_ticket_add_two_ticket_and_deleteAll() {
        Ticket savedTicket1 = new Ticket();
        Ticket savedTicket2 = new Ticket();
        ticket.save(savedTicket1);
        ticket.save(savedTicket2);
        assertEquals(2, ticket.count());
        ticket.deleteAll();
        assertEquals(0, ticket.findAll().size());
    }

    @Test
    public void test_ticket_add_two_ticket_and_delete() {
        Ticket savedTicket1 = new Ticket();
        Ticket savedTicket2 = new Ticket();
        ticket.save(savedTicket1);
        ticket.save(savedTicket2);
        assertEquals(2, ticket.count());
        ticket.delete(savedTicket1);
        ticket.delete(savedTicket2);
        assertEquals(0, ticket.findAll().size());
    }
}

