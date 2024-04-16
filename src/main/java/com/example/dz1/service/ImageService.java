package com.example.dz1.service;

import com.example.dz1.entity.Image;
import com.example.dz1.entity.mongo.Operation;
import com.example.dz1.entity.mongo.OperationType;
import com.example.dz1.repository.ImageRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final OperationService operationService;

    private final ImageRepository imageRepository;

    @Cacheable(value = "ImageService::getMeta", key = "#image.reference")
    @CacheEvict(value = "ImageService::getAllMeta", allEntries = true)
    @Transactional
    public Image saveMeta(Image image) {
        var response = imageRepository.save(image);
        operationService.logOperation(
                Operation.builder()
                        .message(String.format("Meta for %s saved to database", image.getReference()))
                        .time(LocalDateTime.now())
                        .type(OperationType.WRITE)
                        .build()
        );

        return response;
    }

    @Cacheable(value = "ImageService::getAllMeta")
    public List<Image> getAllMeta() {
        operationService.logOperation(
                Operation.builder()
                        .message("All meta read from database")
                        .time(LocalDateTime.now())
                        .type(OperationType.READ)
                        .build()
        );

        return imageRepository.findAll();
    }

    @Cacheable(value = "ImageService::getMeta", key = "#reference")
    public Image getMeta(String reference) {
        Image image = imageRepository.findByReference(reference)
                .orElseThrow(() -> new EntityNotFoundException("There is no file with such a reference"));

        operationService.logOperation(
                Operation.builder()
                        .message(String.format("Meta read for %s from database", reference))
                        .time(LocalDateTime.now())
                        .type(OperationType.READ)
                        .build()
        );

        return image;
    }

}
