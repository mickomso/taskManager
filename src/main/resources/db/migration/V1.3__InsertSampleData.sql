-- Deleting data to initialize the database content
DELETE FROM PUBLIC.TASK;
DELETE FROM PUBLIC.USER;

-- Adding registers to User Table
INSERT INTO PUBLIC.USER(id,name,email,created_on) values (NEXTVAL('USER_SEQ'),'Alfredo', 'alfredo@mail.com', now());
INSERT INTO PUBLIC.USER(id,name,email,created_on) values (NEXTVAL('USER_SEQ'),'Mario', 'Susana@mail.com', now());
INSERT INTO PUBLIC.USER(id,name,email,created_on) values (NEXTVAL('USER_SEQ'),'Susana', 'susana@mail.com', now());

-- Adding registers to Task Table
INSERT INTO PUBLIC.TASK(id,title,description,created_on,updated_on,completed,user_id) values (NEXTVAL('TASK_SEQ'),'Demo title 1', 'Demo description 1', now(), null, false, (select id from public.user where name = 'Alfredo') );
INSERT INTO PUBLIC.TASK(id,title,description,created_on,updated_on,completed,user_id) values (NEXTVAL('TASK_SEQ'),'Demo title 2', 'Demo description 2', now(), null, false, (select id from public.user where name = 'Mario') );
INSERT INTO PUBLIC.TASK(id,title,description,created_on,updated_on,completed,user_id) values (NEXTVAL('TASK_SEQ'),'Demo title 3', 'Demo description 3', now(), null, false, (select id from public.user where name = 'Susana') );