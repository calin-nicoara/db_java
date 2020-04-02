CREATE TABLE product (
  id bigint primary key,
  name varchar(255),
  price decimal(12, 4),
  brand varchar(255)
);

INSERT INTO product(id, name, price, brand) VALUES (10000, 'Coca-Cola Doza 0.33l', 2.55, 'Coca-Cola');
INSERT INTO product(id, name, price, brand) VALUES (10001, 'Detergent 4kg', 50, 'Dero');
INSERT INTO product(id, name, price, brand) VALUES (10002, 'Ciocolata Capsuni', 5, 'Milka');