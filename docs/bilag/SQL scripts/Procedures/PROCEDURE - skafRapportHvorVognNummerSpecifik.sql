CREATE PROCEDURE `skafRapportHvorVognNummerSpecifik`(
IN $vognNum varchar(255)
)
BEGIN

select rapport.id, dato, vognnummer, kilometerslut

from rapport
inner join booking on booking.id = booking_id
	inner join bil on bil.vognnummer = bil_vognnummer
    
where vognnummer = $vognnum COLLATE utf8mb4_0900_ai_ci;

END