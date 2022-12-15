CREATE PROCEDURE `Bruger_Opret`(
IN fornavn varchar(255), IN efternavn varchar(255), IN email varchar(255), IN tlf varchar(255), IN CPR varchar(255)
)
BEGIN

INSERT INTO bruger (`fornavn`,`efternavn`,`email`,`tlf`,`CPR`)
VALUES (fornavn, efternavn, email, tlf, CPR);

END