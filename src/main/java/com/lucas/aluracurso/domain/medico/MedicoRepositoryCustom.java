package com.lucas.aluracurso.domain.medico;

import com.lucas.aluracurso.application.medico.MedicoDTO;

import java.util.List;
import java.util.UUID;

public interface MedicoRepositoryCustom {
    Medico findByUUID(UUID medicoUUID);
    List<MedicoDTO> listAll(String orderBy, Integer page, Integer pageSize);
}
