package com.bco.bcope.emprestimos.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bco.bcope.api.emprestimos.modalidade.dto.FormaCalculoDTO;
import com.bco.bcope.api.emprestimos.modalidade.dto.IndexadorDTO;
import com.bco.bcope.api.emprestimos.modalidade.dto.ModalidadeBaseDTO;
import com.bco.bcope.api.emprestimos.modalidade.dto.ModalidadeDTO;
import com.bco.bcope.api.emprestimos.modalidade.services.ModalidadeCompositeService;
import com.bco.bcope.api.emprestimos.modalidade.services.ServiceAddresses;
import com.bco.bcope.api.exceptions.InvalidInputException;
import com.bco.bcope.api.exceptions.NotFoundException;
import com.bco.bcope.util.http.ServiceUtil;

public class ModalidadeCompositeServiceImpl implements ModalidadeService {

  private static final Logger LOG = LoggerFactory.getLogger(ModalidadeCompositeServiceImpl.class);
  private final ServiceUtil serviceUtil;
  private final ModalidadeCompositeIntegration integration;

  @Autowired
  public ModalidadeCompositeServiceImpl(ServiceUtil serviceUtil,
      ModalidadeCompositeIntegration modalidadeCompositeIntegration) {
    this.serviceUtil = serviceUtil;
    this.integration = modalidadeCompositeIntegration;
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
    ModalidadeBaseDTO modalidadeBase = integration.getModalidade(modalidadeId);
    FormaCalculoDTO formaCalculo = integration.getFormaCalculo(1);
    ServiceAddresses enderecos = new ServiceAddresses(formaCalculo.getServiceAddress(),"",modalidadeBase.getServiceAddress());
    

    ModalidadeDTO modalidade = new ModalidadeDTO(modalidadeBase,
        new IndexadorDTO(1, "teste", serviceUtil.getServiceAddress()), formaCalculo, enderecos);
    return modalidade;
  }

}
