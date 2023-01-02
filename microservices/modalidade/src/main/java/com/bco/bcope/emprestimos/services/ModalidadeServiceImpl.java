package com.bco.bcope.emprestimos.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bco.bcope.api.emprestimos.modalidade.dto.FormaCalculoDTO;
import com.bco.bcope.api.emprestimos.modalidade.dto.IndexadorDTO;
import com.bco.bcope.api.emprestimos.modalidade.dto.ModalidadeBaseDTO;
import com.bco.bcope.api.emprestimos.modalidade.dto.ModalidadeDTO;
import com.bco.bcope.api.emprestimos.modalidade.services.ModalidadeService;
import com.bco.bcope.api.emprestimos.modalidade.services.ServiceAddresses;
import com.bco.bcope.api.exceptions.InvalidInputException;
import com.bco.bcope.api.exceptions.NotFoundException;
import com.bco.bcope.util.http.ServiceUtil;

@RestController
public class ModalidadeServiceImpl implements ModalidadeService {

  private static final Logger LOG = LoggerFactory.getLogger(ModalidadeServiceImpl.class);
  private final ServiceUtil serviceUtil;
  private final ModalidadeIntegration integration;

  @Autowired
  public ModalidadeServiceImpl(ServiceUtil serviceUtil,
      ModalidadeIntegration modalidadeIntegration) {
    this.serviceUtil = serviceUtil;
    this.integration = modalidadeIntegration;
  }

  @Override
  public ModalidadeDTO getModalidade(int modalidadeId) {
    LOG.debug("/modalidade return the found modalidade for modalidadeId={}", modalidadeId);

    if (modalidadeId < 1) {
      throw new InvalidInputException("Invalid modalidadeId: " + modalidadeId);
    }

    if (modalidadeId == 13) {
      throw new NotFoundException("No product found for formaCalculoId: " + modalidadeId);
    }

    // Cria o objeto
    FormaCalculoDTO formaCalculo = integration.getFormaCalculo(1);
    ModalidadeBaseDTO modalidadeBase = integration.getModalidadeBase(modalidadeId);
    IndexadorDTO indexador = new IndexadorDTO(1, "teste", serviceUtil.getServiceAddress());
    ServiceAddresses enderecos = new ServiceAddresses(formaCalculo.getServiceAddress(),"",modalidadeBase.getServiceAddress());
    ModalidadeDTO modalidade = new ModalidadeDTO(modalidadeBase,indexador, formaCalculo, enderecos);

    return modalidade;
  }

}
