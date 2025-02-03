package com.lucas.aluracurso.domain.endereco;

import com.lucas.aluracurso.application.endereco.EnderecoDTO;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EnderecoRepositoryImpl implements EnderecoRepositoryCustom {
    private final EntityManager entityManager;

    public EnderecoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Endereco findByUUID(UUID enderecoUUID) {
        String query = """
                SELECT * FROM endereco WHERE endereco.id = :enderecoUUID
                """;

        return (Endereco) entityManager
                .createNativeQuery(query)
                .setParameter("enderecoUUID", enderecoUUID)
                .getSingleResult();
    }

    @Override
    public List<EnderecoDTO> listAll(String orderBy, Integer page, Integer pageSize) {
        String query = """
                SELECT id,
                       bairro,
                       cep,
                       cidade,
                       complemento,
                       logradouro,
                       numero,
                       uf,
                       (select id from medico where medico.id = endereco.medico_fk)
                FROM endereco
                ORDER BY :orderby
                LIMIT :page, :pageSize
                """;

        List<Object[]> result = entityManager
                .createNativeQuery(query)
                .setParameter("orderby", orderBy)
                .setParameter("page", page)
                .setParameter("pageSize", pageSize)
                .getResultList();

        List<EnderecoDTO> toReturn = new ArrayList<>();
        for (Object[] row : result) {
            String id = (String) row[0];
            String bairro = (String) row[1];
            Integer cep = (Integer) row[2];
            String cidade = (String) row[3];
            String complemento = (String) row[4];
            String logradouro = (String) row[5];
            Integer numero = (Integer) row[6];
            String uf = (String) row[7];
            String medicoId = (String) row[8];

            toReturn.add(new EnderecoDTO(UUID.fromString(id), logradouro, BigDecimal.valueOf(numero), complemento, bairro, BigDecimal.valueOf(cep), cidade, uf, UUID.fromString(medicoId)));
        }

        return toReturn;
    }
}
