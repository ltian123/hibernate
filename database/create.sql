--mysql
create table t_person(
	id int primary key auto_increment,
	name varchar(10),
	birthday date,
	sex boolean,
	hobbies varchar(20)
);

--oracle
create table t_person(
	id number(4) primary key,
	name varchar2(10),
	birthday date,
	sex number(1),
	hobbies varchar2(20)
);
create sequence s_person;