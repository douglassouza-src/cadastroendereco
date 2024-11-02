package com.example.projetospringmvc_spring;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {
    
    private final RestTemplate restTemplate;

    public CepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AddressResponse getAddressByCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return restTemplate.getForObject(url, AddressResponse.class);
    }
}
