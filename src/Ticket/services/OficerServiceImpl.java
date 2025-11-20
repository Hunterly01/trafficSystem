package Ticket.services;

import Ticket.data.models.Officer;
import Ticket.data.repository.OfficerRepository;
import Ticket.dtos.requests.RegisterOfficerRequest;
import Ticket.dtos.responses.RegisteOfficerResponse;
import Ticket.exceptions.OfficerExistsException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static Ticket.utils.MapperForOfficer.map1;
import static Ticket.utils.MapperForOfficer.mapOfficerToOfficer;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class OficerServiceImpl implements OfficerService{
    @Autowired
    private OfficerRepository officerRepository;


    @Override
    public RegisteOfficerResponse registerOfficer(RegisterOfficerRequest registerOfficerRequest) {
        Officer officer = mapOfficerToOfficer(registerOfficerRequest);
        if(officerRepository.findByOffNumber(officer.getOffNumber()).isPresent()){
            throw new OfficerExistsException("Offer already exists");
        }
        Officer savedOfficer = officerRepository.save(officer);
        return map1(savedOfficer);
    }
}
