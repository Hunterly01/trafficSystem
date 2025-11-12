package data.repository;

import data.models.Vehicle;
import exceptions.IdNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class vehiclesTest {
    private VehicleRepository vehicle;

    @BeforeEach
    void setUp() {
        vehicle = new Vehicles();
    }

    @AfterEach
    void tearDown() {
        vehicle.deleteAll();
    }

    @Test
    public void test_vehicle_is_not_available() {
        assertEquals(0, vehicle.count());
    }

    @Test
    public void test_to_add_a_vehicle() {
        Vehicle savedVehicle = new Vehicle();
        Vehicle result = vehicle.save(savedVehicle);
        assertEquals(1, vehicle.count());
    }

    @Test
    public void test_to_update_a_vehicle() {
        Vehicle savedVehicle = new Vehicle();
        Vehicle result = vehicle.save(savedVehicle);
        assertEquals(1, vehicle.count());
        Vehicle vehicle = new Vehicle();
        vehicle.setId(2);
        assertEquals(2, vehicle.getId());


    }

    @Test
    public void test_to_add_a_vehicle_and_find_vehicle_by_id() {
        Vehicle savedVehicle = new Vehicle();
        Vehicle result = vehicle.save(savedVehicle);
        assertEquals(1, vehicle.count());
        assertEquals(savedVehicle, vehicle.findById(1));
    }
    @Test
    public void test_to_add_two_vehicle_and_find_vehicle_by_id() {
        Vehicle vehicle1 = new Vehicle();
        vehicle.save(vehicle1);
        assertEquals(1, vehicle.count());
        assertEquals(vehicle1, vehicle.findById(1));
    }

    @Test
    public void test_to_add_a_vehicle_and_delete_vehicle_by_id() {
        Vehicle savedVehicle = new Vehicle();
        Vehicle result = vehicle.save(savedVehicle);
        vehicle.deleteById(1);
        vehicle.deleteAll();
        assertEquals(0, vehicle.count());
    }


    @Test
    public void test_a_add_two_vehicle_and_delete_all_vehicles() {
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        vehicle.save(vehicle1);
        vehicle.save(vehicle2);
        assertEquals(2, vehicle.count());
        vehicle.deleteAll();
        assertEquals(0, vehicle.count());
    }

    @Test
    public void test_a_add_two_vehicle_and_deleteAll() {
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        vehicle.save(vehicle1);
        vehicle.save(vehicle2);
        assertEquals(2, vehicle.count());
        vehicle.delete(vehicle1);
        assertFalse(vehicle.findAll().contains(vehicle1));
    }

}
