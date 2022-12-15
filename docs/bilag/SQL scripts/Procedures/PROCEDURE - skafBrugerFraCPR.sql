CREATE PROCEDURE `skafBrugerFraCPR`(
IN $CPR varchar(25)
)
BEGIN
SELECT  
		ID,
        fornavn,
        efternavn,
        email,
        tlf,
        CPR
        
    FROM bruger
    
		WHERE CPR = $CPR COLLATE utf8mb4_0900_ai_ci;
        
END