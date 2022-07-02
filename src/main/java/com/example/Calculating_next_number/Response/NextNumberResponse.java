package com.example.Calculating_next_number.Response;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class NextNumberResponse {
    private int categoryCode;
    private int oldValue;
    private int newValue;
}
