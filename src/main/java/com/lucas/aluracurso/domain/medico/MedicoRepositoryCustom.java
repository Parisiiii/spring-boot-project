package com.lucas.aluracurso.domain.medico;

import com.lucas.aluracurso.application.medico.MedicoDTO;

import java.util.List;
import java.util.UUID;

public interface MedicoRepositoryCustom {
    List<MedicoDTO> listAll(String orderBy, Integer page, Integer pageSize);
}
