CREATE PROCEDURE `skafIndtaegt`()
BEGIN
		SELECT  
		bil.maanedsPris,
		maanederBooked(booking.udlejningsStartDato, booking.udlejningsSlutDato) AS maanederUdlejet


		FROM bil
		INNER JOIN booking ON vognNummer = booking.bil_vognNummer
        -- 2 = udlejet
		WHERE `status_ID` = 2;
END