package Ticket.services;

import Ticket.data.models.Offence;
import Ticket.data.models.Officer;
import Ticket.data.models.Ticket;
import Ticket.data.models.Vehicle;
import Ticket.data.repository.OfficerRepository;
import Ticket.data.repository.TicketRepository;
import Ticket.data.repository.VehicleRepository;
import Ticket.exceptions.NotPaidException;
import Ticket.exceptions.OfficerDoesNotExistException;
import Ticket.exceptions.VehicleDoesNotExistException;
import Ticket.dtos.requests.IssueTicketRequest;
import Ticket.dtos.requests.SettleTicketRequest;
import Ticket.dtos.requests.ViewTicketsRequest;
import Ticket.dtos.responses.IssueTicketResponse;
import Ticket.dtos.responses.SettleTicketResponse;
import Ticket.dtos.responses.ViewTicketResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static Ticket.utils.Mapper.*;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private OfficerRepository officerRepository;
    

    @Override
    public IssueTicketResponse issueTicket(IssueTicketRequest request) {
        Optional<Officer> officer = officerRepository.findByOffNumber(request.getOfficerOfNumber());
        validateOfficer(officer);
        Optional<Vehicle> vehicle = vehicleRepository.findById(String.valueOf(request.getVehicleId()));
        validateVehicle(vehicle);
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle.get());
        ticket.setIssuer(officer.get());
        ticket.setOffence(Offence.valueOf(request.getOffense()));
        ticketRepository.save(ticket);
        Vehicle savedVehicle = vehicleRepository.save(vehicle.get());
        return map2(savedVehicle);

    }

    @Override
    public SettleTicketResponse settleTicket(SettleTicketRequest request) {
        Optional<Ticket> ticket = ticketRepository.findById(String.valueOf(request.getTicketId()));
        if(ticket.get().getOffence().getAmount() != request.getFees()){
            throw new NotPaidException("you need to pay fee");
        }
        ticket.get().setHasPaid(true);
       Ticket savedTicket = ticketRepository.save(ticket.get());
        return map3(savedTicket);
    }

    @Override
    public List<ViewTicketResponse> viewTickets(String id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        validateVehicle(vehicle);
        List<Ticket> tickets = new ArrayList<>();
        List<ViewTicketResponse> responses = new ArrayList<>();
        for (Ticket ticket :ticketRepository.findAll()) {
            if(ticket.getVehicle().getId().equals(vehicle.get().getId())){
                tickets.add(ticket);
            }
            tickets.forEach(t->responses.add(map5(t)));
        }

        return responses;
    }




    private void validateVehicle(Optional<Vehicle> vehicle) {
        if(!vehicle.isPresent()) throw new VehicleDoesNotExistException("Vehicle Does not Exit");
    }
    private void validateOfficer(Optional<Officer> officer) {
        if(!officer.isPresent()) throw new OfficerDoesNotExistException("Officer Does not Exit");
    }
}
