CREATE PROCEDURE `Bil_RedigerStatusTilIkkeUdlejet`(
IN vognNum varchar(255)
)
BEGIN

UPDATE bil
-- Status til "Ikke Udlejet" er 3.
SET Status_ID = 3 
WHERE vognNummer = vognNum COLLATE utf8mb4_0900_ai_ci;
END