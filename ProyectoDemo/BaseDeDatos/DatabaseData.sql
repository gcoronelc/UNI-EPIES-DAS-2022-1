

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
(5, 'Mariana', 'Ch�vez', '10741748', '952780294', 'marianach@gmail.com',3, 'mchavez', 'dist2004');
GO

SELECT * FROM EMPLEADO;
GO

-- Tabla: CIUDAD

SET IDENTITY_INSERT dbo.CIUDAD ON  
GO

INSERT INTO dbo.CIUDAD(IDCIUDAD,NOMBRE,DISTANCIA,TIEMPO_VIAJE) VALUES(1,'LIMA',0,0);
INSERT INTO dbo.CIUDAD(IDCIUDAD,NOMBRE,DISTANCIA,TIEMPO_VIAJE) VALUES(2,'HUACHO',30,3);
INSERT INTO dbo.CIUDAD(IDCIUDAD,NOMBRE,DISTANCIA,TIEMPO_VIAJE) VALUES(3,'BARRANCA',40,4);
INSERT INTO dbo.CIUDAD(IDCIUDAD,NOMBRE,DISTANCIA,TIEMPO_VIAJE) VALUES(4,'CHIMBOTE',50,5);
INSERT INTO dbo.CIUDAD(IDCIUDAD,NOMBRE,DISTANCIA,TIEMPO_VIAJE) VALUES(5,'TRUJILLO',60,6);
INSERT INTO dbo.CIUDAD(IDCIUDAD,NOMBRE,DISTANCIA,TIEMPO_VIAJE) VALUES(6,'CHICLAYO',70,7);
INSERT INTO dbo.CIUDAD(IDCIUDAD,NOMBRE,DISTANCIA,TIEMPO_VIAJE) VALUES(7,'PIURA',80,8);
INSERT INTO dbo.CIUDAD(IDCIUDAD,NOMBRE,DISTANCIA,TIEMPO_VIAJE) VALUES(8,'TUMBES',90,9);
INSERT INTO dbo.CIUDAD(IDCIUDAD,NOMBRE,DISTANCIA,TIEMPO_VIAJE) VALUES(9,'MALA',50,5);
GO

SET IDENTITY_INSERT dbo.CIUDAD OFF 
GO

SELECT * FROM dbo.CIUDAD;
GO


-- Tabla: RUTA

SET IDENTITY_INSERT dbo.RUTA ON 
GO

INSERT INTO dbo.RUTA(IDRUTA,NOMBRE,ORIGEN,DESTINO,PISO1PRECIO1,PISO1PRECIO2,PISO2PRECIO1,PISO2PRECIO2,IDEMPLEADO)
VALUES(1,'LIMA-CHICLAYO',1,6,120,140,150,170,1);
INSERT INTO dbo.RUTA(IDRUTA,NOMBRE,ORIGEN,DESTINO,PISO1PRECIO1,PISO1PRECIO2,PISO2PRECIO1,PISO2PRECIO2,IDEMPLEADO)
VALUES(2,'LIMA-TRUJILLO',1,5,110,130,140,160,1);
GO

SET IDENTITY_INSERT dbo.RUTA OFF 
GO

