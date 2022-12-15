CREATE PROCEDURE `Skade_Slet`(IN $skade_ID int)
BEGIN
	DELETE FROM skade
	WHERE ID = $skade_ID COLLATE utf8mb4_0900_ai_ci;
END