package com.lucas.aluracurso.domain.medico;


import com.lucas.aluracurso.application.medico.MedicoDTO;
import com.lucas.aluracurso.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;


@Data
@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String CRM;
    @Column(nullable = false)
    private String especialidade;


    protected Medico(MedicoDTO dto) {
        this.especialidade = dto.especialidade();
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
        this.CRM = dto.CRM();
    }

    public Medico() {
    }

    public static Medico of(MedicoDTO dto) {
        return new Medico(dto);
    }
}
