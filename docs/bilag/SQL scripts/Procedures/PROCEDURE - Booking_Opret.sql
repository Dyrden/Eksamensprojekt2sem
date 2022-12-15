CREATE PROCEDURE `Booking_Opret`(
-- Format:
-- vognnummer,BrugerID,abonnementstype,sted,udlejningsStartDato,udlejningsSlutDato,kilometerStart
IN $vognNummer varchar(25),
IN $BrugerID varchar(25),
IN $typeID varchar(25),
IN $stedID varchar(255),
IN $udlejningsStartDato varchar(19),
IN $udlejningsSlutDato varchar(19),
IN $kilometerStart varchar(10)
)
BEGIN
-- Inserts data into booking table. -----

INSERT INTO booking(
bruger_ID,
abonnementstype_ID,
udleveringssted_ID,
udlejningsStartDato,
udlejningsSlutDato,
kilometerStart,
bil_vognNummer)

VALUES(
$BrugerID COLLATE utf8mb4_0900_ai_ci,
$typeID COLLATE utf8mb4_0900_ai_ci, -- AbonnementsTypeID
$stedID COLLATE utf8mb4_0900_ai_ci, -- UdleveringsStedID
$udlejningsStartDato COLLATE utf8mb4_0900_ai_ci,
$udlejningsSlutDato COLLATE utf8mb4_0900_ai_ci,
$kilometerStart COLLATE utf8mb4_0900_ai_ci,
$vognNummer COLLATE utf8mb4_0900_ai_ci
);
-- Ændrer booked bil til udlejet. ----------
CALL Bil_RedigerStatusTilUdlejet($vognNummer);
-- ----------
END