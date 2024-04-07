package com.example.dz1.controller;

import com.example.dz1.dto.response.ResponseImage;
import com.example.dz1.mapper.ImageMapper;
import com.example.dz1.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageService service;
    private final ImageMapper mapper;

    @QueryMapping
    public List<ResponseImage> getMetas() {
        return mapper.toResponseList(service.getAllMeta());
    }

    @QueryMapping
    public ResponseImage getMeta(@Argument String reference) {
        return mapper.toResponse(service.getMeta(reference));
    }

}
