BEGIN;

UPDATE client_order set client_name = 'mistake 2' where id = -1;


ROLLBACK;
END;

SELECT * from client_order;
