package com.example.Spring.boot.test.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAirportRequest {
    private String name;
}
