drop database  if exists cinemaMVC;
create database cinemaMVC;

use cinemaMVC;

create table `cinemamvc`.`theater`(
id int not null,
monye int,
name varchar,
primary key id);


INSERT INTO `cinemamvc`.`theater` (`id`, `money`, `name`) VALUES ('2', '1000', 'imax');
