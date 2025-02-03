package com.lucas.aluracurso.application.medico;

import com.lucas.aluracurso.domain.medico.Medico;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;


public record MedicoDTO(UUID id,
                        @NotNull String nome,
                        String telefone,
                        @NotNull String email,
                        @NotNull String CRM,
                        @NotNull String especialidade,
                        String logradouro,
                        Integer numero,
                        String complemento,
                        String bairro,
                        Integer cep,
                        String cidade,
                        String uf) {
    MedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCRM(),
                medico.getEspecialidade(), medico.getLogradouro(), medico.getNumero(), medico.getComplemento(), medico.getBairro(), medico.getCep(), medico.getCidade(), medico.getUf());
    }
}

