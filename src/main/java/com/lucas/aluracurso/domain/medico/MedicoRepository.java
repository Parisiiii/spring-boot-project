package com.lucas.aluracurso.domain.medico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID>, MedicoRepositoryCustom {
}
