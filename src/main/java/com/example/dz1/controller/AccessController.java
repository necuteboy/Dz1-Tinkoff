package com.example.dz1.controller;

import com.example.dz1.dto.response.ResponseImage;
import com.example.dz1.entity.Image;
import com.example.dz1.mapper.ImageMapper;
import com.example.dz1.service.ImageService;
import com.example.dz1.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class AccessController {

    private final ImageService imageService;
    private final MinioService minioService;

    private final ImageMapper mapper;

    @PostMapping
    public ResponseImage upload(MultipartFile file) throws Exception {
        String reference = minioService.upload(file);
        Image image = mapper.toImage(file);
        image.setReference(reference);

        image = imageService.saveMeta(image);

        return mapper.toResponse(image);
    }

    @GetMapping("/{reference}")
    public byte[] download(@PathVariable String reference) throws Exception {
        return minioService.download(reference);
    }

}
