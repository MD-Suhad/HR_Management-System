package com.alibou.security.entity;

import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Slot {
    private String type;
    private String ticketId;
    @OneToOne
    private Vehicle vehicle;
}
