package com.lucas.aluracurso.domain.medico;

import com.lucas.aluracurso.application.medico.MedicoDTO;
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
    public List<MedicoDTO> listAll(String orderBy, Integer page, Integer pageSize) {
        String query = """
                SELECT id,
                       nome,
                       telefone,
                       email,
                       CRM,
                       especialidade,
                       logradouro,
                       complemento,
                       numero,
                       cep,
                       cidade,
                       uf,
                       bairro
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
            String logradouro = (String) row[6];
            String complemento = (String) row[7];
            Integer numero = (Integer) row[8];
            Integer cep = (Integer) row[9];
            String cidade = (String) row[10];
            String uf = (String) row[11];
            String bairro = (String) row[12];
            toReturn.add(new MedicoDTO(UUID.fromString(id), nome, telefone, email, crm, especialidade, logradouro, numero, complemento, bairro, cep, cidade, uf));
        }

        return toReturn;
    }
}
