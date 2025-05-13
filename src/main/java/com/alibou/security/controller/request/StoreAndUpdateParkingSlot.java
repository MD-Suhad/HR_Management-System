package com.alibou.security.controller.request;

import com.alibou.security.entity.ParkingLot;
import com.alibou.security.entity.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class StoreAndUpdateParkingSlot {
    private String type;
    private String ticketId;
    private ParkingLot parkingLot;
    private Vehicle vehicle;
}
