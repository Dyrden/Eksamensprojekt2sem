CREATE PROCEDURE `skafBookingFraID`(
IN $booking_ID varchar(255)
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
        
        WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END