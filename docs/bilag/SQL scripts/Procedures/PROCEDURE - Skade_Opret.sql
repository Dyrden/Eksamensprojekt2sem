CREATE PROCEDURE `Skade_Opret`(
IN $rapport_ID varchar(25), IN $placering varchar(255), IN $beskrivelse varchar(255), IN $pris varchar(10)
)
BEGIN

INSERT INTO skade (placering,beskrivelse,pris,rapport_ID)
VALUES ($placering,$beskrivelse,$pris,$rapport_ID);

END