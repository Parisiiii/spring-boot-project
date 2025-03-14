package com.lucas.aluracurso.application.medico;

import com.lucas.aluracurso.domain.medico.Medico;

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
