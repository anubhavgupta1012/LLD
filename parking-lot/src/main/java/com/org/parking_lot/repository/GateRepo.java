package com.org.parking_lot.repository;

import com.org.parking_lot.models.Gate;
import com.org.parking_lot.models.Operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepo {

    Map<Long, Gate> gateMap = new HashMap<>();

    public GateRepo() {
        gateMap.put(11L, new Gate(11L, 11, new Operator(1, 1, "Kejriwal")));
    }

    public Optional<Gate> findGateByGateId(Long gateid) {

        if (gateMap.containsKey(gateid)) {
            return Optional.ofNullable(gateMap.get(gateid));
        }
        return Optional.empty();
    }

    public String getParkingLotIdByGateId(long gateId) {
        return String.valueOf("1123");
    }
}
