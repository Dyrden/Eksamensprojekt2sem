CREATE PROCEDURE `skafSkaderFraBookingID`(
IN $bookingID varchar(255)
)
BEGIN
	SELECT 
    skade.*
    FROM rapport
    
    INNER JOIN skade ON rapport.ID = skade.rapport_ID
    
    WHERE booking_ID = $bookingID COLLATE utf8mb4_0900_ai_ci;
END