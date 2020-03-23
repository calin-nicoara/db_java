CREATE FUNCTION testThisFunction(i integer) returns integer AS $$
DECLARE
    quantity integer := 30;
BEGIN
    return i + 20;
end;
$$ LANGUAGE plpqsql;


call testThisFunction(40);