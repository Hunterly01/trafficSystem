//package services;
//
//import data.models.Ticket;
//import data.models.Vehicle;
//import data.repository.*;
//import dtos.requests.IssueTicketRequest;
//import dtos.requests.RegisterOfficerRequest;
//import dtos.requests.RegisterVehicleRequest;
//import dtos.responses.SettleTicketResponse;
//import exceptions.NotPaidException;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TicketServiceImplTest {
//    private TicketService ticketService;
//    private TicketRepository ticketRepository;
//    private VehicleServiceImpl vehicleService;
//    private OfficerRepository officerRepository;
//    private OfficerService officerService;
//    private VehicleRepository vehicleRepository;
//    private Ticket ticket;
//    @BeforeEach
//    void setUp() {
//        ticketService = new TicketServiceImpl();
//        ticketRepository = new Tickets();
//        vehicleService = new VehicleServiceImpl();
//        officerService = new OficerServiceImpl();
//        vehicleRepository = new Vehicles();
//        officerRepository = new Officers();
//        ticket  = new Ticket();
//    }
//
//   @Test
//   public void testThatNoOffenders(){
//        assertEquals(0,ticketRepository.count());
//   }
//
//   @Test
//   public void testThatIcanBookAVehicle(){
//       RegisterVehicleRequest vehicleRequest = new RegisterVehicleRequest();
//       vehicleRequest.setChasisNumber("244444");
//       vehicleService.registerVehicle(vehicleRequest);
//
//       RegisterOfficerRequest  officerRequest = new RegisterOfficerRequest();
//       officerRequest.setOffNumber("400");
//       officerService.registerOfficer(officerRequest);
//
//       IssueTicketRequest ticketRequest = new IssueTicketRequest();
//       ticketRequest.setOffense("ONE_WAY");
//       ticketRequest.setOfficerOfNumber(officerRequest.getOffNumber());
//       ticketRequest.setVehicleId(1);
//       ticketService.issueTicket(ticketRequest);
//       assertEquals(1,ticketRepository.count());
//
//   }
//   @Test
//   public void testSettleTicketsThrowNotPaidException(){
//       RegisterVehicleRequest vehicleRequest = new RegisterVehicleRequest();
//       vehicleRequest.setChasisNumber("244444");
//       vehicleService.registerVehicle(vehicleRequest);
//
//       RegisterOfficerRequest  officerRequest = new RegisterOfficerRequest();
//       officerRequest.setOffNumber("400");
//       officerService.registerOfficer(officerRequest);
//
//       IssueTicketRequest ticketRequest = new IssueTicketRequest();
//       ticketRequest.setOffense("ONE_WAY");
//       ticketRequest.setOfficerOfNumber(officerRequest.getOffNumber());
//       ticketRequest.setVehicleId(1);
//       ticketService.issueTicket(ticketRequest);
//       assertEquals(1,ticketRepository.count());
//       ticket.setHasPaid(true);
//       assertThrows(NotPaidException.class, () -> ticketService.settleTicket(1, 2000));
//
//   }
//   @Test
//   public void testSettleTickets(){
//       RegisterVehicleRequest vehicleRequest = new RegisterVehicleRequest();
//       vehicleRequest.setChasisNumber("244444");
//       vehicleService.registerVehicle(vehicleRequest);
//
//       RegisterOfficerRequest  officerRequest = new RegisterOfficerRequest();
//       officerRequest.setOffNumber("400");
//       officerService.registerOfficer(officerRequest);
//
//       IssueTicketRequest ticketRequest = new IssueTicketRequest();
//       ticketRequest.setOffense("ONE_WAY");
//       ticketRequest.setOfficerOfNumber(officerRequest.getOffNumber());
//       ticketRequest.setVehicleId(1);
//       ticketService.issueTicket(ticketRequest);
//       assertEquals(1,ticketRepository.count());
//       Ticket ticket = ticketRepository.findById(1);
//       System.out.println(ticket.getOffence().getAmount());
//       ticketService.settleTicket(1, 35000);
//       ticket.setHasPaid(true);
//       assertEquals(true, ticket.isHasPaid());
//   }
//
//
//    @AfterEach
//    void tearDown() {
//        ticketRepository.deleteAll();
//        vehicleRepository.deleteAll();
//        officerRepository.deleteAll();
//
//    }
//}