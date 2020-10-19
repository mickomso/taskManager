-- Deleting data to initialize the database content
DELETE FROM PUBLIC.TASK;

-- Adding registers to Task Table
INSERT INTO PUBLIC.TASK(id,title,description) values (NEXTVAL('TASK_SEQ'),'Demo title 1', 'Demo description 1');
INSERT INTO PUBLIC.TASK(id,title,description) values (NEXTVAL('TASK_SEQ'),'Demo title 2', 'Demo description 2');
INSERT INTO PUBLIC.TASK(id,title,description) values (NEXTVAL('TASK_SEQ'),'Demo title 3', 'Demo description 3');