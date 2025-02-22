package com.lucas.aluracurso.domain.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID>, EnderecoRepositoryCustom {
}
