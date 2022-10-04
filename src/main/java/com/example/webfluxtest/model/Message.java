package com.example.webfluxtest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    private Long id;

    private int messageId;

    private String messages;

}