package com.example.webfluxtest.service;

import com.example.webfluxtest.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public int processMessage(String message) {
        return 0;
    }

}