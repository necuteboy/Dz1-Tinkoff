package com.example.dz1.controller;

import com.example.dz1.dto.request.CreateMessage;
import com.example.dz1.dto.response.ResponseMessage;
import com.example.dz1.mapper.MessageMapper;
import com.example.dz1.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final MessageMapper mapper;

    @QueryMapping
    public List<ResponseMessage> getMessages() {
        return mapper.toResponseList(messageService.getMessages());
    }

    @QueryMapping
    public ResponseMessage getMessage(@Argument long id) {
        return mapper.toResponse(messageService.getMessage(id));
    }

    @MutationMapping
    public ResponseMessage createMessage(@Argument CreateMessage message) {
        return mapper.toResponse(messageService.createMessage(mapper.toMessage(message)));
    }

}
