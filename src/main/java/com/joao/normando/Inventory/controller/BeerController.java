package com.joao.normando.Inventory.controller;

import com.joao.normando.Inventory.model.Beer;
import com.joao.normando.Inventory.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping(value = "/beer")
public class BeerController {

    @Autowired
    BeerService beerService;

    @RequestMapping(method = RequestMethod.POST, path = "/salvar")
    public ResponseEntity<?> salvar (@RequestBody Beer beerAdd) {

        Beer beer = this.beerService.addUpdate(beerAdd);
        return new ResponseEntity<>(beer, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, path= "/consultQtd/{quantity}/{id}")
    public ResponseEntity<?> consultQtd(@PathVariable  Integer id){

        this.beerService.consultQtd(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/list")
    public List<Beer> beerList() {
        return beerService.listBeer();
    }
}
