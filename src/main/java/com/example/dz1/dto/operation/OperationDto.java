package com.example.dz1.dto.operation;

import com.example.dz1.entity.mongo.OperationType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class OperationDto {
    private OperationType type;

    private LocalDate time;
}
