package com.joao.normando.Inventory.service;

import com.joao.normando.Inventory.repository.BeerRepository;
import com.joao.normando.Inventory.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BeerService {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    public List<Beer> listBeer() {
        List<Beer> beers = new ArrayList<>();
        beerRepository.findAll().forEach(beer -> beers.add(beer));
        return beers;
    }

    public Beer search (Integer id) {
        return beerRepository.findById(id).get();
    }

    public Beer addUpdate (Beer beer) {
        return beerRepository.save(beer);
    }

    public void delete(Integer id) {
        beerRepository.deleteById(id);
    }

    public Double consultQtd (Integer id){
        Beer beer = beerRepository.findById(id).get();
        return beer.getQuantity();
    }
}
