package com.example.dz1.dto.response;

import com.example.dz1.entity.mongo.OperationType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseOperation {

    private OperationType type;

    private String message;

    private LocalDateTime time;

}
