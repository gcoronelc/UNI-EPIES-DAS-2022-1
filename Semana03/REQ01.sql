/*
GRUPO: 10
INTEGRANTES:
- Gustavo Coronel
- Martin Fernando Vargas Chambi 
- Joel Rios Nima 
- ANGEL ROGER LAGOS ÑAÑA
*/

/*
Desarrolle una VISTA para encontrar los departamentos que tienen más de 5 trabajadores.
Base de datos RH.
*/


/*
1. Analizar cada requerimiento.

En la empresa hay trabajadores, muchos trabajadores, pero cada trabajador
esta asignado a un departamento. Es así que, a un departamento se pueden
asignar 2 trabajadores, 10 trabajadores o muchos mas trabajadores, depende
de la necesidad de cada departamento.

*/

/*
2. Identificar los datos que debe tener el reporte.

- CODIGO DEL DEPARTAMENTO
- NOMBRE DEL DEPARTAMENTO
- CANTIDAD DE TRABAJADORES

*/

/*
3. Identificar las tablas de donde obtendrá los datos.

- CODIGO DEL DEPARTAMENTO: Departamento
- NOMBRE DEL DEPARTAMENTO: Departamento
- CANTIDAD DE TRABAJADORES: Empleado

*/

/*
4. Crear la vista en la base de datos.
*/

-- 1: Datos principales

select * from RH..empleado;
go

-- 2: Contar los empleados por departamento

select iddepartamento, count(1) empleados
from RH..empleado
group by iddepartamento;
go

-- 3: Filtrar los departamento con mas de 5 empleados

select iddepartamento, count(1) empleados
from RH..empleado
group by iddepartamento
having count(1) > 5;
go

-- 4: Completar los datos y crear la vista

create view V_REQ01
as
with 
v1 as (
	select iddepartamento, count(1) empleados
	from RH..empleado
	group by iddepartamento
	having count(1) > 5
)
select d.iddepartamento, d.nombre, v1.empleados
from RH..departamento d
join v1 on d.iddepartamento = v1.iddepartamento;
go

-- 5: Verificar la vista

select * from rh..V_REQ01;
go


/*
5. Verificar su resultado.

Se debe crear una consulta para verificar el resultado.

*/


select * from rh..V_REQ01;
go

select iddepartamento, count(1) empleados
from RH..empleado
group by iddepartamento;
go