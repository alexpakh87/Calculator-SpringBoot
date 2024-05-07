
 create table my_table (
    id  bigserial not null  ,
    num_system varchar(255),
    first_number varchar(255),
    operation varchar(255),
    second_number varchar(255),
    result varchar(255),
    time_operation timestamp default now() ,
    primary key (id)
 );




