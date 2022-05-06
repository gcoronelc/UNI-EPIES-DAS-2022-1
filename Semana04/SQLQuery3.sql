

select getdate()+90;
go

select DATEPART(qq,getdate()+90) trimestre;
go

select DATEPART(qq,OrderDate) trimestre, count(OrderID) ventas
from Northwind..Orders
where YEAR(OrderDate)=1997
group by DATEPART(qq,OrderDate);
go

select *
from Northwind..Orders o
join Northwind..[Order Details] d on o.OrderID=d.OrderID
order by 1;
go


select 
	o.ShipCountry, 
	count(distinct o.OrderID) Pedidos,
	sum(d.Quantity) Cantidad,
	sum(d.Quantity*d.UnitPrice) Importe
from Northwind..Orders o
join Northwind..[Order Details] d on o.OrderID=d.OrderID
group by o.ShipCountry
order by 1;
go


