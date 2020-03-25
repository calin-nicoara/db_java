CREATE OR REPLACE FUNCTION chargeExtra()
    RETURNS trigger AS
$BODY$
BEGIN
    IF NEW.client_name = 'Ionut' THEN
        NEW.total_order_value := NEW.total_order_value + 10;
    END IF;

    RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;

CREATE TRIGGER add_extra_for_ionut
    BEFORE INSERT
    ON client_order
    FOR EACH ROW
EXECUTE PROCEDURE chargeExtra();

INSERT INTO client_order(id, client_name, phone_number, total_order_value)
VALUES
       (1003, 'Ionut', '0723232300', 30.50);


CREATE OR REPLACE FUNCTION add_new_mystery_client()
RETURNS TRIGGER
AS $$
    BEGIN
        INSERT INTO client(id, first_name, last_name, phone_number, city) VALUES
        (100001, 'mystery ' || NEW.first_name || OLD.first_name, 'Test', '11333', 'Las Vegas');


        return NEW;
    end;
$$ LANGUAGE plpgsql;

CREATE TRIGGER add_new_client
    AFTER UPDATE
    ON client
    FOR EACH ROW
EXECUTE PROCEDURE add_new_mystery_client();



UPDATE client SET first_name = 'Flavius' where id = 10;


select * from client where id = 10;
select * from client where id = 100001;



select * from client_order where id >= 1000;