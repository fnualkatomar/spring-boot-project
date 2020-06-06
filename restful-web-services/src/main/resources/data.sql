insert into user(id,birth_Date,name) values(101,sysdate(),'AB');
insert into user(id,birth_Date,name) values(102,sysdate(),'CD');
insert into user(id,birth_Date,name) values(103,sysdate(),'EF');
UPDATE USER SET NAME = REPLACE(NAME, 'A', '/INTERFACE_CMP_STG/') WHERE NAME LIKE 'A%';