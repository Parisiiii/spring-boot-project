package com.lucas.aluracurso.domain.endereco;

import com.lucas.aluracurso.application.endereco.EnderecoDTO;
import com.lucas.aluracurso.application.medico.MedicoDTO;
import com.lucas.aluracurso.domain.medico.Medico;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepositoryCustom {
    Endereco findByUUID(UUID enderecoUUID);
    List<EnderecoDTO> listAll(String orderBy, Integer page, Integer pageSize);
}
