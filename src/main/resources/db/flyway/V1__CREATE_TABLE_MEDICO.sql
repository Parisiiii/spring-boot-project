CREATE TABLE medico
(
    ID            VARCHAR(36) PRIMARY KEY NOT NULL,
    NOME          VARCHAR(255)            NOT NULL,
    TELEFONE      VARCHAR(255)            NOT NULL,
    EMAIL         VARCHAR(255)            NOT NULL,
    CRM           VARCHAR(255)            NOT NULL,
    ESPECIALIDADE VARCHAR(255)            NOT NULL
);

CREATE UNIQUE INDEX UK_MEDICO ON medico (nome);

