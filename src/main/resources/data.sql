USE `Grupo_13_BDD_OO2_2020`;


-- insert into local  ( id,direccion, latitud, longitud, numero_telefono) values (1,"Avellaneda",-34.6601800,-58.3674400,33334444);
-- insert into local ( id,direccion, latitud, longitud, numero_telefono) values (2,"Lanus",-34.7025200,-58.3955000,55556666);
-- insert into local ( id,direccion, latitud, longitud, numero_telefono) values (3,"Murature",50.0218, 79.5265,11112222);
-- insert into local ( id,direccion, latitud, longitud, numero_telefono) values (4,"Laprida",-34.7608800,-58.4063200,44445555);

-- insert into persona( id,apellido, dni, fecha_nacimiento, nombre) values (1,"Martinez", 222222,'2000-11-05',"Marcos");
-- insert into empleado values ( 0,'12:00:00','20:00:00', 25000, "Vendedor",1,1);
-- insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Lopez", 44444,'1998-10-11',"Martin");
-- insert into empleado  values ( 0,'12:00:00','20:00:00', 15000, "Vendedor",2,2);
-- insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Gonzalez", 11111,'1997-12-06',"Joaquin");
-- insert into empleado  values ( 1,'12:00:00','20:00:00', 18000, "Encargado",3,3);
-- insert into persona( apellido, dni, fecha_nacimiento, nombre) values  ("Garcia", 333333,'1996-11-08',"Jesus");
-- insert into empleado values ( 0,'12:00:00','20:00:00', 15000, "Repositor",4,4);

-- insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Aguirre", 88888,'2000-11-05',"Franco");
-- insert into cliente (cuil, cuit, email, numero, id) values (111111111111,111111111111, "franco@mail", 155845095,5);
-- insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Lopez", 44444,'1998-10-11',"Martin");
-- insert into cliente (cuil, cuit, email, numero, id) values (222222222222,222222222222, "Martin@mail", 155845095,6);
-- insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Gonzalez", 11112,'1997-12-06',"Esteban");
-- insert into cliente (cuil, cuit, email, numero, id) values (333333333333,333333333333, "Esteban@mail", 155845095,7);
-- insert into persona( apellido, dni, fecha_nacimiento, nombre) values ("Espinoza", 333331,'1996-11-08',"Juan");
-- insert into cliente (cuil, cuit, email, numero, id) values (444444444444,444444444444, "Juan@mail", 155845095,8);


-- insert into producto(id,descripcion,precio_unitario,codigo_producto,talle) values (1,"Remera",200,7791,38);
-- insert into producto(descripcion,precio_unitario,codigo_producto,talle) values ("Pantalon",400,7792,38);
-- insert into producto(descripcion,precio_unitario,codigo_producto,talle) values ("Zapatilla",600,7793,42);
-- insert into producto(descripcion,precio_unitario,codigo_producto,talle) values ("Ojotas",150,7794,40);

-- insert into lote(id,cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (1,50,50,'2020-06-01',123,1,1);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (100,100,'2020-05-01',124,1,2);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (25,25,'2020-04-01',125,1,3);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (50,50,'2020-03-01',126,1,4);

-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (10,10,'2020-06-01',127,2,1);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (100,100,'2020-05-01',128,2,1);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (25,25,'2020-04-01',129,2,3);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (20,20,'2020-03-01',130,2,4);

-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (70,70,'2020-06-01',131,3,1);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (30,30,'2020-05-01',132,3,2);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (25,25,'2020-04-01',133,3,2);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (10,10,'2020-03-01',134,3,4);

-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (10,10,'2020-06-01',135,4,1);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (5,5,'2020-05-01',136,4,3);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (25,25,'2020-04-01',137,4,3);
-- insert into lote(cantidad_existente, cantidad_recibida, fecha_ingreso, numero_de_lote, local_id, producto_id) values (200,200,'2020-03-01',138,4,4);

-- insert into pedido(id,cantidad,fecha,cliente_id,producto_id,vendedor_id) values (1,20,'2020-06-01',5,1,1);
-- insert into remito(id,forma_de_pago) values (1,"Efectivo");
-- insert into pedido(cantidad,fecha,cliente_id,producto_id,vendedor_id) values (30,'2020-06-01',7,3,2);
-- insert into remito(id,forma_de_pago) values (2,"Credito");
-- insert into pedido(cantidad,fecha,cliente_id,producto_id,vendedor_id) values (20,'2020-04-01',7,1,3);
-- insert into remito(id,forma_de_pago) values (3,"Efectivo");
-- insert into pedido(cantidad,fecha,cliente_id,producto_id,vendedor_id) values (18,'2020-04-11',5,2,4);
-- insert into remito(id,forma_de_pago) values (4,"Credito");

--  insert into pedido(cantidad,fecha,cliente_id,producto_id,vendedor_id) values (10,'2020-05-15',6,3,1);
--  insert into solicitud_stock(aceptado,id,colaborador_id,local_id) values (0,5,null,2);
--  insert into pedido(cantidad,fecha,cliente_id,producto_id,vendedor_id) values (5,'2020-05-15',6,4,2);
--  insert into solicitud_stock(aceptado,id,local_id) values (0,6,1);

--  insert into pedido(cantidad,fecha,cliente_id,producto_id,vendedor_id) values (15,'2020-05-25',6,4,3);
--  insert into solicitud_stock(aceptado,id,local_id) values (0,7,4);
--  insert into pedido(cantidad,fecha,cliente_id,producto_id,vendedor_id) values (9,'2020-05-07',8,1,4);
--  insert into solicitud_stock(aceptado,id,local_id) values (0,8,3);

-- insert into user(id,createdat,enabled,password,updatedat,username,empleado_id) values 
-- (1,"2020-03-22 00:00:01",1,"$2a$10$2898Kx3uUveq/fZ1wvLdL.e0cwggk.4R6dE0cNX7npYF.lrBYO9QS","2020-03-22 00:00:01","Marcos",1);

-- insert into user_role (id,createdat,role,updatedat,user_id) values 
-- (1,"2020-03-22 00:00:01","ROLE_USER","2020-03-22 00:00:01",1);

--  insert into user(id,createdat,enabled,password,updatedat,username,empleado_id) values 
-- (2,"2020-03-22 00:00:01",1,"$2a$10$2898Kx3uUveq/fZ1wvLdL.e0cwggk.4R6dE0cNX7npYF.lrBYO9QS","2020-03-22 00:00:01","Martin",2);

--  insert into user_role (id,createdat,role,updatedat,user_id) values 
-- (2,"2020-03-22 00:00:01","ROLE_USER","2020-03-22 00:00:01",2);

--  insert into user(id,createdat,enabled,password,updatedat,username,empleado_id) values 
-- (3,"2020-03-22 00:00:01",1,"$2a$10$2898Kx3uUveq/fZ1wvLdL.e0cwggk.4R6dE0cNX7npYF.lrBYO9QS","2020-03-22 00:00:01","Joaquin",3);

--  insert into user_role (id,createdat,role,updatedat,user_id) values 
-- (3,"2020-03-22 00:00:01","ROLE_ADMIN","2020-03-22 00:00:01",3);

--  insert into user(id,createdat,enabled,password,updatedat,username,empleado_id) values 
-- (4,"2020-03-22 00:00:01",1,"$2a$10$2898Kx3uUveq/fZ1wvLdL.e0cwggk.4R6dE0cNX7npYF.lrBYO9QS","2020-03-22 00:00:01","Jesus",4);

--  insert into user_role (id,createdat,role,updatedat,user_id) values 
-- (4,"2020-03-22 00:00:01","ROLE_USER","2020-03-22 00:00:01",4);

