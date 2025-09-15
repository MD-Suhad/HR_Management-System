package com.alibou.security.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String type;
    private String ticketId;
    @ManyToOne
    private ParkingLot parkingLot;
    @OneToOne
    private Vehicle vehicle;

}
