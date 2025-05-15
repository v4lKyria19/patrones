------ TABLA USUARIO
-- Crear tabla usuario
create table public.usuario (
	id_usuario serial not null,
	numero_identificacion varchar(50) not null,
	nombres varchar(100) not null,
	apellidos varchar(100) not null,
	contraseña varchar(25) not null,
	constraint usuario_pk primary key (id_usuario)
);

create unique index usuario_numero_identificacion_idx_unq ON public.usuario (numero_identificacion);

-- Poblar tabla usuario
insert into public.usuario (numero_identificacion, nombres, apellidos, contraseña)
values 
	('123456789', 'PEPE FERNANDO', 'HERNANDEZ SANCHEZ', 'pepe123'),
	('111111111', 'MARIA', 'PEREZ GONZALEZ', 'abcd123'),
	('000000000', 'ALEJANDRO FERNANDO', 'GUTIERREZ CIFUENTES', 'defg123')
;

-- Vaciar tabla usuario
delete from public.usuario;

-- Eliminar tabla usuario
drop table public.usuario;
drop index usuario_numero_identificacion_idx;


------ TABLA ENTIDAD
-- Crear tabla entidad
create table public.entidad (
	id_entidad serial not null,
	nombre varchar(150) not null,
	departamento varchar(100) not null,
	ciudad varchar(100) not null,
	direccion varchar(150) not null,
	constraint entidad_pk primary key (id_entidad)
);

-- Poblar tabla entidad
insert into public.entidad (nombre, departamento, ciudad, direccion)
values
	('REGISTRADURIA', 'BOGOTA D.C.', 'BOGOTA D.C.', 'AV. AMERICAS 73 C-355'),
	('LIBRETA MILITAR', 'BOGOTA D.C.', 'BOGOTA D.C.', 'KR. 11 B # 104A-64')
;

-- Vaciar tabla entidad
delete from public.entidad;

-- Eliminar tabla entidad
drop table public.entidad;


------ TABLA TRAMITE
-- Crear tabla tramite
create table public.tramite (
	id_tramite serial not null,
	nombre varchar(150) not null,
	constraint tramite_pk primary key (id_tramite)
);

-- Poblar tabla tramite
insert into public.tramite (nombre)
values
	('TARJETA IDENTIDAD'),
	('CEDULA'),
	('PASAPORTE'),
	('CITA PARA PRESENTAR DOCUMENTACION'),
	('CITA PARA RECLAMAR LIBRETA')
;

-- Vaciar tabla tramite
delete from public.tramite;

-- Eliminar tabla tramite
drop table public.tramite;


------ TABLA ENTIDAD_TRAMITE
-- Crear tabla entidad_tramite
create table public.entidad_tramite (
	id_entidad_tramite serial not null,
	id_entidad int4 not null,
	id_tramite int4 not null,
	constraint entidad_tramite_pk primary key (id_entidad_tramite),
	constraint entidad_tramite_id_entidad_fk foreign key (id_entidad) references public.entidad(id_entidad),
	constraint entidad_tramite_id_tramite_fk foreign key (id_tramite) references public.tramite(id_tramite)
);

create unique index entidad_tramite_idx_unq1 ON public.entidad_tramite (id_entidad, id_tramite);

-- Poblar tabla entidad_tramite
insert into public.entidad_tramite (id_entidad, id_tramite)
values
	(1, 1),
	(1, 2),
	(1, 3),
	(2, 4),
	(2, 5)
;

-- Vaciar tabla entidad_tramite
delete from public.entidad_tramite;

-- Eliminar tabla entidad_tramite
drop table public.entidad_tramite;


------ TABLA USUARIO_TRAMITE
-- Crear tabla usuario_tramite
create table public.usuario_tramite (
	id_usuario_tramite serial not null,
	id_usuario int4 not null,
	id_tramite int4 not null,
	fecha_registro timestamp not null default current_timestamp,
	constraint usuario_tramite_pk primary key (id_usuario_tramite),
	constraint usuario_tramite_id_usuario_fk foreign key (id_usuario) references public.usuario(id_usuario),
	constraint usuario_tramite_id_tramite_fk foreign key (id_tramite) references public.tramite(id_tramite)
);

create unique index usuario_tramite_idx_unq1 ON public.usuario_tramite (id_usuario, id_tramite);

-- Poblar tabla usuario_tramite
insert into public.usuario_tramite (id_usuario, id_tramite)
values
	()
;

-- Vaciar tabla usuario_tramite
delete from public.usuario_tramite;

-- Eliminar tabla usuario_tramite
drop index usuario_tramite_idx_unq1;
drop table public.usuario_tramite;