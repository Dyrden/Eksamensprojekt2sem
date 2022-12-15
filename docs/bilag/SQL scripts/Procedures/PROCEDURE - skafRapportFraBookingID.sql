CREATE PROCEDURE `skafRapportFraBookingID`(
IN $bookingID varchar(255)
)
BEGIN
	SELECT * 
    FROM Rapport
    WHERE booking_ID = $bookingID COLLATE utf8mb4_0900_ai_ci;
END