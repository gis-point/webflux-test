package com.example.webfluxtest.controller;

import com.example.webfluxtest.controller.dto.RequestBodyDto;
import com.example.webfluxtest.service.MessageService;
import com.example.webfluxtest.util.ExceptionProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/webflux-service")
public class WebFluxController {

    private final ExceptionProcessor exceptionProcessor;

    private final MessageService messageService;

    @PostMapping("/message")
    public DeferredResult<ResponseEntity<Integer>> sendMessage(@RequestBody RequestBodyDto message) {
        DeferredResult<ResponseEntity<Integer>> response = new DeferredResult<>();
        log.info("Calling handleMessage with message {} ", message);
        return response;
    }
}
