create table users(
    id char(36) not null,
    name varchar(100) not null,
    email varchar(100) not null unique,
    password varchar(100),
    address_id char(36) not null,

    primary key(id)
);

create table addresses(
    id char(36) not null,
    zip_code char(9) not null,
    street varchar(100) not null,
    number varchar(10) not null,
    complement varchar(100) not null,
    neighborhood varchar(100) not null,
    city varchar(100) not null,
    state char(2) not null,
    add char(3) not null,

    primary key(id)
);