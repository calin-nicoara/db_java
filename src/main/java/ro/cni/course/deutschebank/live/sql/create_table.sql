create table client_address(
    id bigint primary key,
    street_name varchar(1000),
    street_number varchar(10),
    postal_code varchar(6),
    client_id  bigint NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id)
)