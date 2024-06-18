package com.org.parking_lot;


import com.org.parking_lot.controller.TicketController;
import com.org.parking_lot.dto.IssueTicketRequestDto;
import com.org.parking_lot.dto.IssueTicketResponseDto;
import com.org.parking_lot.models.VehicleType;

public class ParkingLotApplication {

    public static void main(String[] args) {

        TicketController ticketController = new TicketController();
        IssueTicketResponseDto response = ticketController.
                issueTicket(new IssueTicketRequestDto(VehicleType.CAR, "HR26EE1111", 11L));
        System.out.println(response);
    }

}
