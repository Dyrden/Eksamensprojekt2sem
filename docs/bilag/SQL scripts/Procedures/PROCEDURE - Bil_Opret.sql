CREATE PROCEDURE `Bil_Opret`(
IN $vognnummer varchar(255),
IN $stelnummer varchar(255),
IN $staalpris varchar(255),
IN $registreringsAfgift varchar(255),
IN $CO2Udledning varchar(255),
IN $productionsaar varchar(255),
IN $distance varchar(255),
IN $maanedspris varchar(255),
IN $model_ID varchar(255)
)
BEGIN
INSERT INTO `bilabonnement`.`bil`
(`vognNummer`,
`stelNummer`,
`staalpris`,
`registreringsAfgift`,
`CO2Udledning`,
`produktionsaar`,
`distance`,
`maanedspris`,
`model_ID`)
VALUES
($vognnummer COLLATE utf8mb4_0900_ai_ci,
$stelnummer COLLATE utf8mb4_0900_ai_ci,
$staalpris COLLATE utf8mb4_0900_ai_ci,
$registreringsAfgift COLLATE utf8mb4_0900_ai_ci,
$CO2Udledning COLLATE utf8mb4_0900_ai_ci,
$productionsaar COLLATE utf8mb4_0900_ai_ci,
$distance COLLATE utf8mb4_0900_ai_ci,
$maanedspris COLLATE utf8mb4_0900_ai_ci,
$model_ID COLLATE utf8mb4_0900_ai_ci);
END