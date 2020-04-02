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
where city LIKE '%Bucure%';

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

select count(id), city from client
where last_name = 'Popescu'
group by city
HAVING count(*) > 3
order by city;

select sum(id) from client;




select * from client
ORDER BY id LIMIT 5 OFFSET 15;

Select phone_number, client.first_name from client
where first_name IN (Select client_name from client_order where is_domestic = true);

Select phone_number, client.first_name from client
where (first_name, true) IN (Select client_name, is_domestic from client_order where is_domestic = true);

select  * from client;

select c.first_name from client c
UNION
select co.client_name from client_order co;

select c.first_name from client c
INTERSECT
select co.client_name from client_order co;

select * from client
where last_name IS NULL;

select * from client
where last_name IS NOT NULL;

select last_name, phone_number, COALESCE(last_name, phone_number, 'DEFAULT') from client;

select
       case
           when last_name IS NULL then 'last_name_is_null'
            else 'last_name_not_null'
        end,
       last_name,
       phone_number
from client;

select
    case
        when quantity IS NOT NULL then quantity * product_price
        else 0
    end As total
from order_product_line;

select * from order_product_line;




