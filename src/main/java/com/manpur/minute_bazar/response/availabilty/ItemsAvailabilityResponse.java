package com.manpur.minute_bazar.response.availabilty;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemsAvailabilityResponse {
    private List<ItemAvailabilityResponse> itemsAvailabilityResponse;

}
