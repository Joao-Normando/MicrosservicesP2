package com.joao.normando.Inventory.repository;

import com.joao.normando.Inventory.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Integer> {
}
