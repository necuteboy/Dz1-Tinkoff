package com.example.dz1.mapper;

import com.example.dz1.dto.response.ResponseImage;
import com.example.dz1.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    @Mapping(target = "filename", expression = "java(file.getOriginalFilename())")
    Image toImage(MultipartFile file);

    ResponseImage toResponse(Image image);

    Image toImage(String reference);

    List<ResponseImage> toResponseList(List<Image> images);

}
