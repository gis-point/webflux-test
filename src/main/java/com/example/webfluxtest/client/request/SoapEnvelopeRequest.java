package com.example.webfluxtest.client.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class SoapEnvelopeRequest {

    private Object body;

}
