CREATE PROCEDURE `Bil_RedigerStatusTilIkkeUdlejetBookingID`(
IN $booking_ID varchar(10)
)
BEGIN

UPDATE bil
-- Status til "Ikke udlejet" er 3.

INNER JOIN booking ON vognNummer = booking.bil_vognNummer

SET Status_ID = 3 

WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END