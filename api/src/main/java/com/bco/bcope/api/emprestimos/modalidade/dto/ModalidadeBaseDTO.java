package com.bco.bcope.api.emprestimos.modalidade.dto;

public class ModalidadeBaseDTO {
    
    private final int modalidadeId;
    private final String modelidadeNome;
    private final String serviceAddress;

   

    public ModalidadeBaseDTO(int modalidadeId,String modalidadeNome,String serviceAddress){
        this.modalidadeId = modalidadeId;
        this.modelidadeNome = modalidadeNome;
        this.serviceAddress = serviceAddress;
    }

    public int getModalidadeId() {
        return modalidadeId;
    }

    public String getModelidadeNome() {
        return modelidadeNome;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    
}
