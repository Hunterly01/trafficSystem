package Ticket.utils;

import Ticket.data.models.Owner;
import Ticket.data.models.Ticket;
import Ticket.data.models.Vehicle;
import Ticket.dtos.requests.RegisterVehicleRequest;
import Ticket.dtos.responses.IssueTicketResponse;
import Ticket.dtos.responses.RegisterVehicleResponse;
import Ticket.dtos.responses.SettleTicketResponse;
import Ticket.dtos.responses.ViewTicketResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static Vehicle map(RegisterVehicleRequest request) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(request.getVehicleName());
        vehicle.setColor(request.getVehicleColor());
        vehicle.setModel(request.getVehicleModel());
        vehicle.setChasisNumber(request.getChasisNumber());

        Owner owner = new Owner();
        owner.setAddress(request.getOwnerAddress());
        owner.setName(request.getOwnerName());
        owner.setEmail(request.getOwnerEmail());
        owner.setPhone(request.getOwnerPhone());

        return vehicle;
    }

    public static RegisterVehicleResponse map1(Vehicle savedVehicle) {
        RegisterVehicleResponse response = new RegisterVehicleResponse();
        response.setVehicleId(savedVehicle.getId());
        response.setOwnerName(savedVehicle.getName());
        response.setVehicleFullDetails(savedVehicle.getName() + savedVehicle);
        return response;
    }

    public static IssueTicketResponse map2(Vehicle savedVehicle) {
        IssueTicketResponse response = new IssueTicketResponse();
        response.setVehicleId(savedVehicle.getId());
        response.setOffense(savedVehicle.getOffense());
        return response;
    }

    public static SettleTicketResponse map3(Ticket savedTicket) {
        SettleTicketResponse response = new SettleTicketResponse();
        response.setTicketId(savedTicket.getId());
        response.setDate(savedTicket.getDate());
        response.setAmount(savedTicket.getAmount());
        return response;

    }
    public static ViewTicketResponse map5(Ticket savedTicket) {
        ViewTicketResponse response = new ViewTicketResponse();
        response.setVehicleId(savedTicket.getVehicle().getId());
        response.setDateOfPayment(savedTicket.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        response.setHaspaid(savedTicket.isHasPaid());
        return response;
    }

}