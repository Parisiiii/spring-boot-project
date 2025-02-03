package com.lucas.aluracurso.domain.endereco;

import com.lucas.aluracurso.application.endereco.EnderecoDTO;
import com.lucas.aluracurso.domain.medico.Medico;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
    @Column(nullable = false)
    private String logradouro;
    private BigDecimal numero;
    private String complemento;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private BigDecimal cep;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String uf;

    @OneToOne
    private Medico medico;

    private Endereco(EnderecoDTO dto, Medico medico) {
        this.bairro = dto.bairro();
        this.logradouro = dto.logradouro();
        this.numero = dto.numero();
        this.complemento = dto.complemento();
        this.cep = dto.cep();
        this.cidade = dto.cidade();
        this.uf = dto.uf();
        this.id = dto.id();
        this.medico = medico;
    }

    public Endereco() {
    }

    public static Endereco of(EnderecoDTO dto, Medico medico) {
        return new Endereco(dto, medico);
    }
}
