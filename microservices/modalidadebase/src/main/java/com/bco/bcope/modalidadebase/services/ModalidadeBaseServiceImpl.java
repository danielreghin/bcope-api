package com.bco.bcope.emprestimos.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bco.bcope.api.emprestimos.modalidade.dto.ModalidadeBaseDTO;
import com.bco.bcope.api.emprestimos.modalidade.services.ModalidadeService;
import com.bco.bcope.api.exceptions.InvalidInputException;
import com.bco.bcope.api.exceptions.NotFoundException;
import com.bco.bcope.util.http.ServiceUtil;

public class ModalidadeBaseServiceImpl implements ModalidadeBaseService {

  private static final Logger LOG = LoggerFactory.getLogger(ModalidadeBaseServiceImpl.class);
  private final ServiceUtil serviceUtil;

  @Autowired
  public ModalidadeBaseServiceImpl(ServiceUtil serviceUtil) {
    this.serviceUtil = serviceUtil;
  }

  @Override
  public ModalidadeBaseDTO getModalidadeBase(int modalidadeId) {
    LOG.debug("/modalidade return the found modalidade for modalidadeId={}", modalidadeId);

    if (modalidadeId < 1) {
      throw new InvalidInputException("Invalid modalidadeId: " + modalidadeId);
    }

    if (modalidadeId == 13) {
      throw new NotFoundException("No product found for formaCalculoId: " + modalidadeId);
    }
    return new ModalidadeBaseDTO(1, "Modalidade", serviceUtil.getServiceAddress());

  }

}
