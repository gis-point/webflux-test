package com.example.webfluxtest.client.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@AllArgsConstructor
public class SoapEnvelopeRequest {

    private Object body;

}