select * from client
where lower(city) = 'bucuresti' ;

select * from client
where upper(city) = 'BUCURESTI' ;

select lower(city) from client;

CREATE INDEX idx_client_city ON client(city);
CREATE INDEX idx_client_lower_city ON client(lower(city));


CREATE INDEX idx_multiple ON client(city, last_name);

-- Correct for index above
Select * from client
where last_name = 'Popescu' and city = 'Bucuresti';

Select * from client
where last_name = 'Popescu';

-- Incorrect
Select * from client
where city = 'Bucuresti' and last_name = 'Popescu';

Select * from client
where last_name = 'Popescu';


EXPLAIN
select * from client
where lower(city) = 'cluj';

-- Seq scan is a normal search. Not indexed

