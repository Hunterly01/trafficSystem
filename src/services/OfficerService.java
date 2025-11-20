package services;

import dtos.requests.RegisterOfficerRequest;
import dtos.responses.RegisteOfficerResponse;


public interface OfficerService {
    RegisteOfficerResponse registerOfficer(RegisterOfficerRequest registerOfficerRequest);
}
