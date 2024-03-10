package com.example.dz1.mapper;

import com.example.dz1.dto.request.CreateMessage;
import com.example.dz1.dto.response.ResponseMessage;
import com.example.dz1.entity.Message;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ImageMapper.class })
public interface MessageMapper {

    Message toMessage(CreateMessage dto);

    ResponseMessage toResponse(Message message);

    List<ResponseMessage> toResponseList(List<Message> messages);

}