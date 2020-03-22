-- Insert without specfying fields
INSERT INTO client
VALUES (7, 'Madalin', 'Tanase', '074523219', 'Cluj');

-- Insert by specifying each field
INSERT INTO client (id, first_name, last_name, phone_number, city)
VALUES (7, 'Madalin', 'Tanase', '074523219', 'Cluj');