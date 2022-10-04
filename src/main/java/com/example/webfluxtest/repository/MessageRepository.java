package com.example.webfluxtest.repository;

import com.example.webfluxtest.model.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<Message, Integer> {

}