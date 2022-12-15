CREATE PROCEDURE `skafBookingfraRapportID`(
IN $rapportID varchar(25)
)
BEGIN
SELECT 
		booking.ID,
        bruger_ID,
        abonnementstype.type,
        udleveringssted.sted,
        udlejningsStartDato,
        udlejningsSlutDato,
        kilometerStart,
        bil_vognNummer
        
        FROM booking
        
        INNER JOIN abonnementstype ON booking.abonnementstype_ID = abonnementstype.ID
		INNER JOIN udleveringssted ON booking.udleveringssted_ID = udleveringssted.ID
        INNER JOIN rapport ON booking.ID = rapport.booking_ID
        
        WHERE rapport.ID = $rapportID COLLATE utf8mb4_0900_ai_ci;

END