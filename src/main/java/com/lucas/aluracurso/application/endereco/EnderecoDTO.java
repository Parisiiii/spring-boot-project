package com.lucas.aluracurso.application.endereco;

import com.lucas.aluracurso.domain.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record EnderecoDTO(@NotNull UUID id, @NotNull String logradouro, BigDecimal numero, String complemento,
                          @NotNull String bairro, @NotNull BigDecimal cep, @NotNull String cidade, @NotNull String uf,
                          @NotNull
                          UUID medico) {
    EnderecoDTO(Endereco endereco) {
        this(endereco.getId(), endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(), endereco.getCep(), endereco.getCidade(), endereco.getUf(), endereco.getMedico().getId());
    }
}
