package com.lucas.aluracurso.domain.medico;

import com.lucas.aluracurso.application.medico.MedicoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository repository;

    public Medico getOne(UUID id) {
        if(id == null) return null;
        return repository.getReferenceById(id);
    }

    public Medico save(Medico medico) {
        return repository.save(medico);
    }

    public void delete(Medico medico) {
        repository.delete(medico);
    }

    public List<MedicoDTO> findAll(Pageable pageable) {
        return repository.findAllByStatus(pageable).stream().map(MedicoDTO::of).collect(Collectors.toList());
    }

}
