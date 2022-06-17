

-- Tabla: ROL

INSERT INTO dbo.ROL VALUES
(1,'Administrador'),
(2,'Vendedor'),
(3,'Cajera');
GO

-- Tabla: EMPLEADO

INSERT INTO dbo.EMPLEADO(idempleado,nombre,apellido,dni,telefono,correo,idrol,usuario,clave)
VALUES
(1,'Pedro','Castro','54679823','956349854','pcastro@algo.com',1,'pcastro','cazador'),
(2,'Alex','Foster','76764235','986148577','afoster@algo.com',2,'afoster','waste'),
(3, 'Damian', 'Zuniga', '08729444', '958998412', 'dzuniga@cmail.com',3, 'dzuniga', 'mochila123'),
(4,'Jose','Martinez','98561234','945986421','jmartinez@algo.com',2,'jmartinez','123456'),
(5, 'Mariana', 'Chávez', '10741748', '952780294', 'marianach@gmail.com',3, 'mchavez', 'dist2004');
GO

SELECT * FROM EMPLEADO;
GO

