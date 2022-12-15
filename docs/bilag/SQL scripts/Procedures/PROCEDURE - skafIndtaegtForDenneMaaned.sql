CREATE PROCEDURE `skafIndtaegtForDenneMaaned`()
BEGIN
		SELECT  
		bil.maanedsPris,
		maanederBooked(booking.udlejningsStartDato, booking.udlejningsSlutDato) AS maanederUdlejet


		FROM bil
		INNER JOIN booking ON vognNummer = booking.bil_vognNummer

		WHERE booking.udlejningsSlutDato > now() AND booking.udlejningsStartDato < now();
END