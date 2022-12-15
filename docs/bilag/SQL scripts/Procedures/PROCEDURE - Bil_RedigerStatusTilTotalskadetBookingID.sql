CREATE PROCEDURE `Bil_RedigerStatusTilTotalskadetBookingID`(
IN $booking_ID varchar(10)
)
BEGIN

UPDATE bil
-- Status til "Totalskadet" er 1.

INNER JOIN booking ON vognNummer = booking.bil_vognNummer

SET Status_ID = 1 

WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END