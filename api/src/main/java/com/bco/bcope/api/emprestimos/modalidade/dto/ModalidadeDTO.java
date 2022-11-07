package com.bco.bcope.api.emprestimos.modalidade.dto;

import com.bco.bcope.api.emprestimos.modalidade.services.ServiceAddresses;

public class ModalidadeDTO {
    
    private final ModalidadeBaseDTO modalidadeBase;
    private final IndexadorDTO indexador;
    private final FormaCalculoDTO formaCalculo;
    private final ServiceAddresses serviceAddress;

    public ModalidadeDTO(ModalidadeBaseDTO modalidade, IndexadorDTO indexador, FormaCalculoDTO formaCalculo,ServiceAddresses serviceAddress){
        this.modalidadeBase = modalidade;
        this.indexador = indexador;
        this.formaCalculo = formaCalculo;
        this.serviceAddress = serviceAddress;
    }

    public ModalidadeBaseDTO getModalidadeBase() {
        return modalidadeBase;
    }

    public IndexadorDTO getIndexador() {
        return indexador;
    }

    public FormaCalculoDTO getFormaCalculo() {
        return formaCalculo;
    }

    public ServiceAddresses getServiceAddress() {
        return serviceAddress;
    }
 


}
