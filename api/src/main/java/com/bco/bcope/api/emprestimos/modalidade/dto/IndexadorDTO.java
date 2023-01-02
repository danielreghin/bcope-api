package com.bco.bcope.api.emprestimos.modalidade.dto;

public class IndexadorDTO {

    private final int indexadorId;
    private final String indexadorNome;
    private final String serviceAddress;


    public IndexadorDTO(int indexadorId, String indexadorNome,String serviceAddress) {
        this.indexadorId = indexadorId;
        this.indexadorNome = indexadorNome;
        this.serviceAddress = serviceAddress;

    }

    public int getIndexadorId() {
        return indexadorId;
    }

    public String getIndexadorNome() {
        return indexadorNome;
    }
           
    
    public String getServiceAddress() {
        return serviceAddress;
    }

}
