package com.bco.bcope.emprestimos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@ComponentScan("com.bco.bcope")
public class ModalidadeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModalidadeServiceApplication.class, args);
	}
	


	 /**
   * Sample usage: "curl $HOST:$PORT/modalidade/1".
   *
   * @param modalidadeId id do modalidade
   * @return Objeto contendo os dados do indecxador
   */
  @GetMapping(
    value = "/",
    produces = "application/json")
  String getIndex(){
	return "Service Alive";
  }

  @Bean
RestTemplate restTemplate() {
   return new RestTemplate();
}


}
