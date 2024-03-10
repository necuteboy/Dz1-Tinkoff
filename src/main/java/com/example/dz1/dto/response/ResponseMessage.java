package com.example.dz1.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseMessage {

    private Long id;

    private String author;

    private String text;

    private String creationDate;

    private List<ResponseImage> images;

}
