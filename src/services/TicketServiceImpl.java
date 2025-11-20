package services;

import data.models.Offence;
import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;
import data.repository.*;
import dtos.requests.IssueTicketRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketsRequest;
import dtos.responses.IssueTicketResponse;
import dtos.responses.SettleTicketResponse;
import dtos.responses.ViewTicketResponse;
import exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static utils.Mapper.*;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private OfficerRepository officerRepository;
    public TicketServiceImpl(TicketRepository ticketRepository, OfficerRepository officerRepository) {
        this.ticketRepository = ticketRepository;
        this.officerRepository = officerRepository;
        this.vehicleRepository = vehicleRepository;
    }
    public TicketServiceImpl(){

    }

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

        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return map2(savedVehicle);

    }

    @Override
    public SettleTicketResponse settleTicket(SettleTicketRequest request) {
        Ticket ticket = ticketRepository.findById(request.getTicketId());
        if(ticket.getOffence().getAmount() != request.getFees()){
            throw new NotPaidException("you need to pay fee");
        }
        ticket.setHasPaid(true);
       Ticket savedTicket = ticketRepository.save(ticket);
        return map3(savedTicket);
    }

    @Override
    public List<ViewTicketResponse> viewTickets(ViewTicketsRequest  request) {
        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId());
        validateVehicle(vehicle);
        List<Ticket> tickets = new ArrayList<>();
        List<ViewTicketResponse> responses = new ArrayList<>();
        for (Ticket ticket :ticketRepository.findAll()) {
            if(ticket.getVehicle().getId() == vehicle.getId()){
                tickets.add(ticket);
            }
            tickets.forEach(t->responses.add(map5(t)));
        }

        return responses;
    }




    private void validateVehicle(Vehicle vehicle) {
        if(vehicle == null) throw new VehicleDoesNotExistException("Vehicle Does not Exit");
    }
    private void validateOfficer(Officer officer) {
        if(officer == null) throw new OfficerDoesNotExistException("Officer Does not Exit");
    }
}
