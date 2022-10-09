package com.example.webfluxtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebServiceConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.webfluxtest.wsdl");
        return marshaller;
    }

    @Bean
    public WebClient webClient() {
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder().
                codecs(clientCodecConfigurer -> {
//                    clientCodecConfigurer.customCodecs().register(new Jaxb2SoapEncoder());
//                    clientCodecConfigurer.customCodecs().register(new Jaxb2SoapDecoder());
                }).build();

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create().wiretap(true)))
                .exchangeStrategies(exchangeStrategies)
                .build();
    }

}