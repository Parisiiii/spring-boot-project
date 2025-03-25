package com.lucas.domain.medico;


import com.lucas.application.medico.MedicoDTO;
import com.lucas.domain.converters.StatusAttributeConverter;
import com.lucas.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;


@Data
@Entity
@Table(name = "medico")
@NoArgsConstructor
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

    @Column(nullable = false)
    private String logradouro;

    private Integer numero;

    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private Integer cep;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String uf;

    @Convert(converter = StatusAttributeConverter.class)
    @Column(nullable = false)
    private Status status = Status.ATIVO;

    private Medico(MedicoDTO dto) {
        setValues(dto);
    }

    public Medico setValues(MedicoDTO dto) {
        this.nome = dto.nome() != null ? dto.nome().toUpperCase() : null;
        this.telefone = dto.telefone() != null ? dto.telefone() : null;
        this.email = dto.email() != null ? dto.email() : null;
        this.CRM = dto.CRM() != null ? dto.CRM() : null;
        this.especialidade = dto.especialidade() != null ? dto.especialidade().toUpperCase() : null;
        this.status = Status.of(dto.status()) != null ? Status.of(dto.status()) : null;
        if(dto.endereco() != null) {
            this.complemento = dto.endereco().complemento() != null ? dto.endereco().complemento().toUpperCase() : null;
            this.bairro = dto.endereco().bairro() != null ? dto.endereco().bairro().toUpperCase() : null;
            this.cep = dto.endereco().cep() != null ? dto.endereco().cep() : null;
            this.cidade = dto.endereco().cidade() != null ? dto.endereco().cidade().toUpperCase() : null;
            this.uf = dto.endereco().uf() != null ? dto.endereco().uf().toUpperCase() : null;
            this.numero = dto.endereco().numero() != null ? dto.endereco().numero() : null;
            this.logradouro = dto.endereco().logradouro() != null ? dto.endereco().logradouro().toUpperCase() : null;
        }
        return this;
    }

    public static Medico of(MedicoDTO dto) {
        return new Medico(dto);
    }

    public void ativarInativar(){
        this.status = this.status.equals(Status.ATIVO) ? Status.INATIVO : Status.ATIVO;
    }

    public void inativar(){
        this.status = Status.INATIVO;
    }
}
