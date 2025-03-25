package com.lucas.application.medico;

import com.lucas.domain.medico.Medico;

public record EnderecoDTO(
        String logradouro,
        Integer numero,
        String complemento,
        String bairro,
        Integer cep,
        String cidade,
        String uf
) {
    public EnderecoDTO(Medico entity){
        this(entity.getLogradouro(), entity.getNumero(),  entity.getComplemento(), entity.getBairro(), entity.getCep(), entity.getCidade(), entity.getUf());
    }
}
