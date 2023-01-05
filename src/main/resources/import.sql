insert into People (NAME, BIRTH_DATE ) values ('Diego','1990-12-12');
insert into People (NAME, BIRTH_DATE) values ('Kami','1990-12-12');
insert into People (NAME, BIRTH_DATE) values ('Kevin','1990-12-12');
--
insert into Address (STREET, POST_CODE,NUMBER,CITY, IS_MAIN_ADDRESS,PEOPLE_ID) values ('rua 1','19550000','321B','Uberlandia',true,2);
insert into Address (STREET, POST_CODE,NUMBER,CITY,IS_MAIN_ADDRESS,PEOPLE_ID) values ('rua 2','19660000','321B','Belo Horizonte',true, 3);
insert into Address (STREET, POST_CODE,NUMBER,CITY,IS_MAIN_ADDRESS,PEOPLE_ID) values ('rua 3','19770000','321B','Regente Feijó',true,1);
insert into Address (STREET, POST_CODE,NUMBER,CITY,IS_MAIN_ADDRESS,PEOPLE_ID) values ('rua 5','19880000','323B','Regente Feijó',false,1);