-- Table Value Constructor
-- Fuente: https://www.mytecbits.com/microsoft/sql-server/getting-max-of-multiple-columns


CREATE TABLE NOTAS(
	ESTUDIANTE VARCHAR(20),
	NOTA1 INT,
	NOTA2 INT,
	NOTA3 INT,
	NOTA4 INT
);
GO

INSERT INTO NOTAS VALUES
('GUSTAVO',12,16,18,15),
('ANGEL',18,13,17,10),
('JUAN',19,08,11,11),
('MIA',10,13,17,14),
('OSCAR',15,19,16,14);
GO

select * from (VALUES
('GUSTAVO',12,16,18,15),
('ANGEL',18,13,17,10),
('JUAN',19,08,11,11),
('MIA',10,13,17,14),
('OSCAR',15,19,16,14)) as t(a,b,c,d,e);


SELECT N.*,
PROMEDIO = (NOTA1 + NOTA2 + NOTA3 + NOTA4 - 
(SELECT min(nota) from (values (nota1),(nota2),(nota2),(nota4)) as x(nota))) / 3
FROM NOTAS N;
GO





