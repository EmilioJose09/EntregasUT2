CREATE OR REPLACE PROCEDURE album_manin_procedure()
LANGUAGE plpgsql AS $ESPANITA$

BEGIN
    INSERT INTO Album(id, nom, tiempo) VALUES(55, 'Manin', 55.5);
END;
$ESPANITA$;