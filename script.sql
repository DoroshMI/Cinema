drop database  if exists cinemaMVC;
create database cinemaMVC;

use cinemaMVC;

create table `cinemamvc`.`theater`(
id int not null primary key,
money int,
name varchar(20));


INSERT INTO `cinemamvc`.`theater` (`id`, `money`, `name`) VALUES ('2', '1000', 'imax');
