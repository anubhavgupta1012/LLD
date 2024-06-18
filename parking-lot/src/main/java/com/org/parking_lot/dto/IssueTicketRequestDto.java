package com.org.parking_lot.dto;

import com.org.parking_lot.models.VehicleType;
import lombok.Data;

@Data
public class IssueTicketRequestDto {

    private VehicleType vehicleType;
    private String vehicleNumber;
    private Long gateId;

    public IssueTicketRequestDto(VehicleType vehicleType, String vehicleNumber, Long gateId) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.gateId = gateId;
    }
}
