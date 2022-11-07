package com.bco.bcope.api.emprestimos.modalidade.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bco.bcope.api.emprestimos.modalidade.dto.IndexadorDTO;

public interface IndexadorServices {
 
   /**
   * Sample usage: "curl $HOST:$PORT/indexador/1".
   *
   * @param indexadorId id do indexador
   * @return Objeto contendo os dados do indecxador
   */
  @GetMapping(
    value = "/indexador/{indexadorId}",
    produces = "application/json")
  IndexadorDTO getIndexador(@PathVariable int indexadorId);

}
