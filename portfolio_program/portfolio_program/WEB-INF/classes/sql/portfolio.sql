set names utf8;
set foreign_key_checks =0;
drop database if exists portfolio;
create database if not exists portfolio;
use portfolio;

drop table if exists login_user_transaction;

create table login_user_transaction(
user_id int(100) not null primary key auto_increment,
user_name varchar(100),
mail varchar(255),
password varchar(255),
delete_flg int(1),
registered_time datetime,
update_time datetime
);

drop table if exists my_calendar;

create table my_calendar(
id int(100) not null primary key auto_increment,
user_id int(100),
schedule varchar(255),
memo varchar(255),
start_date date,
end_date date,
all_day_flg int(1),
start_time time,
end_time time,
calendar_delete_flg int(1)
);
