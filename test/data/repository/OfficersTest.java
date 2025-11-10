package data.repository;

import data.models.Officer;
import data.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficersTest {
    OfficerRepository officer;

    @BeforeEach
    void setUp() {
        officer = new Officers();

    }

    @Test
    public void test_officer_is_not_available() {
        assertEquals(0, officer.count());
    }

    @Test
    public void test_officers_add_officer() {
        Officer savedTicket = new Officer();
        Officer result = officer.save(savedTicket);
        assertEquals(1, officer.count());

    }

    @Test
    public void test_add_officer_and_fimdById() {
        Officer savedOfficer = new Officer();
        Officer result = officer.save(savedOfficer);
        assertEquals(1, officer.count());
        assertEquals(savedOfficer, officer.findById(savedOfficer.getId()));

    }
    @Test
    public void test_add_officer_and_deleteById() {
        Officer savedOfficer = new Officer();
        Officer result = officer.save(savedOfficer);
        officer.deleteById(savedOfficer.getId());
        assertEquals(1, officer.count());

    }

    @Test
    public void test_ticket_add_officer_and_delete() {
        Officer officer1 = new Officer();
        Officer officer2 = new Officer();
        officer.save(officer1);
        officer.save(officer2);
        assertEquals(2, officer.count());
        officer.delete(officer1);
        officer.delete(officer2);
        assertEquals(0, officer.findAll().size());
    }

    @Test
    public void test_ticket_add_officer_and_deleteAll() {
        Officer officer1 = new Officer();
        Officer officer2 = new Officer();
        officer.save(officer1);
        officer.save(officer2);
        assertEquals(2, officer.count());
        officer.deleteAll();
        assertEquals(0, officer.findAll().size());
    }



}