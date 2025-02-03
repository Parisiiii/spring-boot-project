package com.lucas.aluracurso.domain.endereco;

import com.lucas.aluracurso.application.endereco.EnderecoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository repository;

    public Endereco getOne(UUID id) {
        return repository.getReferenceById(id);
    }

    public Endereco save(Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco findByUUID(UUID uuid) {
        return repository.findByUUID(uuid);
    }

    public List<EnderecoDTO> findAll(String orderBy, Integer page, Integer pageSize) {
        return repository.listAll(orderBy, page, pageSize);
    }
}
