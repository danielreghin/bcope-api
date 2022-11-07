package com.bco.bcope.api.emprestimos.modalidade.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bco.bcope.api.emprestimos.modalidade.dto.FormaCalculoDTO;

public interface FormaCalculoService {
    
    /**
   * Sample usage: "curl $HOST:$PORT/formacalculo/1".
   *
   * @param formaCalculoId Id of the formaCalculo
   * @return the formaCalculo, if found, else null
   */
    @GetMapping(
        value    = "/formacalculo/{formaCalculoId}",
        produces = "application/json")
     FormaCalculoDTO getFormaCalculo(@PathVariable int formaCalculoId);

}
