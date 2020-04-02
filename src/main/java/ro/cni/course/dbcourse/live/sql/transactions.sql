select * from client where id = 9;

update client set first_name = 'NEW NAME' where id = 9;

BEGIN;

update client set first_name = 'CORRECT NAME SAVEPOINT' where id = 9;

-- SAVEPOINT aici_e_ok;

select first_name from client where id = 9;

ROLLBACK;
-- ROLLBACK TO aici_e_ok;

END;