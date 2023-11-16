sql
CREATE TABLE Prato (
    id INTEGER IDENTITY PRIMARY KEY,
    nome VARCHAR(255),
    tipo VARCHAR(100),
    ingredientes VARCHAR(1000)
);
