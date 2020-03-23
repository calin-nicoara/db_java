CREATE TABLE client_order (
    id integer primary key,
    client_name varchar(100),
    phone_number varchar (100),
    number_of_products integer,
    total_order_value decimal(12, 4)
);

CREATE TABLE order_product_line
(
    id serial primary key,
    product_name varchar(255),
    product_price decimal(12, 4),
    quantity integer,
    client_order_id integer,
    foreign key (client_order_id) REFERENCES client_order(id)
);

select * from order_product_line;


ALTER TABLE order_product_line ALTER COLUMN client_order_id SET NOT NULL;
ALTER TABLE client_order ADD CONSTRAINT client_order_delivery_id UNIQUE (delivery_id);

ALTER TABLE client_order ADD COLUMN is_in_romania boolean DEFAULT true;

ALTER TABLE client_order RENAME COLUMN is_in_romania TO is_domestic;
ALTER TABLE client_order_2 RENAME TO client_order;

select * from client_order;

ALTER TABLE client_order ADD COLUMN delivery_id integer;

INSERT INTO order_product_line (product_name, product_price, quantity, client_order_id)
VALUES ('Fanta', 2.3, 6, null);

select co.client_name, opl.product_name, opl.quantity from order_product_line opl
LEFT JOIN client_order co ON co.id = opl.client_order_id;





delete from client_order where id = 1;

select * from order_product_line;


select * from client_order;

Create SEQUENCE id_for_order START 2;

ALTER TABLE client_order ADD COLUMN ex_serial serial;


ALTER TABLE client_order ADD COLUMN card_number varchar(255);
ALTER TABLE client_order ALTER COLUMN card_number TYPE varchar(255);
ALTER TABLE client_order DROP COLUMN card_number;

DROP TABLE client_order;

select * from client_order;

TRUNCATE client_order;
DELETE FROM client_order;

insert into client_order(id, client_name, phone_number,
                         number_of_products, total_order_value, is_in_romania)
VALUES (nextval('id_for_order'), 'Andreea', '07344343', 10, 10.322,
        false);


select * from client_order;
select * from order_product_line;

SELECT co.client_name, sum(opl.quantity * opl.product_price) FROM client_order co
JOIN order_product_line opl ON co.id = opl.client_order_id
GROUP BY co.id
HAVING sum(opl.quantity * opl.product_price) > 100;


CREATE TABLE client_order_2 (
                              id integer primary key,
                              client_name varchar(100),
                              phone_number varchar (100)
);

select * from client_order_2;

INSERT INTO client_order_2
SELECT id, client_name, phone_number from client_order;



