/*
REQUERIMIENTO

Se necesita una consulta para conocer el importe de la planilla por departamento.
Base de datos: RH

Columnas:
- NOMBRE DEPARTAMENTO 
- CANTIDAD DE EMPLEADOS 
- IMPORTE 
- COMISION 
- TOTAL

*/

/*
1. Analizar cada requerimiento.

En la empresa se tienes varios departamentos, en cada departamento
trabajan varias personas, y cada una de ellas tiene un cargo.

Existe un costo por departamento correspondiente al sueldo de 
cada trabajador, a este costo se le llama "LA PLANILLA DEL DEPARTAMENTO",
en otras palabras, es la suma de todos ingresos que tienen lo 
trabajadores de un departamento.

*/

/*
2. Identificar los datos que debe tener el reporte.

Columnas:
- NOMBRE DEPARTAMENTO 
- CANTIDAD DE EMPLEADOS 
- IMPORTE 
- COMISION 
- TOTAL

*/


/*
3. Identificar las tablas de donde obtendrá los datos.

  Columnas del Reporte            Tablas de la base de datos
--------------------------------------------------------------------------
- NOMBRE DEPARTAMENTO             Departamento
- CANTIDAD DE EMPLEADOS           Empleados
- IMPORTE                         Empleados
- COMISION                        Empleados
- TOTAL                           Empleados
*/

/*
4. Elaborar la consulta.
*/

-- Paso 1: Consulta base sobre la tabla empleado.

select 
	iddepartamento, count(1) empleados, sum(sueldo) importe, sum(isnull(comision,0)) comision
from RH..empleado 
group by iddepartamento;
go

-- Paso 2: Agrgar la columna total

with 
v1 as (
select 
	iddepartamento, count(1) empleados, sum(sueldo) importe, sum(isnull(comision,0)) comision
	from RH..empleado 
	group by iddepartamento
)
select iddepartamento, empleados, importe, comision, (importe+comision) total
from v1;
go

-- Paso 3: Agregar la columnas "Nombre departamento"

with 
v1 as (
select 
	iddepartamento, count(1) empleados, sum(sueldo) importe, sum(isnull(comision,0)) comision
	from RH..empleado 
	group by iddepartamento
),
v2 as (
	select iddepartamento, empleados, importe, comision, (importe+comision) total
	from v1
)
select 
	d.nombre departamento, v2.empleados, v2.importe, v2.comision, v2.total
from rh..departamento d
join v2 on d.iddepartamento = v2.iddepartamento;
go

/*
5. Verificar su resultado
*/


select count(idempleado), sum(sueldo), sum(comision)
from rh..empleado;