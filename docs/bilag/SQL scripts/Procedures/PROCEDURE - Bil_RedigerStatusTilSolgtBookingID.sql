CREATE PROCEDURE `Bil_RedigerStatusTilSolgtBookingID`(
IN $booking_ID varchar(10)
)
BEGIN

UPDATE bil
-- Status til "Solgt" er 4.

INNER JOIN booking ON vognNummer = booking.bil_vognNummer

SET Status_ID = 4 

WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END