drop database  if exists cinemaMVC;
create database cinemaMVC;

use cinemaMVC;

create table `cinemamvc`.`theater`(
id int primary key not  null,
money int,
name varchar(20));


INSERT INTO `cinemamvc`.`theater` (`id`, `money`, `name`) VALUES ('2', '1000', 'imax');
