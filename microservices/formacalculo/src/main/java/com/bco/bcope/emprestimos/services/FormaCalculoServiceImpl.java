package com.bco.bcope.emprestimos.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bco.bcope.api.emprestimos.modalidade.dto.FormaCalculoDTO;
import com.bco.bcope.api.emprestimos.modalidade.services.FormaCalculoService;
import com.bco.bcope.api.exceptions.InvalidInputException;
import com.bco.bcope.api.exceptions.NotFoundException;
import com.bco.bcope.util.http.ServiceUtil;

@RestController
public class FormaCalculoServiceImpl implements FormaCalculoService{

    private static final Logger LOG = LoggerFactory.getLogger(FormaCalculoServiceImpl.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public FormaCalculoServiceImpl(ServiceUtil serviceUtil){
        this.serviceUtil = serviceUtil;
    }

    @Override
    public FormaCalculoDTO getFormaCalculo(int formaCalculoId){
        LOG.debug("/product return the found product for productId={}",formaCalculoId);

        if (formaCalculoId < 1) {
          throw new InvalidInputException("Invalid formaCalculoId: " + formaCalculoId);
        }
    
        if (formaCalculoId == 13) {
          throw new NotFoundException("No product found for formaCalculoId: " + formaCalculoId);
        }
        return new FormaCalculoDTO(1,  "teste", serviceUtil.getServiceAddress());
     }


}
