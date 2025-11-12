package services;

import data.repository.OfficerRepository;
import data.repository.Officers;
import dtos.requests.RegisterOfficerRequest;
import exceptions.OfficerExistsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OficerServiceImplTest {
    OficerServiceImpl oficerService;
    OfficerRepository officerRepository;

    @BeforeEach
    void setUp() {
        oficerService = new OficerServiceImpl();
        officerRepository = new Officers();
    }




    @Test
    void registerOfficer() {
        RegisterOfficerRequest registerOfficerRequest = new RegisterOfficerRequest();
        oficerService.registerOfficer(registerOfficerRequest);
        assertEquals(1,officerRepository.count());

    }

    @Test
    public void test_registerOfficer_throws_OfficerExistsException() {
        RegisterOfficerRequest registerOfficerRequest = new RegisterOfficerRequest();
        registerOfficerRequest.setOffNumber("hunt");
        oficerService.registerOfficer(registerOfficerRequest);
        assertEquals(1,officerRepository.count());
        assertThrows(OfficerExistsException.class,() -> oficerService.registerOfficer(registerOfficerRequest));


    }

    @AfterEach
    void tearDown() {
        officerRepository.deleteAll();
    }
}