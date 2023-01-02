package com.bco.bcope.emprestimos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FormaCalculoServiceApplicationTests {
    @Autowired
    private WebTestClient client;

    @Test
    void getFormaCalculoById() {
        int formaCalculoId = 1;

        client.get()
                .uri("/formacalculo/" + formaCalculoId)
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.formaCalculoId").isEqualTo(formaCalculoId);
    }

    
      @Test
      void getFormaCalculoInvalidParameterString() {
      
      client.get()
      .uri("/formacalculo/no-integer")
      .accept(APPLICATION_JSON)
      .exchange()
      .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST)
      .expectHeader().contentType(APPLICATION_JSON)
      .expectBody()
      .jsonPath("$.path").isEqualTo("/formacalculo/no-integer")
      .jsonPath("$.message").isEqualTo("Type mismatch.");
      }
      
      @Test
      void getFormaCalculoNotFound() {
      
      int formaCalculoIdNotFound = 13;
      
      client.get()
      .uri("/formacalculo/" + formaCalculoIdNotFound)
      .accept(APPLICATION_JSON)
      .exchange()
      .expectStatus().isNotFound()
      .expectHeader().contentType(APPLICATION_JSON)
      .expectBody()
      .jsonPath("$.path").isEqualTo("/formacalculo/" + formaCalculoIdNotFound)
      .jsonPath("$.message").isEqualTo("No product found for formaCalculoId: " +
      formaCalculoIdNotFound);
      }
      
      @Test
      void getFormaCalculoInvalidParameterNegativeValue() {
      
      int productIdInvalid = -1;
      
      client.get()
      .uri("/formacalculo/" + productIdInvalid)
      .accept(APPLICATION_JSON)
      .exchange()
      .expectStatus().isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY)
      .expectHeader().contentType(APPLICATION_JSON)
      .expectBody()
      .jsonPath("$.path").isEqualTo("/formacalculo/" + productIdInvalid)
      .jsonPath("$.message").isEqualTo("Invalid formaCalculoId: " +
      productIdInvalid);
      }
      
     

}
