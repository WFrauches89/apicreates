package com.meuscruso.projetogof.springpatternsgof.repository;

import com.meuscruso.projetogof.springpatternsgof.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Client, Long> {
}
