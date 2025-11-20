package services;

import data.models.Officer;
import data.repository.OfficerRepository;
import dtos.requests.RegisterOfficerRequest;
import dtos.responses.RegisteOfficerResponse;
import exceptions.OfficerExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static utils.MapperForOfficer.map1;
import static utils.MapperForOfficer.mapOfficerToOfficer;

@Service
public class OficerServiceImpl implements OfficerService{
    @Autowired
    private OfficerRepository officerRepository;

    public OficerServiceImpl(OfficerRepository officerRepository) {
        this.officerRepository = officerRepository;
    }
    public OficerServiceImpl(){

    }


    @Override
    public RegisteOfficerResponse registerOfficer(RegisterOfficerRequest registerOfficerRequest) {
        Officer officer = mapOfficerToOfficer(registerOfficerRequest);
        if(officerRepository.findByOffNumber(officer.getOffNumber()) != null){
            throw new OfficerExistsException("Offer already exists");
        }
        Officer savedOfficer = officerRepository.save(officer);
        return map1(savedOfficer);
    }
}
