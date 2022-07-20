drop database ISP_Base;
create database  ISP_Base;
use  ISP_Base;


create table customers
(
    id       int(10) auto_increment not null,
    first_name     varchar(25) not null,
    last_name  varchar(25) not null,
    phone    varchar(13) not null unique,
    password varchar(10)not null,
    email    varchar(25) not null unique,
    is_active boolean default true,
    role varchar(10),
    created  timestamp default now(),
    updated  timestamp default now() on update NOW(),
    balance  int(10) default null,
    primary key (id)
);


create table tariffs
(
    id            int(10) auto_increment not null,
    name          varchar(25) not null unique,
    service_type  enum ('TV','INTERNET','IPTV','MOBILE') not null,
    price int(10) not null ,
    isActive      boolean   default true,
    created       timestamp default now(),
    updated       timestamp default now() on update NOW(),
    primary key (id)
);



create table services
(
    id           int(10) auto_increment not null,
    name         varchar(25)            not null unique,
    isActive     boolean   default true,
    created      timestamp default now(),
    updated      timestamp default now() on update NOW(),
    primary key (id),
    customers_id int(10),
    foreign key (customers_id) references customers (id)
);



create table services_tariffs
(
    service_id int(10) not null,
    tariff_id int(10) not null,
    primary key (service_id, tariff_id),
    foreign key (service_id) references services (id),
    foreign key (tariff_id) references tariffs (id)
);

create table customers_tariffs
(
    customers_id int(10) not null,
    tariffs_id   int(10) not null,
    primary key (customers_id, tariffs_id),
    foreign key (customers_id) references customers (id),
    foreign key (tariffs_id) references tariffs (id)
);

-- CREATE CUSTOMERS


insert into customers( first_name,last_name, phone,password,email,is_active,role,created,updated,balance) values ('Eduard','Vitko','+380955992668','20121980','eduardvitko@gmail.com',true,'CLIENT',now(),now(),0);
insert into customers( first_name,last_name, phone,password,email,is_active,role,created,updated,balance) values ('Anna','Kutsinina','+380667475521','21101984','annakut@gmail.com',true,'CLIENT',now(),now(),0);
insert into customers( first_name,last_name, phone,password,email,is_active,role,created,updated,balance) values ('Antonina','Sivash','+380632220085','28101962','sivash@gmail.com',true,'CLIENT',now(),now(),0);
insert into customers( first_name,last_name, phone,password,email,is_active,role,created,updated,balance) values ('Yuriy','Mischenko','+380447521430','29051959','yumich@gmail.com',true,'CLIENT',now(),now(),0);
insert into customers( first_name,last_name, phone,password,email,is_active,role,created,updated,balance) values ('Oleg','Chubko','+380664956273','28051938','chub@gmail.com',true,'CLIENT',now(),now(),0);

-- CREATE SERVISES

insert into services(name,isActive,created, updated) values ('INTERNET',true,now(),now());
insert into services(name,isActive,created, updated) values ('MOBILE',true,now(),now());
insert into services(name,isActive,created, updated) values ('IPTV',true,now(),now());
insert into services(name,isActive,created, updated) values ('TV',true,now(),now());

-- CREATE TARIFFS

insert into tariffs(name,service_type,price,isActive) values ('NO LIMITS','INTERNET',450,true);
insert into tariffs(name,service_type,price,isActive) values ('NIGHT','INTERNET',299,true);
insert into tariffs(name,service_type,price,isActive) values ('STUDENTS','INTERNET',99,true);
insert into tariffs(name,service_type,price,isActive) values ('DAY','INTERNET',349,true);
insert into tariffs(name,service_type,price,isActive) values ('LIGHT','INTERNET',199,true);

insert into tariffs(name,service_type,price,isActive) values ('BASE','MOBILE',119,true);
insert into tariffs(name,service_type,price,isActive) values ('CORPORATION','MOBILE',200,true);
insert into tariffs(name,service_type,price,isActive) values ('ROAMING','MOBILE',145,true);
insert into tariffs(name,service_type,price,isActive) values ('STUDY','MOBILE',102,true);
insert into tariffs(name,service_type,price,isActive) values ('WORK','MOBILE',179,true);

insert into tariffs(name,service_type,price,isActive) values ('WORLD','IPTV',79,true);
insert into tariffs(name,service_type,price,isActive) values ('HOUSE','IPTV',100,true);
insert into tariffs(name,service_type,price,isActive) values ('COMEDY','IPTV',115,true);
insert into tariffs(name,service_type,price,isActive) values ('ADVENTURES','IPTV',105,true);

insert into tariffs(name,service_type,price,isActive) values ('STANDARD','TV',65,true);
insert into tariffs(name,service_type,price,isActive) values ('FOOTBALL+','TV',230,true);
insert into tariffs(name,service_type,price,isActive) values ('SPORTS+','TV',119,true);
insert into tariffs(name,service_type,price,isActive) values ('CINEMA+','TV',159,true);
insert into tariffs(name,service_type,price,isActive) values ('ANIMALS+','TV',89,true);

insert into services_tariffs(service_id,tariff_id)values (1, 1);
insert into services_tariffs(service_id,tariff_id)values (1, 2);
insert into services_tariffs(service_id,tariff_id)values (1, 3);
insert into services_tariffs(service_id,tariff_id)values (1, 4);
insert into services_tariffs(service_id,tariff_id)values (1, 5);
insert into services_tariffs(service_id,tariff_id)values (2, 6);
insert into services_tariffs(service_id,tariff_id)values (2, 7);
insert into services_tariffs(service_id,tariff_id)values (2, 8);
insert into services_tariffs(service_id,tariff_id)values (2, 9);
insert into services_tariffs(service_id,tariff_id)values (2, 10);
insert into services_tariffs(service_id,tariff_id)values (3, 11);
insert into services_tariffs(service_id,tariff_id)values (3, 12);
insert into services_tariffs(service_id,tariff_id)values (3, 13);
insert into services_tariffs(service_id,tariff_id)values (3, 14);
insert into services_tariffs(service_id,tariff_id)values (4, 15);
insert into services_tariffs(service_id,tariff_id)values (4, 16);
insert into services_tariffs(service_id,tariff_id)values (4, 17);
insert into services_tariffs(service_id,tariff_id)values (4, 18);
insert into services_tariffs(service_id,tariff_id)values (4, 19);




