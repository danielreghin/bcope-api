package com.bco.bcope.emprestimos.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.bco.bcope.api.emprestimos.modalidade.dto.FormaCalculoDTO;
import com.bco.bcope.api.emprestimos.modalidade.dto.ModalidadeBaseDTO;
import com.bco.bcope.api.emprestimos.modalidade.services.FormaCalculoService;
import com.bco.bcope.api.emprestimos.modalidade.services.ModalidadeBaseService;
import com.bco.bcope.api.exceptions.InvalidInputException;
import com.bco.bcope.api.exceptions.NotFoundException;
import com.bco.bcope.util.http.HttpErrorInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModalidadeCompositeIntegration implements FormaCalculoService, ModalidadeBaseService {
    private static final Logger LOG = LoggerFactory.getLogger(ModalidadeCompositeIntegration.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private final String modalidadeBaseServiceUrl;
    private final String formaCalculoServiceUrl;

    @Autowired
    public ModalidadeCompositeIntegration(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            @Value("${app.modalidadebase-service.host}") String modalidadeBaseServiceHost,
            @Value("${app.modalidadebase-service.port}") int modalidadeBaseServicePort,
            @Value("${app.formacalculo-service.host}") String formaCalculoServiceHost,
            @Value("${app.formacalculo-service.port}") int formaCalculoServicePort
    ) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.modalidadeBaseServiceUrl = "http://" + modalidadeBaseServiceHost + ":" + modalidadeBaseServicePort + "/modalidade";
        this.formaCalculoServiceUrl = "http://" + formaCalculoServiceHost + ":" + formaCalculoServicePort
                + "/formacalculo";

    }

    @Override
    public FormaCalculoDTO getFormaCalculo(int formaCalculoId) {
        String url = formaCalculoServiceUrl + formaCalculoId;
        FormaCalculoDTO f = restTemplate.getForObject(url, FormaCalculoDTO.class);
        return f;
    }

    private String getErrorMessage(HttpClientErrorException ex) {
        try {
          return mapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class).getMessage();
        } catch (IOException ioex) {
          return ex.getMessage();
        }
      }
    

    @Override
    public ModalidadeBaseDTO getModalidadeBase(int modalidadeId) {
        try{
        String url = modalidadeBaseServiceUrl + modalidadeId;
        LOG.debug("Will call getProduct API on URL: {}", url);
        ModalidadeBaseDTO f = restTemplate.getForObject(url, ModalidadeBaseDTO.class);
        LOG.debug("Found a product with id: {}", f.getModalidadeId());
        return f;
        }catch(HttpClientErrorException ex){
            switch (ex.getStatusCode()) {
                case NOT_FOUND:
                  throw new NotFoundException(getErrorMessage(ex));
        
                case UNPROCESSABLE_ENTITY:
                  throw new InvalidInputException(getErrorMessage(ex));
        
                default:
                  LOG.warn("Got an unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                  LOG.warn("Error body: {}", ex.getResponseBodyAsString());
                  throw ex;
              }
      

        }
    }

    /*
     * 
     * 
  public List<Recommendation> getRecommendations(int productId) {

    try {
      String url = recommendationServiceUrl + productId;

      LOG.debug("Will call getRecommendations API on URL: {}", url);
      List<Recommendation> recommendations = restTemplate
        .exchange(url, GET, null, new ParameterizedTypeReference<List<Recommendation>>() {})
        .getBody();

      LOG.debug("Found {} recommendations for a product with id: {}", recommendations.size(), productId);
      return recommendations;

    } catch (Exception ex) {
      LOG.warn("Got an exception while requesting recommendations, return zero recommendations: {}", ex.getMessage());
      return new ArrayList<>();
    }
  }
     */





}
