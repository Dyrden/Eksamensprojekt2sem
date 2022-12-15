CREATE PROCEDURE `Model_Opret`(
IN $model varchar(255),
IN $energitype varchar(255),
IN $gearboks varchar(255),
IN $udstyrsniveau varchar(255),
IN $maerke varchar(255),
IN $farve varchar(255)
)
BEGIN
INSERT INTO `bilabonnement`.`model`
(`model`,
`energiType_ID`,
`gearboks_ID`,
`udstyrsniveau_ID`,
`maerke_ID`,
`farve_ID`)
VALUES
($model,
(SELECT ID FROM energitype WHERE `type`=$energitype COLLATE utf8mb4_0900_ai_ci ),
(SELECT ID FROM gearboks WHERE gearType=$gearboks COLLATE utf8mb4_0900_ai_ci ),
(SELECT ID FROM udstyrsniveau WHERE niveau=$udstyrsniveau COLLATE utf8mb4_0900_ai_ci ),
(SELECT ID FROM maerke WHERE maerke=$maerke COLLATE utf8mb4_0900_ai_ci ),
(SELECT ID FROM farve WHERE farve=$farve COLLATE utf8mb4_0900_ai_ci ));

END