CREATE PROCEDURE `Bil_RedigerStatusTilUdlejet`(
IN vognNum varchar(255)
)
BEGIN

UPDATE bil
-- Status til "Udlejet" er 2.
SET status_ID = 2 
WHERE vognNummer = vognNum COLLATE utf8mb4_0900_ai_ci;
END