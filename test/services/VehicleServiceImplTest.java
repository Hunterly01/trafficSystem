package services;

import data.repository.VehicleRepository;
import data.repository.Vehicles;
import dtos.requests.RegisterVehicleRequest;
import exceptions.VehicleExistsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceImplTest {
        VehicleServiceImpl vehicleService;
        VehicleRepository vehicleRepository;
    @BeforeEach
    void setUp() {
        vehicleService = new VehicleServiceImpl();
        vehicleRepository = new Vehicles();

    }

    @Test
    public void test_() {
        RegisterVehicleRequest request = new RegisterVehicleRequest();
        vehicleService.registerVehicle(request);
        assertEquals(1, vehicleRepository.count());
    }

    @Test
    public void test_getVehicle() {
        RegisterVehicleRequest request = new RegisterVehicleRequest();
        request.setChasisNumber("ade");
        vehicleService.registerVehicle(request);
        assertEquals(1, vehicleRepository.count());
        assertThrows(VehicleExistsException.class,()-> vehicleService.registerVehicle(request));
        assertEquals(1,vehicleRepository.count());

    }


    @AfterEach
    void tearDown() {
        vehicleRepository.deleteAll();
    }
}