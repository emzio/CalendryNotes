create table notes(
    id bigint primary key auto_increment,
    description varchar(100) not null,
    name varchar(100) not null
)
--     id int primary key auto_increment,
--     description varchar(100) not null,
--     days_to_deadline bigint not null,
--     project_id int not null,
--     foreign key (project_id) references projects(i