package com.example.webfluxtest.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RequestBodyDto {

    @NotNull
    private Integer id;

    @NotEmpty
    private String message;

}