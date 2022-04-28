/*
GRUPO: 10
INTEGRANTES:
- Gustavo Coronel
- Martin Fernando Vargas Chambi 
- Joel Rios Nima 
- ANGEL ROGER LAGOS ÑAÑA
*/


/*
Requerimiento 6
Desarrolle una VISTA PARA encontrar el empleado que tiene el menor salario por departamento.
Base de datos RH
*/

/*
1. Analizar cada requerimiento.

Todo empleado es asignado a un departamento, pero también tiene un rol (cargo)
el que determina su salario (sueldo), el sueldo del empleado también se determina 
por los años de experiencia, es así que dos o mas empleados con el mismo rol
pueden tener diferentes sueldos.
*/

/*
2. Identificar los datos que debe tener el reporte.

- CODIGO DEPARTAMENTO
- NOMBRE DEPARTAMENTO
- CODIGO EMPLEADO
- NOMBRE EMPLEADO
- SALARIO

*/


/*
3. Identificar las tablas de donde obtendrá los datos.

- CODIGO DEPARTAMENTO: Departamento
- NOMBRE DEPARTAMENTO: Departamento
- CODIGO EMPLEADO: Empleado
- NOMBRE EMPLEADO: Empleado
- SALARIO: Empleado
*/

/*
4. Crear la vista en la base de datos.
*/

-- 1: Datos principales

select * from rh..empleado;
go

-- 2: Salario minimo por departamento

select iddepartamento, min(sueldo) sueldo_minimo 
from rh..empleado
group by iddepartamento
go

-- 3: Encontrar el empleado(s) al que le pertenece el salario minimo

with
v1 as (
	select iddepartamento, min(sueldo) sueldo_minimo 
	from rh..empleado
	group by iddepartamento
)
select e.idempleado, e.nombre, e.apellido, e.iddepartamento, e.sueldo
from empleado e
join v1 on e.iddepartamento=v1.iddepartamento and e.sueldo=v1.sueldo_minimo;
go

-- 4: Completar los datos y crear la vista

create view V_REQ06
as
with
v1 as (
	select iddepartamento, min(sueldo) sueldo_minimo 
	from rh..empleado
	group by iddepartamento
),
v2 as (
	select e.idempleado, e.nombre, e.apellido, e.iddepartamento, e.sueldo
	from empleado e
	join v1 on e.iddepartamento=v1.iddepartamento and e.sueldo=v1.sueldo_minimo
)
select 
	d.iddepartamento, d.nombre, v2.idempleado, 
	concat(v2.nombre,', ',v2.apellido) nombre_empleado, v2.sueldo
from departamento d
join v2 on d.iddepartamento = v2.iddepartamento
go

-- 5: Consultar la vista

select * from rh..V_REQ06;
go

/*
5. Verificar su resultado.
*/

select * from rh..V_REQ06;
go

