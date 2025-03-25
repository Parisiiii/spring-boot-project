package com.lucas.domain.enums;

import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum Status {

    ATIVO("ATIVO", "A"),
    INATIVO("INATIVO", "I");

    private String descricao;
    private String codigo;

    private static final Map<String, Status> VALUE_MAP =
            Stream.of(values()).collect(Collectors.toMap(s -> s.codigo, s -> s));

    Status(String descricao, String codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public static Status of(String codigo) {
        return VALUE_MAP.get(codigo);
    }
}
