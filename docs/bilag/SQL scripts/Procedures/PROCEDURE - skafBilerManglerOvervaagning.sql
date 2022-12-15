CREATE PROCEDURE `skafBilerManglerOvervaagning`()
BEGIN
SELECT  
-- Bil information
		vognNummer,
		stelNummer,
        maerke.maerke, 
        model.model,
		energitype.`type`, 
        gearboks.gearType,
        udstyrsniveau.niveau, 
        `status`.`status`, 
        farve.farve,  
        bil.staalpris, 
        registreringsAfgift, 
        CO2Udledning, 
        produktionsaar, 
        distance, 
        bil.maanedsPris, 
        booking.kilometerStart,
        
-- Booking information

         booking.ID,
         booking.Bruger_ID,
        
         abonnementstype.type,
         udleveringssted.sted,
        
         booking.udlejningsStartDato,
         booking.udlejningsSlutDato,
         booking.overvaaget
        
    FROM bil
    
    -- Bil Info
    INNER JOIN `status` ON bil.Status_ID=`status`.ID
    INNER JOIN model ON model.id = model_ID
		inner join farve on farve_ID = farve.id
		INNER JOIN maerke ON Maerke_ID = maerke.ID
		INNER JOIN energitype ON model.EnergiType_ID = energitype.ID
		INNER JOIN gearboks ON model.Gearboks_ID = gearboks.ID
		INNER JOIN udstyrsniveau ON model.Udstyrsniveau_ID = udstyrsniveau.ID
        
		-- Forbindelse fra bil til booking.
        INNER JOIN booking ON bil.vognNummer = booking.bil_vognNummer
        
        -- Booking info
       INNER JOIN udleveringssted ON udleveringssted.ID = booking.UdleveringsSted_ID
       INNER JOIN abonnementstype ON abonnementstype.ID = booking.AbonnementsType_ID
		WHERE `status`.`status` = "Udlejet" AND booking.overvaaget = 0 AND booking.udlejningsSlutDato < now()
        ORDER BY booking.udlejningsSlutDato ASC;
END