CREATE PROCEDURE `Rapport_OpretFraBookingID`(
IN $booking_ID varchar(25)
)
BEGIN

INSERT INTO rapport(booking_ID,dato)
VALUES($booking_ID,now());

END