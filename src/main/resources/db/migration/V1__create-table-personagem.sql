CREATE TABLE personagens (
    id BIGSERIAL PRIMARY KEY,

    nome VARCHAR(255) NOT NULL,
    pontos_vida INTEGER NOT NULL,
    nivel INTEGER NOT NULL,
    classe_armdura INTEGER NOT NULL,
    forca INTEGER NOT NULL,
    destreza INTEGER NOT NULL,
    constituicao INTEGER NOT NULL,
    inteligencia INTEGER NOT NULL,
    sabedoria INTEGER NOT NULL,
    carisma INTEGER NOT NULL,
    raca VARCHAR(100) NOT NULL,

    ativo BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);