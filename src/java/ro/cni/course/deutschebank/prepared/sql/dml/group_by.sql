-- Group all rows by cities.
SELECT city FROM client
GROUP BY city;

-- Does not work! last_name is not in GROUP BY.
SELECT last_name, city FROM client
GROUP BY city;

-- Can be used with aggregation function
SELECT count(last_name), city FROM client
GROUP BY city;

-- Group all rows by cities.
SELECT city FROM client
GROUP BY city
HAVING count(*) > 2;


