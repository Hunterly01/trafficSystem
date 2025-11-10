package data.repository;

import data.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketsTest {
    private  TicketRepository ticket;


    @BeforeEach
    void setUp() {
        ticket = new Tickets();
    }
    @Test
    public void test_ticket_is_not_available(){
        assertEquals(0, ticket.count());
    }
    @Test
    public void test_ticket_add_ticket() {
        Ticket  savedTicket = new Ticket();
        Ticket result = ticket.save(savedTicket);
        assertEquals(1, ticket.count());

    }
}