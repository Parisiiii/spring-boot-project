package com.lucas.aluracurso.application.medico;

import com.lucas.aluracurso.domain.medico.Medico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;


public record MedicoDTO(UUID id,
                        @NotBlank String nome,
                        String telefone,
                        @NotBlank String email,
                        @NotBlank String CRM,
                        String especialidade,
                        String status,
                        @Valid EnderecoDTO endereco) {
    private MedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCRM(),
                medico.getEspecialidade(), medico.getStatus().getDescricao(), new EnderecoDTO(medico));
    }

    public static MedicoDTO of(Medico medico) {
        return new MedicoDTO(medico);
    }
}

