create table pictures(
    id bigint primary key auto_increment,
    path varchar(100) not null
);
alter table notes add column picture_id bigint null;
alter table notes add foreign key (picture_id) references pictures;