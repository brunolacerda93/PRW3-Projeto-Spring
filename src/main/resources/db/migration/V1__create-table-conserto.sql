create table conserto(
    id bigint not null auto_increment,
    data_entrada varchar(100) not null,
    data_saida varchar(100),

    nome varchar(100),
    anos_de_experiencia varchar(10),

    marca varchar(50),
    modelo varchar(50),
    ano varchar(10),

    primary key(id)
);
