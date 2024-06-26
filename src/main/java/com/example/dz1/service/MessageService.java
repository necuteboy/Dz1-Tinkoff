package com.example.dz1.service;

import com.example.dz1.entity.Image;
import com.example.dz1.entity.Message;
import com.example.dz1.entity.mongo.Operation;
import com.example.dz1.entity.mongo.OperationType;
import com.example.dz1.repository.ImageRepository;
import com.example.dz1.repository.MessageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final OperationService operationService;

    private final MessageRepository messageRepository;
    private final ImageRepository imageRepository;

    @Cacheable(value = "MessageService::getMessages")
    public List<Message> getMessages() {
        operationService.logOperation(
                Operation.builder()
                        .message("Messages read from database")
                        .time(LocalDateTime.now())
                        .type(OperationType.READ)
                        .build()
        );

        return messageRepository.findAll();
    }

    @Cacheable(value = "MessageService::getMessage", key = "#id")
    public Message getMessage(long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no message with such an id"));

        operationService.logOperation(
                Operation.builder()
                        .message(String.format("Message read from database: %s", message.getText()))
                        .time(LocalDateTime.now())
                        .type(OperationType.READ)
                        .build()
        );

        return message;
    }

    @CacheEvict(value = "MessageService::getMessages", allEntries = true)
    public Message createMessage(Message message) {
        List<Image> images = message.getImages();

        if (Objects.nonNull(images)) {
            images = imageRepository.findAllByReferenceIn(images.stream()
                    .map(Image::getReference)
                    .collect(Collectors.toList()));

            if (message.getImages().size() != images.size()) {
                throw new EntityNotFoundException("Some images were not found");
            }

            message.setImages(images);
        }

        operationService.logOperation(
                Operation.builder()
                        .message(String.format("Message saved to database: %s", message.getText()))
                        .time(LocalDateTime.now())
                        .type(OperationType.WRITE)
                        .build()
        );

        return messageRepository.save(message);
    }

}
