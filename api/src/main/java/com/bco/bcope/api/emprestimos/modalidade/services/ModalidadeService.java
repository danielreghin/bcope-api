package com.bco.bcope.api.emprestimos.modalidade.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bco.bcope.api.emprestimos.modalidade.dto.ModalidadeDTO;

public interface ModalidadeService {

  /**
   * Sample usage: "curl $HOST:$PORT/modalidade/1".
   *
   * @param modalidadeId id do modalidade
   * @return Objeto contendo os dados do indecxador
   */
  @GetMapping(value = "/modalidade/{modalidadeId}", produces = "application/json")
  ModalidadeDTO getModalidade(@PathVariable int modalidadeId);

}
