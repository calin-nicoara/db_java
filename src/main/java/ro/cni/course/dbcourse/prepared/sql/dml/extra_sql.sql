select CASE
    WHEN ex_serial > 5 THEN 0 ELSE 1 END
from client_order;