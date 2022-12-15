CREATE PROCEDURE `Rapport_RedigerSlutKilometerFraRapportID`(
IN $rapport_ID varchar(25), IN $kilometerSlut varchar(25)
)
BEGIN

UPDATE rapport
SET kilometerSlut = $kilometerSlut
WHERE ID = $rapport_ID;

END