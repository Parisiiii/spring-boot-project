package com.lucas.aluracurso.domain.medico;

import com.lucas.aluracurso.application.endereco.EnderecoDTO;
import com.lucas.aluracurso.application.medico.MedicoDTO;
import com.lucas.aluracurso.domain.endereco.Endereco;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MedicoRepositoryImpl implements MedicoRepositoryCustom {
    private final EntityManager entityManager;

    public MedicoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Medico findByUUID(UUID medicoUUID) {
        String query = """
                SELECT * FROM medico WHERE medico.id = :medicoUUID
                """;

        return (Medico) entityManager
                .createNativeQuery(query)
                .setParameter("medicoUUID", medicoUUID)
                .getSingleResult();
    }

    @Override
    public List<MedicoDTO> listAll(String orderBy, Integer page, Integer pageSize) {
        String query = """
                SELECT id,
                       nome,
                       telefone,
                       email,
                       CRM,
                       especialidade
                FROM medico
                ORDER BY :orderby
                LIMIT :page, :pageSize
                """;

        List<Object[]> result = entityManager
                .createNativeQuery(query)
                .setParameter("orderby", orderBy)
                .setParameter("page", page)
                .setParameter("pageSize", pageSize)
                .getResultList();

        List<MedicoDTO> toReturn = new ArrayList<>();
        for (Object[] row : result) {
            String id = (String) row[0];
            String nome = (String) row[1];
            String telefone = (String) row[2];
            String email = (String) row[3];
            String crm = (String) row[4];
            String especialidade = (String) row[5];
            toReturn.add(new MedicoDTO(UUID.fromString(id), nome, telefone, email, crm, especialidade));
        }

        return toReturn;
    }
}
