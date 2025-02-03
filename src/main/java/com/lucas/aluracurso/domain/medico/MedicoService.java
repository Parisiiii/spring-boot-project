package com.lucas.aluracurso.domain.medico;

import com.lucas.aluracurso.application.medico.MedicoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository repository;

    public Medico getOne(UUID id) {
        return repository.getReferenceById(id);
    }

    public Medico save(Medico medico) {
        return repository.save(medico);
    }

    public Medico findByUUID(UUID uuid) {
        return repository.findByUUID(uuid);
    }

    public List<MedicoDTO> findAll(String orderBy, Integer page, Integer pageSize){
        return repository.listAll(orderBy, page, pageSize);
    }

}
