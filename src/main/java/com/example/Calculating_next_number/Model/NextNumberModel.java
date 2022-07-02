package com.example.Calculating_next_number.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class NextNumberModel {
    @Id
    private int categoryCode;
    private int value;
}
