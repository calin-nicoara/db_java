select * from client;

select last_name from client;

INSERT INTO client  (id, first_name, last_name, phone_number, city)
VALUES (9, 'Ionut', 'Ghinea', '0678923235', 'Bud');

UPDATE client set last_name = 'Popescu'
where id = '8';

DELETE FROM client
where id = '8';


select distinct * from client;


SELECT * FROM client
WHERE (id=4 or id = 3) and city= 'Bucuresti';

select * from client
WHERE id IN (1, 3)
ORDER BY city ASC, id DESC;

select * from client
ORDER BY city ASC, id DESC;

-- Try to avoid!!!!
select * from client
where city LIKE 'Bucure%';

select * from client
where city LIKE 'Bu_';

select * from client
where id <= 5 and id >= 2;

select * from client
where id BETWEEN 2 and 5;

select min(id) from client;
select max(id) from client;
select avg(id) from client;
select sum(id) from client;

select sum(id),city, max(last_name) from client
where city LIKE 'Bu%'
group by city
having sum(id) > 8
order by max(id);

select count(*), city from client
group by city
order by count(*);

select * from client
order by id;






