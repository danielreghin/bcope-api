package com.bco.bcope.api.emprestimos.modalidade.services;

public class ServiceAddresses {
  private final String formaCalculo;
  private final String indexador;
  private final String modalidadeBase;
//  private final String modalidadeComposite;

  public ServiceAddresses() {
    formaCalculo = null;
    indexador = null;
    modalidadeBase = null;
    //modalidadeComposite = null;
  }

  public ServiceAddresses(
    String formaCalculo,
    String indexador,
    String modalidadeBase
    ) {

    this.formaCalculo = formaCalculo;
    this.indexador = indexador;
    this.modalidadeBase = modalidadeBase;
    //this.modalidadeComposite = modalidadeComposite;
  }

  public String getFormaCalculo() {
    return formaCalculo;
  }

  public String getIndexador() {
    return indexador;
  }

  public String getModalidadeBase() {
    return modalidadeBase;
  }
/*
  public String getModalidadeComposite() {
    return modalidadeComposite;
  }
  */
}
