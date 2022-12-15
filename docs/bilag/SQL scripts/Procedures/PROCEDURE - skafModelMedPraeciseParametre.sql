CREATE PROCEDURE `skafModelMedPraeciseParametre`(
IN $model varchar(255),
IN $energitype varchar(255),
IN $gearboks varchar(255),
IN $udstyrsniveau varchar(255),
IN $maerke varchar(255),
IN $farve varchar(255)
)
BEGIN

SELECT ID 
FROM model

WHERE model.model = $model COLLATE utf8mb4_0900_ai_ci 
AND energitype_ID = (SELECT ID FROM energitype WHERE `type`=$energitype COLLATE utf8mb4_0900_ai_ci )
AND gearboks_ID = (SELECT ID FROM gearboks WHERE gearType=$gearboks COLLATE utf8mb4_0900_ai_ci )
AND udstyrsniveau_ID = (SELECT ID FROM udstyrsniveau WHERE niveau=$udstyrsniveau COLLATE utf8mb4_0900_ai_ci )
AND maerke_ID = (SELECT ID FROM maerke WHERE maerke=$maerke COLLATE utf8mb4_0900_ai_ci )
AND farve_ID = (SELECT ID FROM farve WHERE farve=$farve COLLATE utf8mb4_0900_ai_ci );



END