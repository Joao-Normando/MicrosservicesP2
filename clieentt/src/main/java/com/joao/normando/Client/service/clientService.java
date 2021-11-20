package com.joao.normando.Client.service;

import com.joao.normando.Client.model.Client;
import com.joao.normando.Client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class clientService {

    @Autowired
    ClientRepository clientRepository;

    }
