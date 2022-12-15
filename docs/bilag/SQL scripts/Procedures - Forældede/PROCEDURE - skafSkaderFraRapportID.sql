CREATE PROCEDURE `skafSkaderFraRapportID`(IN $rapport_ID int)
BEGIN

	SELECT 
    *
    FROM skade
    
    WHERE skade.rapport_ID = $rapport_ID COLLATE utf8mb4_0900_ai_ci;
END