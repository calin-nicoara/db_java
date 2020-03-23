-- Same result from both queries
SELECT * FROM client;
SELECT id, first_name, last_name, phone_number, city FROM client;

-- Just what we need
SELECT first_name, last_name, city FROM client;

-- Last names without repeating
SELECT DISTINCT last_name FROM client;

-- Filter your results
SELECT * FROM client
WHERE city = 'Bucuresti';

-- Where with AND
SELECT * FROM client
where city = 'Bucuresti' and last_name = 'Stoian';

-- Where with OR
SELECT * FROM client
where city = 'Slatina' or last_name = 'Stoian';

-- Same result from both queries
SELECT * FROM client ORDER BY city, id;

-- Same result from both queries
SELECT * FROM client ORDER BY city, id DESC;