package com.example.dz1.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateMessage {

    private String author;

    private String text;

    private List<String> images;

}
