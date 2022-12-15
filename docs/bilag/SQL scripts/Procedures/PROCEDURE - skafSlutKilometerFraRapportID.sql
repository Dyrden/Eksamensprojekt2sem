CREATE PROCEDURE `skafSlutKilometerFraRapportID`(
IN $rapport_ID varchar(25)
)
BEGIN

SELECT kilometerSlut
FROM rapport
WHERE ID = $rapport_ID;

END