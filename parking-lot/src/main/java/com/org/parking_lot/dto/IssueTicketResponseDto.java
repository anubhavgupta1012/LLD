package com.org.parking_lot.dto;

import com.org.parking_lot.models.Ticket;
import lombok.Data;

@Data
public class IssueTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
    private String failureMessage;
}
