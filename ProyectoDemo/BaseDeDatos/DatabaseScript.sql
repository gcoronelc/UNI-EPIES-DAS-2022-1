
DROP TABLE dbo.EMPLEADO
go



DROP TABLE dbo.ROL
go



CREATE TABLE dbo.ROL
( 
	IDROL                integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	CONSTRAINT XPKROL PRIMARY KEY (IDROL ASC)
)
go



CREATE TABLE dbo.EMPLEADO
( 
	IDEMPLEADO           integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	APELLIDO             varchar(100)  NOT NULL ,
	DNI                  varchar(20)  NOT NULL ,
	TELEFONO             varchar(20)  NOT NULL ,
	CORREO               varchar(100)  NOT NULL ,
	IDROL                integer  NOT NULL ,
	USUARIO              varchar(20)  NOT NULL ,
	CLAVE                varchar(20)  NOT NULL ,
	CONSTRAINT XPKEMPLEADO PRIMARY KEY (IDEMPLEADO ASC),
	CONSTRAINT FK_EMPLEADO_ROL FOREIGN KEY (IDROL) REFERENCES dbo.ROL(IDROL)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go



CREATE UNIQUE INDEX U_EMPLEADO_USUARIO ON dbo.EMPLEADO
( 
	USUARIO               ASC
)
go


