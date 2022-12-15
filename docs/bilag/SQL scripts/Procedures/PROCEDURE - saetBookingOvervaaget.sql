CREATE PROCEDURE `saetBookingOvervaaget`(IN $booking_ID int)
BEGIN

UPDATE booking
SET overvaaget = 1
WHERE ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END