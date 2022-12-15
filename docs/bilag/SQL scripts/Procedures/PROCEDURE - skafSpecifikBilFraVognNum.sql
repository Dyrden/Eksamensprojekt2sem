CREATE PROCEDURE `skafSpecifikBilFraVognNum`(
IN $vognNum varchar(255)
)
BEGIN
	SELECT 
		vognNummer,
		stelNummer,
        maerke.maerke, 
        model.model,
		energitype.`type`, 
        gearboks.gearType,
        udstyrsniveau.niveau,
        `status`.`status`,
		farve.farve, 
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil
    
    -- Bil Info
    INNER JOIN `status` ON bil.Status_ID=`status`.ID
    INNER JOIN model ON model.id = model_ID
		inner join farve on farve_ID = farve.id
		INNER JOIN maerke ON Maerke_ID = maerke.ID
		INNER JOIN energitype ON model.EnergiType_ID = energitype.ID
		INNER JOIN gearboks ON model.Gearboks_ID = gearboks.ID
		INNER JOIN udstyrsniveau ON model.Udstyrsniveau_ID = udstyrsniveau.ID
        
-- Bruger en metode til at sammenligne disse to Strings, da vognnummeret er 
-- for højt til at være en int, så både parameteren og værdien er varchar.as
-- COLLATE er til at programmet kan forstå hvilket "sprog", eller karakterer som bliver brugt her. (En form for ordbog)
WHERE vognNummer = $vognNum COLLATE utf8mb4_0900_ai_ci;
END