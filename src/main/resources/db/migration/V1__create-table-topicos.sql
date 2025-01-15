create table topicos(
    id bigint not null auto_increment,
    mensaje varchar(500) not null,
    nombreCurso varchar(200) not null,
    titulo varchar(100) not null,
    fecha_creacion DATETIME NOT NULL,
    ultima_actualizacion DATETIME NOT NULL,

    primary key(id)
);