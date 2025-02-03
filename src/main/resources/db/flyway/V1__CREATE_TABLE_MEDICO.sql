CREATE TABLE medico
(
    ID            VARCHAR(36) PRIMARY KEY NOT NULL,
    NOME          VARCHAR(255)            NOT NULL,
    TELEFONE      VARCHAR(255)            NOT NULL,
    EMAIL         VARCHAR(255)            NOT NULL,
    CRM           VARCHAR(255)            NOT NULL,
    ESPECIALIDADE VARCHAR(255)            NOT NULL,
    logradouro    varchar(255)            not null,
    numero        int(10),
    complemento   varchar(255),
    bairro        varchar(255)            not null,
    cep           int(8)                  not null,
    cidade        varchar(255)            not null,
    uf            varchar(2)              not null
);

CREATE UNIQUE INDEX UK_MEDICO ON medico (nome);

