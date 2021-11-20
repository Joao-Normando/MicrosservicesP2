package com.joao.normando.Client.service;

import com.joao.normando.Client.model.Client;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
@Service
public class ViaCEPClient {

    public Client searchAddress(String cep){
        RestTemplate template = new RestTemplate();
        return template.getForObject("https://viacep.com.br/ws/{cep}/json",Client.class, cep);
    }
}