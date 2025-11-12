package utils;

import data.models.Officer;
import dtos.requests.RegisterOfficerRequest;
import dtos.requests.RegisterVehicleRequest;

public class MapperForOfficer {
    public static Officer mapOfficerToOfficer(RegisterOfficerRequest request) {
        Officer officer = new Officer();
        officer.setName(request.getOfficerName());
        officer.setRank(request.getOfficerRank());
        officer.setAddress(request.getOfficerAddress());
        officer.setOffNumber(request.getOffNumber());
        return officer;


    }

}
