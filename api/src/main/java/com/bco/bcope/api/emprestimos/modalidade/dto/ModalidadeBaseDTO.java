package com.bco.bcope.api.emprestimos.modalidade.dto;

public class ModalidadeBaseDTO {
    
    private final int modalidadeId;
    private final String modalidadeNome;
    private final String serviceAddress;
   

    public ModalidadeBaseDTO(){
        modalidadeId = 0;
        modalidadeNome = null;
        serviceAddress = null;
    }

    public ModalidadeBaseDTO(int modalidadeId,String modalidadeNome,String serviceAddress){
        this.modalidadeId = modalidadeId;
        this.modalidadeNome = modalidadeNome;
        this.serviceAddress = serviceAddress;
    }

    public int getModalidadeId() {
        return modalidadeId;
    }

    public String getModalidadeNome() {
        return modalidadeNome;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    
}
