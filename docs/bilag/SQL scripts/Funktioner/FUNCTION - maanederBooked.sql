CREATE DEFINER=`Control`@`%` FUNCTION `maanederBooked`(`$start` date, $slut date) RETURNS int
BEGIN
-- returnerer de antal måneder mellem 2 datoer rundet op.
-- Afrundningen sker i det at hvis en bruger har bestilt for 2 og and halv måned så skal den halve stadig betales
	RETURN ceiling(
			TIMESTAMPDIFF(
				MONTH, `$start`, $slut
			) + 
			DATEDIFF(
				$slut, `$start` + 
				INTERVAL TIMESTAMPDIFF(
					MONTH, `$start`, $slut
				) 
				MONTH
			) /  
			DATEDIFF(
				`$start` + 
				INTERVAL TIMESTAMPDIFF(
					MONTH, `$start`, $slut
				) + 1 MONTH , 
				`$start` + INTERVAL 
				TIMESTAMPDIFF(
					MONTH, `$start`, $slut
				) MONTH 
			)
		);
END