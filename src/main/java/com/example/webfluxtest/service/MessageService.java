package com.example.webfluxtest.service;

import com.example.webfluxtest.controller.dto.RequestBodyDto;
import reactor.core.publisher.Mono;

public interface MessageService {

    Mono<Integer> processMessage(RequestBodyDto message);

}