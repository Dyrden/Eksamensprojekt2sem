CREATE PROCEDURE `Bil_FindAlleUdlejet`()
BEGIN

select vognnummer, stelnummer, staalpris, registreringsafgift,
co2udledning, produktionsaar, distance, maanedspris, model, type, geartype,
niveau, maerke, farve, status 

from bil

inner join status on status.id = status_ID
inner join model on model.id = model_ID
	inner join energitype on energitype.id = energitype_ID
    inner join gearboks on gearboks.id = gearboks_ID
    inner join udstyrsniveau on udstyrsniveau.id = udstyrsniveau_ID
    inner join maerke on maerke.id =  maerke_ID
    inner join farve on farve.id = farve_ID

-- status_ID = 2 betyder udlejet
where status_ID = 2;

END