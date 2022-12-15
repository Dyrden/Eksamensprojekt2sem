CREATE PROCEDURE `skafAktiveBookingOgBilData`()
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
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        bil.maanedsPris,
        
-- Booking information
		booking.kilometerStart,
        booking.ID,
        booking.Bruger_ID,
        
        abonnementstype.type,
        udleveringssted.sted,
        
        booking.udlejningsStartDato,
        booking.udlejningsSlutDato,
		ceiling(
			TIMESTAMPDIFF(
				MONTH, booking.udlejningsStartDato, booking.udlejningsSlutDato
			) + 
			DATEDIFF(
				booking.udlejningsSlutDato, booking.udlejningsStartDato + 
				INTERVAL TIMESTAMPDIFF(
					MONTH, booking.udlejningsStartDato, booking.udlejningsSlutDato
				) 
				MONTH
			) /  
			DATEDIFF(
				booking.udlejningsStartDato + 
				INTERVAL TIMESTAMPDIFF(
					MONTH, booking.udlejningsStartDato, booking.udlejningsSlutDato
				) + 1 MONTH , 
                booking.udlejningsStartDato + INTERVAL 
                TIMESTAMPDIFF(
					MONTH, booking.udlejningsStartDato, booking.udlejningsSlutDato
				) MONTH 
			)
		) AS maanederUdlejet
        

    FROM bil

    -- Laver forbindelse fra bil til model, hvor model så vil forbinde sig til alle andre variabler.
	INNER JOIN model ON model_ID = model.ID
    
    INNER JOIN `status` ON status_ID = `status`.ID
    INNER JOIN farve ON farve.ID = model.farve_ID
    INNER JOIN maerke ON maerke.ID = model.maerke_ID
    
		INNER JOIN energitype ON energitype.ID = model.energitype_ID
		INNER JOIN gearboks ON gearboks.ID = model.gearboks_ID
		INNER JOIN udstyrsniveau ON udstyrsniveau.ID = model.udstyrsniveau_ID
        
        -- Booking info
        INNER JOIN booking ON vognNummer = booking.bil_vognNummer
        INNER JOIN udleveringssted ON udleveringssted.ID = booking.UdleveringsSted_ID
        INNER JOIN abonnementstype ON abonnementstype.ID = booking.AbonnementsType_ID
        
        
		WHERE booking.udlejningsSlutDato > now() AND booking.udlejningsStartDato < now();
END