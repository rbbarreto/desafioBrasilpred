DROP TABLE IF EXISTS clientes;

CREATE TABLE clientes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  endereco VARCHAR(250) NOT NULL,
  cpf VARCHAR(12) DEFAULT NULL
);

INSERT INTO clientes (id, nome, endereco, cpf) VALUES
  (1, 'Dangote', 'rua professor ', '123456789'),
  (2, 'Gates', 'rua carvalheiras', '456789123'),
  (3, 'Alakija', 'rua 7 de abril', '789456159');