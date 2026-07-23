ALTER TABLE Personagens
ADD COLUMN mesa_id BIGINT;

ALTER TABLE Personagens
ADD CONSTRAINT fk_personagem_mesa
FOREIGN KEY (mesa_id) REFERENCES Mesas(id);