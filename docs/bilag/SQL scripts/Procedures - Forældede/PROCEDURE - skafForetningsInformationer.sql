CREATE PROCEDURE `skafForetningsInformationer`()
BEGIN
		SELECT  
		bil.maanedsPris,
		maanederBooked(booking.udlejningsStartDato, booking.udlejningsSlutDato) AS maanederUdlejet


		FROM bil
		INNER JOIN booking ON vognNummer = booking.bil_vognNummer
        -- 2 = udlejet
		WHERE `status_ID` = 2 AND MONTH(booking.udlejningsSlutDato) = MONTH(now());
END