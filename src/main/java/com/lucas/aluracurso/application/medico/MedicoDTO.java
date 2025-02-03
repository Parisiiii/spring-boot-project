package com.lucas.aluracurso.application.medico;

import com.lucas.aluracurso.domain.endereco.Endereco;
import com.lucas.aluracurso.domain.medico.Medico;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record MedicoDTO(UUID id, @NotNull String nome, String telefone, @NotNull String email, @NotNull String CRM,
                        @NotNull String especialidade) {
    MedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCRM(), medico.getEspecialidade());
    }
}

