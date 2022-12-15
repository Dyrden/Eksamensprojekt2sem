CREATE PROCEDURE `skafUdregnetKilometerKoertOgOpdaterBilOgRapport`(IN $booking_ID int,IN $indtastetDistance int)
BEGIN

-- Assigner variabler
DECLARE $kilometerStart int;
DECLARE $kilometerKoert int;
DECLARE $bilVognNummer varchar(25);

-- bruger en subquery til at finde ud af bilens booking kilometerstart.
SET $kilometerStart = 
(SELECT kilometerStart FROM booking WHERE ID = $booking_ID COLLATE utf8mb4_0900_ai_ci LIMIT 1);

-- Kilometer kørt bliver udregnet ved at minus det nye indtastet distance med kilometerstart.
SET $kilometerKoert = 
$indtastetDistance - $kilometerStart;

-- bruger en subquery til at finde bilens vognnummer.
SET $bilVognNummer = 
(SELECT bil_vognNummer FROM booking WHERE ID = $booking_ID COLLATE utf8mb4_0900_ai_ci LIMIT 1);

-- Opdaterer Rapportens kilometerslut.alter
UPDATE rapport
SET kilometerSlut = $indtastetDistance
WHERE booking_ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

-- Opdaterer bilen, så den indtastet distance er den nye distance.
UPDATE bil
SET distance = $indtastetDistance
WHERE vognNummer = $bilVognNummer COLLATE utf8mb4_0900_ai_ci;

SELECT $kilometerKoert;

END