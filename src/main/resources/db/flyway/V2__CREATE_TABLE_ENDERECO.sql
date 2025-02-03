CREATE TABLE endereco
(
    id          varchar(36)  not null primary key,
    logradouro  varchar(255) not null,
    numero      int(10),
    complemento varchar(255),
    bairro      varchar(255) not null,
    cep         int(8)       not null,
    cidade      varchar(255) not null,
    uf          varchar(2)   not null,
    medico_fk   varchar(36)  not null
);

alter table endereco
    add foreign key (medico_fk) references medico (id);
