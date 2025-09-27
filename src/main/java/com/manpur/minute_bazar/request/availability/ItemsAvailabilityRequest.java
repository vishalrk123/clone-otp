package com.manpur.minute_bazar.request.availability;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemsAvailabilityRequest {
    private List<ItemAvailabilityRequest> itemsAvailabilityRequest;
}
