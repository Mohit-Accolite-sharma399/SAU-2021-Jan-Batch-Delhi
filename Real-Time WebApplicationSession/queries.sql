create databasae realtime;
use realtime;
create table user(id int primary key auto_increment,email varchar(30),name varchar(30),password varchar(30));
create table currency(id int primary key auto_increment,email varchar(30),currency_id varchar(30),branchname varchar(30),isFake boolean,amount int,timestamp date);
