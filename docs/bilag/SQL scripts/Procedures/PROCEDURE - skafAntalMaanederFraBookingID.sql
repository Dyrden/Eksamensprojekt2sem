CREATE PROCEDURE `skafAntalMaanederFraBookingID`(
IN $booking_ID varchar(25)
)
BEGIN

SELECT 
timestampdiff(MONTH,(SELECT udlejningsStartDato FROM booking WHERE ID = $booking_ID),now()) AS maaneder;

END