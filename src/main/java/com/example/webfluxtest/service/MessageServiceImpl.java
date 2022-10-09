package com.example.webfluxtest.service;

import com.example.webfluxtest.client.SoapClient;
import com.example.webfluxtest.client.request.SoapEnvelopeRequest;
import com.example.webfluxtest.controller.dto.RequestBodyDto;
import com.example.webfluxtest.model.Message;
import com.example.webfluxtest.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final SoapClient soapClient;
    private final MessageRepository messageRepository;

    @Override
    @Transactional
    public Mono<Integer> processMessage(RequestBodyDto request) {
        return soapClient.call(new SoapEnvelopeRequest(request.getMessage()))
                .flatMap(message -> messageRepository.save(Message.builder().messageId(request.getId()).messages(request.getMessage()).build()))
                .thenReturn(request.getId())
                .doOnError(Exception.class, e -> log.error("Can't save entity"));
    }

}