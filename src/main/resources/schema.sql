drop table if exists users;
drop table if exists orders;


create table users (
  id identity,
  login varchar(25) not null,
  name varchar(25) not null,
  surname varchar(25) not null,
  patronymic varchar(25) not null,
  tel varchar(25) not null,
  email varchar(50) not null,
  isAdmin boolean not null,
  creationDate date not null
);

create table orders (
  id integer identity primary key,
  phoneId integer not null,
  phoneQty integer not null,
  user_id integer not null,
  creationDate date not null,
  foreign key (user_id) references users(id)
);




