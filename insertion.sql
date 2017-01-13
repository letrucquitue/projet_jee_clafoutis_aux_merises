DELETE FROM `panne`;
DELETE FROM `machine`;

INSERT INTO `machine` (type, id_machine)
VALUES
	('Routeur', '1A1A1A1A1A1A1A1A'),
	('Serveur', '1A3E31EA1AE313EA'),
	('Routeur', '1A1A1A1A19743974'),
	('Serveur', '1BABABAB1A1A1A1A'),
	('Pare-feu', '1A1093210435025A'),
	('Serveur', 'CA1CCBBA1A1A1A1A'),
	('Serveur', '1A0931CA19BCEE1A'),
	('Serveur', '1A1FFFFF13123FFF');

INSERT INTO `panne` (type, date_apparition, id_machine, reparee)
VALUES
	('Reseau', '2016-12-30 18:19:03', '1A1A1A1A1A1A1A1A', 0),
	('Crash Disque', '2016-12-30 00:19:43', '1A3E31EA1AE313EA', 0),
	('Reseau', '2016-12-14 21:19:09', '1A1A1A1A19743974', 1),
	('Reseau', '2016-11-29 19:17:33', '1BABABAB1A1A1A1A', 0),
	('Reseau', '2016-11-19 12:19:03', '1A1093210435025A', 0),
	('Crash Disque', '2016-12-30 01:39:03', 'CA1CCBBA1A1A1A1A', 1),
	('Probleme Memoire', '2016-12-25 10:14:03', '1A0931CA19BCEE1A', 0),
	('Probleme Memoire', '2016-12-25 05:39:00', '1A1FFFFF13123FFF', 0);

