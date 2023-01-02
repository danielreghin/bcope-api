package com.bco.bcope.api.emprestimos.modalidade.services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bco.bcope.api.emprestimos.modalidade.dto.ModalidadeDTO;

@Tag(name = "Modalidade", description = "REST API for Modalidade product information.")
public interface ModalidadeService {

  /**
   * Sample usage: "curl $HOST:$PORT/modalidade/1".
   *
   * @param modalidadeId id do modalidade
   * @return Objeto contendo os dados do indecxador
   */
  @Operation(summary = "${api.product-composite.get-composite-product.description}", description = "${api.product-composite.get-composite-product.notes}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
      @ApiResponse(responseCode = "400", description = "${api.responseCodes.badRequest.description}"),
      @ApiResponse(responseCode = "404", description = "${api.responseCodes.notFound.description}"),
      @ApiResponse(responseCode = "422", description = "${api.responseCodes.unprocessableEntity.description}")
  })
  @GetMapping(value = "/modalidade/{modalidadeId}", produces = "application/json")
  ModalidadeDTO getModalidade(@PathVariable int modalidadeId);

}
