create table personagens (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    pontosVida smallint unsigned,
    nivel tinyint,
    classeArmdura tinyint,

    forca tinyint,
    destreza tinyint,
    constituicao tinyint,
    inteligencia tinyint,
    sabedoria tinyint,
    carisma tinyint,

    raca varchar(50),

    primary key(id)

);