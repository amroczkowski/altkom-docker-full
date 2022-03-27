create table account (
    id numeric(19) primary key,
    first_name varchar(32) not null,
    last_name varchar(32) not null,
    pesel varchar(11) not null
);

create sequence account_seq increment by 20 minvalue 1 maxvalue 999999999999999999 cache 20;