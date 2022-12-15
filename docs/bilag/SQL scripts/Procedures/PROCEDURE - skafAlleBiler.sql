CREATE PROCEDURE `skafAlleBiler`()
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
    
    -- Laver forbindelse fra bil til model, hvor model så vil forbinde sig til alle andre variabler.
	INNER JOIN model ON model_ID = model.ID
    
    INNER JOIN `status` ON status_ID = `status`.ID
    INNER JOIN farve ON farve.ID = model.farve_ID
    INNER JOIN maerke ON maerke.ID = model.maerke_ID
    
		INNER JOIN energitype ON energitype.ID = model.energitype_ID
		INNER JOIN gearboks ON gearboks.ID = model.gearboks_ID
		INNER JOIN udstyrsniveau ON udstyrsniveau.ID = model.udstyrsniveau_ID;
END