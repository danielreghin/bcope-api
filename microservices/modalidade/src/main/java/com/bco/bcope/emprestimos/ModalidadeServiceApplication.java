package com.bco.bcope.emprestimos;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.beans.factory.annotation.Value;
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

  @Value("${api.common.version}")         String apiVersion;
  @Value("${api.common.title}")           String apiTitle;
  @Value("${api.common.description}")     String apiDescription;
  @Value("${api.common.termsOfService}")  String apiTermsOfService;
  @Value("${api.common.license}")         String apiLicense;
  @Value("${api.common.licenseUrl}")      String apiLicenseUrl;
  @Value("${api.common.externalDocDesc}") String apiExternalDocDesc;
  @Value("${api.common.externalDocUrl}")  String apiExternalDocUrl;
  @Value("${api.common.contact.name}")    String apiContactName;
  @Value("${api.common.contact.url}")     String apiContactUrl;
  @Value("${api.common.contact.email}")   String apiContactEmail;

  public static void main(String[] args) {
    SpringApplication.run(ModalidadeServiceApplication.class, args);
  }

  /**
   * Sample usage: "curl $HOST:$PORT/modalidade/1".
   *
   * @param modalidadeId id do modalidade
   * @return Objeto contendo os dados do indecxador
   */
  @GetMapping(value = "/", produces = "application/json")
  String getIndex() {
    return "Service Alive";
  }

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public OpenAPI getOpenApiDocumentation() {
    return new OpenAPI()
        .info(new Info().title(apiTitle)
            .description(apiDescription)
            .version(apiVersion)
            .contact(new Contact()
                .name(apiContactName)
                .url(apiContactUrl)
                .email(apiContactEmail))
            .termsOfService(apiTermsOfService)
            .license(new License()
                .name(apiLicense)
                .url(apiLicenseUrl)))
        .externalDocs(new ExternalDocumentation()
            .description(apiExternalDocDesc)
            .url(apiExternalDocUrl));
  }

}
