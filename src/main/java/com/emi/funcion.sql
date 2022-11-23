CREATE OR REPLACE FUNCTION album_manin_function()
RETURNS VARCHAR
LANGUAGE plpgsql AS $ESPANITA$
DECLARE nombre VARCHAR;

BEGIN
    SELECT nom INTO nombre FROM album;
    RETURN nombre;
    END;
$ESPANITA$;