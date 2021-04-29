create table labs 
( id serial,
lab_name text,
primary key (id)
);

create table tribbles
( id serial,
primary key(id),
color text,
lab_id int not null,
foreign key (lab_id) references labs(id) on delete cascade
);

select * from labs;

select * from tribbles;