create table products(
    id char(36) not null,
    name varchar(100) not null unique,
    price float not null,
    stock float not null,
    state_storage char(2) not null,

    primary key(id)
);