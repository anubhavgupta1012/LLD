package com.org.parking_lot.controller;

import com.org.parking_lot.dto.IssueTicketRequestDto;
import com.org.parking_lot.dto.IssueTicketResponseDto;
import com.org.parking_lot.dto.ResponseStatus;
import com.org.parking_lot.models.Ticket;
import com.org.parking_lot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController() {
        ticketService = new TicketService();
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {
        IssueTicketResponseDto response = new IssueTicketResponseDto();
        try {
            Ticket ticket = ticketService.issueTicket(issueTicketRequestDto.getVehicleType(), issueTicketRequestDto.getVehicleNumber(),
                    issueTicketRequestDto.getGateId());
            response.setTicket(ticket);
        } catch (Exception exception) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setFailureMessage("SomeThing went wrong");
        }
        return response;
    }
}
