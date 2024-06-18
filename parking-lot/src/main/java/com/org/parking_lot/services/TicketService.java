package com.org.parking_lot.services;

import com.org.parking_lot.models.*;
import com.org.parking_lot.repository.GateRepo;
import com.org.parking_lot.repository.ParkingLotRepo;
import com.org.parking_lot.repository.TicketRepo;
import com.org.parking_lot.repository.VehicleRepo;
import com.org.parking_lot.strategy.AllotmentStrategy;
import com.org.parking_lot.strategy.SpotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class TicketService {
    private GateRepo gateRepo;
    private VehicleRepo vehicleRepo;
    private ParkingLotRepo parkingLotRepo;
    private TicketRepo ticketRepo;

    private AllotmentStrategy allotmentStrategy;


    public TicketService() {
        this.gateRepo = new GateRepo();
        this.vehicleRepo = new VehicleRepo();
        parkingLotRepo = new ParkingLotRepo();
        ticketRepo = new TicketRepo();
    }

    public Ticket issueTicket(VehicleType vehicleType, String vehicleNumber, Long gateId) throws Exception {

        //TODO: Validate Data

        // Ticket create,
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        // get gate info from DB
        Optional<Gate> gate = gateRepo.findGateByGateId(gateId);
        if (gate.isEmpty()) {
            throw new Exception();
        }
        ticket.setGate(gate.get());
        ticket.setOperator(gate.get().getOperator());

        // check Vehicle
        Optional<Vehicle> vehicleByVehicleId = vehicleRepo.getVehicleByVehicleId(vehicleNumber);
        Vehicle vehicle;

        vehicle = vehicleByVehicleId.orElse(vehicleRepo.save(new Vehicle(vehicleNumber, vehicleType)));
        ticket.setVehicle(vehicle);

        // Alot Spot
        String parkingLotId = gateRepo.getParkingLotIdByGateId(gateId);
        ParkingLot parkingLot = parkingLotRepo.getParkingLotById(parkingLotId);
        AllotmentStrategy allotmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(parkingLot.getAllotmentStrategyType());
        Spot spot = allotmentStrategy.getSpot(parkingLot, vehicleType);
        if (spot == null) {
            throw new Exception("No Spot Available");
        }
        ticket.setSpot(spot);
        ticket.setId(new Random().nextInt());
        ticketRepo.save(ticket);
        return ticket;
    }
}
