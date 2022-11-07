package com.bco.bcope.api.emprestimos.modalidade.dto;

public class FormaCalculoDTO {
    
    private final int formaCalculoId;
    private final String formaCalculoNome;
    private final String serviceAddress;
   

    public FormaCalculoDTO(){
        formaCalculoId = 0;
        formaCalculoNome = null;
        serviceAddress = null;
    }

    public FormaCalculoDTO(int formaCalculoId,String formaCalculoNome,String serviceAddress){
        this.formaCalculoId = formaCalculoId;
        this.formaCalculoNome = formaCalculoNome;
        this.serviceAddress = serviceAddress;
    }


    public int getFormaCalculoId() {
        return formaCalculoId;
    }

    public String getFormaCalculoNome() {
        return formaCalculoNome;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }
}
