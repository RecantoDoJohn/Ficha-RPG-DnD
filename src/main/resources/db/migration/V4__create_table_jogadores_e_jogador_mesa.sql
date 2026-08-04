CREATE TABLE jogadores (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE jogador_mesa (
    jogador_id BIGINT NOT NULL,
    mesa_id BIGINT NOT NULL,

    PRIMARY KEY (jogador_id, mesa_id),

    CONSTRAINT fk_jogador_mesa_jogador
        FOREIGN KEY (jogador_id)
        REFERENCES jogadores(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_jogador_mesa_mesa
        FOREIGN KEY (mesa_id)
        REFERENCES mesas(id)
        ON DELETE CASCADE
);