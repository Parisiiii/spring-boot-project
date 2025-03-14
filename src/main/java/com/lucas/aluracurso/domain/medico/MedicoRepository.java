package com.lucas.aluracurso.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {
    @Query("SELECT m FROM Medico m where m.status='A'")
    Page<Medico> findAllByStatus(Pageable pageable);
}
