EXPLAIN
SELECT * FROM client
where city = 'Buzau';

select * FROM client;

CREATE INDEX idx_client_city ON client(city);
REINDEX INDEX idx_client_city;