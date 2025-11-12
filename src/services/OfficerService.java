package services;

import dtos.requests.RegisterOfficerRequest;
import dtos.responses.RegisterVehicleResponse;

public interface OfficerService {
    RegisterVehicleResponse registerOfficer(RegisterOfficerRequest registerOfficerRequest);
}
