package com.example.webfluxtest.client;

import com.example.webfluxtest.client.request.SoapEnvelopeRequest;
import com.example.webfluxtest.wsdl.Resultcode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class SoapClient {

    private final WebClient webClient;

    public Mono<Integer> call(SoapEnvelopeRequest soapEnvelopeRequest) {
        return webClient
                .post()
                .uri("soapServiceUrl")
                .contentType(MediaType.TEXT_XML)
                .body(Mono.just(soapEnvelopeRequest), SoapEnvelopeRequest.class)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> clientResponse
                        .bodyToMono(String.class)
                        .flatMap(errorResponseBody ->
                                Mono.error(new ResponseStatusException(clientResponse.statusCode(), errorResponseBody))))
                .bodyToMono(Resultcode.class)
                .flatMap(response -> Mono.just(response.getValue()))
                .doOnError(Exception.class, error -> log.error("Error during client call: " + error));
    }

}