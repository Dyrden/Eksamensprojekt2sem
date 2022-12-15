CREATE PROCEDURE `skafKilometerKoert`(IN $booking_ID int)
BEGIN

	SELECT rapport.kilometerSlut-booking.kilometerStart AS kilometerKoert
    FROM booking
	INNER JOIN rapport ON booking.ID = rapport.booking_ID
    WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END