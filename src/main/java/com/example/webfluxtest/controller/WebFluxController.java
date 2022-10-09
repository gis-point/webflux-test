package com.example.webfluxtest.controller;

import com.example.webfluxtest.controller.dto.RequestBodyDto;
import com.example.webfluxtest.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/webflux-service")
public class WebFluxController {

    private final MessageService messageService;

    @PostMapping("/message")
    public Mono<Integer> sendMessage(@RequestBody RequestBodyDto message) {
        log.info("Calling handleMessage with message {} ", message);
        return messageService.processMessage(message);
    }

}