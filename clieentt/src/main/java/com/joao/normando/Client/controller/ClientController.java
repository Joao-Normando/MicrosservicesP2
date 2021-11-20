package com.joao.normando.Client.controller;

import com.joao.normando.Client.model.Client;
import com.joao.normando.Client.repository.ClientRepository;
import com.joao.normando.Client.service.clientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public List<Client> Get() {
        return clientRepository.findAll();
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public Client Post(@Valid @RequestBody Client client)
    {
        return clientRepository.save(client);
    }

    @RequestMapping(value = "/pessoa/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Client> Put(@PathVariable(value = "id") Integer id, @Valid @RequestBody Client newClient)
    {
        Optional<Client> oldClient = clientRepository.findById(id);
        if(oldClient.isPresent()){
            Client client = oldClient.get();
            client.setName(newClient.getName());
            clientRepository.save(client);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Integer id)
    {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            clientRepository.delete(client.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
