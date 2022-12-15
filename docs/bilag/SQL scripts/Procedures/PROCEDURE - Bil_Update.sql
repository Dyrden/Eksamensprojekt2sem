CREATE PROCEDURE `Bil_Update`()
BEGIN
-- bliver kun bruge i update test
update bil

set staalpris = 12345678

where staalpris = 12348765;

END