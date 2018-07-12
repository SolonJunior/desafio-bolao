CREATE DATABASE "desafio-bolao";

CREATE TABLE public.usuario
(
  id integer NOT NULL,
  admin boolean NOT NULL,
  name character varying(255),
  password character varying(255),
  CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

insert into usuario(id, admin, name, password) values(1, true, 'admin', 'admin');

insert into usuario(id, admin, name, password) values(2, false, 'user1', 'user');
insert into usuario(id, admin, name, password) values(3, false, 'user2', 'user');
insert into usuario(id, admin, name, password) values(4, false, 'user3', 'user');