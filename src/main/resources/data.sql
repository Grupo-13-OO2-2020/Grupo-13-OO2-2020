
USE `db_ejemplo`;

insert into local values (1,"Murature",50.0218, 79.5265,11112222);
insert into local values (2,"Mentruyt",-49.4505, 153.2949,22223333);
insert into local values (3,"Boedo",-50.0955, 147.9932,33334444);
insert into local values (4,"Laprida",25.5277, 30.8653,44445555);

insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Martinez", 222222,'2000-11-05',"Marcos");
insert into empleado values ( 0,'12:00:00','20:00:00', 25000, "Vendedor",1,1);
insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Lopez", 44444,'1998-10-11',"Martin");
insert into empleado  values ( 0,'12:00:00','20:00:00', 15000, "Vendedor",2,2);
insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Gonzalez", 11111,'1997-12-06',"Joaquin");
insert into empleado  values ( 0,'12:00:00','20:00:00', 18000, "Encargado",3,3);
insert into persona( apellido, dni, fecha_nacimiento, nombre) values  ("Garcia", 333333,'1996-11-08',"Jesus");
insert into empleado values ( 0,'12:00:00','20:00:00', 15000, "Repositor",4,4);

insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Aguirre", 88888,'2000-11-05',"Franco");
insert into cliente (cuil, cuit, email, numero, id) values (111111111111,111111111111, "franco@mail", 155845095,5);
insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Lopez", 44444,'1998-10-11',"Martin");
insert into cliente (cuil, cuit, email, numero, id) values (222222222222,222222222222, "Martin@mail", 155845095,6);
insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Gonzalez", 11112,'1997-12-06',"Esteban");
insert into cliente (cuil, cuit, email, numero, id) values (333333333333,333333333333, "Esteban@mail", 155845095,7);
insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Espinoza", 333331,'1996-11-08',"Juan");
insert into cliente (cuil, cuit, email, numero, id) values (444444444444,444444444444, "Juan@mail", 155845095,8);


insert into producto(descripcion,precio_unitario,codigo_producto,talle) values ("Remera",200,7791,38);
insert into producto(descripcion,precio_unitario,codigo_producto,talle) values ("Pantalon",400,7792,38);
insert into producto(descripcion,precio_unitario,codigo_producto,talle) values ("Zapatilla",600,7793,42);
insert into producto(descripcion,precio_unitario,codigo_producto,talle) values ("Ojotas",150,7794,40);