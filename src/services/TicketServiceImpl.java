package services;

import data.models.Offence;
import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;
import data.repository.*;
import dtos.requests.IssueTicketRequest;
import dtos.responses.IssueTicketResponse;
import dtos.responses.SettleTicketResponse;
import dtos.responses.ViewTicketResponse;
import exceptions.*;

import java.util.ArrayList;
import java.util.List;


public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository = new Tickets();
    private VehicleRepository vehicleRepository = new Vehicles();
    private OfficerRepository officerRepository = new Officers();

    @Override
    public IssueTicketResponse issueTicket(IssueTicketRequest request) {
        Officer officer = officerRepository.findByOffNumber(request.getOfficerOfNumber());
        validateOfficer(officer);
        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId());
        validateVehicle(vehicle);
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setIssuer(officer);
        ticket.setOffence(Offence.valueOf(request.getOffense()));
        ticketRepository.save(ticket);
        vehicle.getTickets().add(ticket);
        vehicleRepository.save(vehicle);
        return new IssueTicketResponse();

    }

    @Override
    public SettleTicketResponse settleTicket(int ticketId, int fees) {
        Ticket ticket = ticketRepository.findById(ticketId);
        if(ticket.getOffence().getAmount() != fees){
            throw new NotPaidException("you need to pay fee");
        }
        ticket.setHasPaid(true);
        ticketRepository.save(ticket);
        return new SettleTicketResponse();
    }

    @Override
    public ViewTicketResponse viewTickets(int vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId);
        validateVehicle(vehicle);
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket :ticketRepository.findAll()) {
            if(ticket.getVehicle().getId() == vehicle.getId()){
                tickets.add(ticket);
            }
        }
        System.out.println(tickets);

        return new ViewTicketResponse();
    }


    private void validateVehicle(Vehicle vehicle) {
        if(vehicle == null) throw new VehicleDoesNotExistException("Vehicle Does not Exit");
    }
    private void validateOfficer(Officer officer) {
        if(officer == null) throw new OfficerDoesNotExistException("Officer Does not Exit");
    }
}
