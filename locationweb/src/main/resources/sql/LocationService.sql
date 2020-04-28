create database mydb

use mydb

create table location(
Id int PRIMARY KEY,
code varchar(20),
name varchar(20),
type varchar(20)
)

select * from location

drop table location