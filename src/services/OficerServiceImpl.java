package services;

import data.models.Officer;
import data.repository.OfficerRepository;
import data.repository.Officers;
import dtos.requests.RegisterOfficerRequest;
import dtos.responses.RegisterVehicleResponse;
import exceptions.OfficerExistsException;

import static utils.MapperForOfficer.mapOfficerToOfficer;

public class OficerServiceImpl implements OfficerService{
    private OfficerRepository officerRepository =  new Officers();

    @Override
    public RegisterVehicleResponse registerOfficer(RegisterOfficerRequest registerOfficerRequest){
        Officer officer = mapOfficerToOfficer(registerOfficerRequest);
        if(officerRepository.findByOffNumber(officer.getOffNumber()) != null){
            throw new OfficerExistsException("Offer already exists");
        }
        officerRepository.save(officer);
        return new RegisterVehicleResponse();
    }
}
