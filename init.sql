

use torneo;

create table players (
    dni char(13) primary key,
    name varchar(50) not null,
    lName1 varchar(50) not null,
    lName2 varchar(50),
    phone char(13) not null,
    teamName varchar(150),
    date_of_birth date not null,
    username varchar(50)
);

create table team (
    name varchar(150) primary key,
    creation_date date not null
)

