/*
GRUPO: 10
INTEGRANTES:
- Gustavo Coronel
- Martin Fernando Vargas Chambi 
- Joel Rios Nima 
- ANGEL ROGER LAGOS ÑAÑA
*/


/*
Requerimiento 7
Calcular los ingresos por mes de un determinado año, por curso.
Base de datos: EDUTEC
*/

/*
1. Analizar cada requerimiento.

En EDUTEC cada ciclo corresponde a un mes, en total se tienen 12
ciclo por que el año tiene 12 meses.
En cada ciclo se programan varios cursos, incluso el mismo curso
se puede programar varias veces en ciclo en diferentes horarios
incluso con diferentes profesores.
*/

/*
2. Identificar los datos que debe tener el reporte.

- NOMBRE DEL CURSO
- INGRESOS DE ENERO
- INGRESOS DE FEBRERO
- ...
-- INGRESOS TOTALES

*/
/*
3. Identificar las tablas de donde obtendrá los datos.

- NOMBRE DEL CURSO: Curso
- INGRESOS DE ENERO: CursoProgramado
- INGRESOS DE FEBRERO: CursoProgramado
- ...
-- INGRESOS TOTALES: CursoProgramado

*/

/*
4. Crear la vista en la base de datos.
*/

-- 1: Datos principales

select * from edutec..CursoProgramado;
go

-- 2: Calcular los ingresos por mes de cada curso del ciclo 2021-01

select IdCiclo, SUBSTRING(IdCiclo,6,2) from edutec..CursoProgramado;
go

select IdCurso, SUBSTRING(IdCiclo,6,2) mes, PreCursoProg*Matriculados ingresos
from edutec..CursoProgramado
where IdCiclo like '2021%' and Activo=1
go

-- 3: Completar la consulta

create view V_REQ07
as
with 
v1 as (
	select IdCurso, SUBSTRING(IdCiclo,6,2) mes, PreCursoProg*Matriculados ingresos
	from edutec..CursoProgramado
	where IdCiclo like '2021%' and Activo=1
)
select 
	c.NomCurso,
	sum(case v1.mes when '01' then v1.ingresos else 0 end) Enero,
	sum(case v1.mes when '02' then v1.ingresos else 0 end) Febrero,
	sum(case v1.mes when '03' then v1.ingresos else 0 end) Marzo,
	sum(case v1.mes when '04' then v1.ingresos else 0 end) Abril,
	sum(case v1.mes when '05' then v1.ingresos else 0 end) Mayo,
	sum(case v1.mes when '06' then v1.ingresos else 0 end) Junio,
	sum(case v1.mes when '07' then v1.ingresos else 0 end) Julio,
	sum(case v1.mes when '08' then v1.ingresos else 0 end) Agosto,
	sum(case v1.mes when '09' then v1.ingresos else 0 end) Setiembre,
	sum(case v1.mes when '10' then v1.ingresos else 0 end) Octubre,
	sum(case v1.mes when '11' then v1.ingresos else 0 end) Noviembre,
	sum(case v1.mes when '12' then v1.ingresos else 0 end) Diciembre,
	sum(v1.ingresos) total
from edutec..Curso c
join v1 on c.IdCurso = v1.IdCurso
group by c.NomCurso
go


select * from edutec..V_REQ07;
go

/*
5. Verificar su resultado.

*/




