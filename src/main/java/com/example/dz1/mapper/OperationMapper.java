package com.example.dz1.mapper;

import com.example.dz1.dto.response.ResponseOperation;
import com.example.dz1.entity.mongo.Operation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    ResponseOperation toResponse(Operation operation);

    List<ResponseOperation> toResponseList(List<Operation> operations);

}
