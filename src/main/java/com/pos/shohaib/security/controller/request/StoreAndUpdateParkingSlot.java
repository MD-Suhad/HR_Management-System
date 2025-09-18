package com.pos.shohaib.security.controller.request;

import com.pos.shohaib.security.domain.model.ParkingLot;
import com.pos.shohaib.security.domain.model.Vehicle;
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
