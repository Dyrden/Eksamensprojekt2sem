CREATE PROCEDURE `skafbileraf1parameter`(IN param1 varchar(50))
BEGIN
	SELECT 
        vognNummer, 
        stelNummer,
        maerke.maerke,
        model.model,
        energitype.type,
        gearboks.gearType,
        udstyrsniveau.niveau,
        status.status,
        farve.farve,
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil

    
    
    INNER JOIN `status` ON bil.Status_ID=`status`.ID
    INNER JOIN model ON model.id = model_ID
		inner join farve on farve_ID = farve.id
		INNER JOIN maerke ON Maerke_ID = maerke.ID
		INNER JOIN energitype ON model.EnergiType_ID = energitype.ID
		INNER JOIN gearboks ON model.Gearboks_ID = gearboks.ID
		INNER JOIN udstyrsniveau ON model.Udstyrsniveau_ID = udstyrsniveau.ID
        
	-- 
        
    WHERE CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param1 , '%') COLLATE utf8mb4_0900_ai_ci
    AND status.status = "Ikke udlejet";

END