/*
Requerimiento:

Desarrollar una consulta para encontrar la planilla de profesores de un determinado ciclo.
Base de datos: EDUTEC

*/

/*
1. Analizar cada requerimiento.

EDUTEC programa 12 ciclos por año, quiere decir que es un ciclo por mes.

En cada ciclo se programan los inicios los cursos, pudiendose crear 
de un curso varios inicios en un mes, estos quie decir que de un curso
se pueden programar varias secciones por ciclo, en diferentes horacios 
o en paralelo.

Cada curso tiene un tiempo de duración, normalmente es 24 horas de duración 
por curso programado, y ademas, el pago por hora al profesor depende del 
tipo de curso, en los curso avanzados el pago es mayor.

En primer lugar, es necesario conocer los cursos de cada profesor,
y la cantidad programaciones que tiene por ciclo.
*/

select * from edutec..CursoProgramado;
go

select * from edutec..Curso;
go

select * from EduTec..Tarifa;
go

select * from edutec..Ciclo
where IdCiclo like '2021%';
go

/*
2. Identificar los datos que debe tener el reporte.

Columnas
- NOMBRE DEL PROFESOR 
- AULAS PROGRAMADAS 
- HORAS DICTADAS 
- IMPORTE
*/


/*
3. Identificar las tablas de donde obtendrá los datos.

     Columna                     Tabla
--------------------------------------------------------------------
- NOMBRE DEL PROFESOR            Profesor
- AULAS PROGRAMADAS              CursoProgramado
- HORAS DICTADAS                 CursoProgramado
- IMPORTE                        CursoProgramado y Tarifa
*/

/*
4. Elaborar la consulta.
*/

-- Paso 1: Consulta base

select IdProfesor, IdCurso
from edutec..CursoProgramado
where IdCiclo = '2021-01';
go

-- Paso 2: Pago por aula al profesor

with
v1 as (
	select IdProfesor, IdCurso
	from edutec..CursoProgramado
	where IdCiclo = '2021-01'
)
select 
	v1.IdProfesor, v1.IdCurso, t.Horas, t.Horas*t.PagoHora total
from EduTec..Tarifa t
join EduTec..Curso c on t.IdTarifa=c.IdTarifa
join v1 on c.IdCurso = v1.IdCurso;
go

-- Paso 3: sumarizar

with
v1 as (
	select IdProfesor, IdCurso
	from edutec..CursoProgramado
	where IdCiclo = '2021-01'
),
v2 as (
	select 
		v1.IdProfesor, v1.IdCurso, t.Horas, t.Horas*PagoHora total
	from EduTec..Tarifa t
	join EduTec..Curso c on t.IdTarifa=c.IdTarifa
	join v1 on c.IdCurso = v1.IdCurso
)
select IdProfesor, count(1) aulas, sum(Horas) horas, sum(total) importe 
from v2
group by IdProfesor
order by 1
go

-- Paso 4: Agregar nombre del profesor


with
v1 as (
	select IdProfesor, IdCurso
	from edutec..CursoProgramado
	where IdCiclo = '2021-01'
),
v2 as (
	select 
		v1.IdProfesor, v1.IdCurso, t.Horas, t.Horas*t.PagoHora total
	from EduTec..Tarifa t
	join EduTec..Curso c on t.IdTarifa=c.IdTarifa
	join v1 on c.IdCurso = v1.IdCurso
),
v3 as (
	select IdProfesor, count(1) aulas, sum(Horas) horas, sum(total) importe 
	from v2
	group by IdProfesor
)
select p.NomProfesor, v3.aulas, v3.horas, v3.importe
from edutec..Profesor p 
join v3 on p.IdProfesor = v3.IdProfesor
order by 1
go



/*
5. Verificar su resultado
*/

select 
	cp.IdProfesor, count(1) aulas,
	sum(t.Horas) horas,
	sum(t.Horas*t.PagoHora) importe
from EduTec..CursoProgramado cp
join edutec..Curso c on cp.IdCurso = c.IdCurso
join edutec..Tarifa t on c.IdTarifa = t.IdTarifa
where cp.IdCiclo = '2021-01'
group by cp.IdProfesor
order by 1;
go