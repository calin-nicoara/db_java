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
VALUES (1001, 'Ionut', '0723232329', 12.50);

select * from client_order where id >= 1000;