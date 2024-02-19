package com.meuscruso.projetogof.springpatternsgof.repository;

import com.meuscruso.projetogof.springpatternsgof.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
