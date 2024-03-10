package com.example.dz1.controller;

import com.example.dz1.dto.operation.OperationDto;
import com.example.dz1.dto.response.ResponseOperation;
import com.example.dz1.mapper.OperationMapper;
import com.example.dz1.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OperationController {

    private final OperationService service;
    private final OperationMapper mapper;

    @QueryMapping
    public List<ResponseOperation> getOperations(@Argument OperationDto filter) {
        return mapper.toResponseList(service.getOperations(filter));
    }

}
