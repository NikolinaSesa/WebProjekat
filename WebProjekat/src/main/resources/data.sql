INSERT INTO FITNESSCENTAR(naziv, adresa, brtelefona, email) VALUES ('SuperFC', 'Kraljevica Marka bb', '0645536273', 'superfc@gmail.com');
INSERT INTO FITNESSCENTAR(naziv, adresa, brtelefona, email) VALUES ('FitMax', 'Svetog Save 11a', '0651234676', 'maxFit@gmail.com');

INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (60, 'A23',1);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (45, 'B14',1);

INSERT INTO ADMINISTRATOR(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan) VALUES ('ninasesa', '2345ftg', 'Nikolina', 'Sesa', '0641126921', 'nikolinasesaa23@gmail.com', '2000-09-23', 'ADMINISTRATOR', true);

INSERT INTO CLAN(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan) VALUES ('natasadjacic', 'ncbhjd73', 'Natasa', 'Djacic', '065674831', 'natashaa@gmail.com', '2000-02-06', 'CLAN', true);
INSERT INTO CLAN(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan) VALUES ('dragasvircevic', '35426tg', 'Draga', 'Svircevic', '063452731', 'dragaasvircevic@gmail.com', '2000-07-29', 'CLAN', true);
INSERT INTO CLAN(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan) VALUES ('milicagugleta', '2473672g', 'Milica', 'Gugleta', '061647883', 'micagugleta23@gmail.com', '2000-04-26', 'CLAN', true);
INSERT INTO CLAN(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan) VALUES ('natalijasub', 'jhdsa673ftg', 'Natalija', 'Subasic', '063456921', 'nataliiisub@gmail.com', '2000-10-26', 'CLAN', true);
INSERT INTO CLAN(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan) VALUES ('anjaaa', '82374htg', 'Anja', 'Dimitrijevic', '066487921', 'anjaaa23@gmail.com', '2000-08-24', 'CLAN', true);

INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan, fitnesscentar_id) VALUES('bokiipanic', 'nchd7384', 'Boris', 'Panic', '0654326781', 'borispanicc@gmail.com','1998-07-18','TRENER', true, 1);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan, fitnesscentar_id) VALUES('srdjanvasic','hfnc73748', 'Srdjan', 'Vasic', '0692435647', 'srkiivas@gmail.com', '1997-12-03', 'TRENER', true, 1);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan, fitnesscentar_id) VALUES('anasesa', 'hhdfs67324', 'Ana', 'Sesa', '0642314725','anasesaa03@gmail.com', '2003-06-25','TRENER', true, 1);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan, fitnesscentar_id) VALUES('markomarkovic123', 'nncby746', 'Marko', 'Markovic', '0634657892','makimaki123@gmail.com', '1998-07-23','TRENER', false, 1);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan, fitnesscentar_id) VALUES('perapetrovic', 'jdskjfhshf743', 'Petar', 'Petrovic', '0626478986','perapera23@gmail.com', '2001-10-12','TRENER', false, 1);
INSERT INTO TRENER(korisnickoime, lozinka, ime, prezime, brtelefona, email, datumrodjenja, uloga, aktivan, fitnesscentar_id) VALUES('radarada', 'kfsdkffs67324', 'Radoslava', 'Rasic', '0697461725','radarasic@gmail.com', '1999-01-14','TRENER', false, 1);

INSERT INTO TRENING(naziv, opis, tip, trajanje, trener_id) VALUES('Kardio trening', 'Kardio trening za celo telo','CARDIO', 1.5, 1);
INSERT INTO TRENING(naziv, opis, tip, trajanje, trener_id) VALUES('Joga', 'Joga za opustanje','YOGA', 1.0, 2);
INSERT INTO TRENING(naziv, opis, tip, trajanje, trener_id) VALUES('Kikboks', 'Borilacki tip treninga', 'KICKBOX', 2.5, 3);
INSERT INTO TRENING(naziv, opis, tip, trajanje, trener_id) VALUES('Hiit', 'Vezbe', 'HIIT', 2, 3);
INSERT INTO TRENING(naziv, opis, tip, trajanje, trener_id) VALUES('Pilates', 'Pilates trening', 'PILATES', 1.0, 2);
INSERT INTO TRENING(naziv, opis, tip, trajanje, trener_id) VALUES('Pilates', 'Pilates trening', 'PILATES', 1.0, 1);

INSERT INTO TERMIN(br_prijavljenih_clanova, cena, datum, vreme, sala_id, trening_id) VALUES(0, 1500.0, '2021-7-1', '13:00', 2, 2);
INSERT INTO TERMIN(br_prijavljenih_clanova, cena, datum, vreme, sala_id, trening_id) VALUES(0, 1500.0, '2021-7-3', '13:00', 2, 2);
INSERT INTO TERMIN(br_prijavljenih_clanova, cena, datum, vreme, sala_id, trening_id) VALUES(0, 2000.0, '2021-7-6', '17:00', 1, 5);
INSERT INTO TERMIN(br_prijavljenih_clanova, cena, datum, vreme, sala_id, trening_id) VALUES(0, 2500.0, '2021-7-12', '20:00', 1, 3);
INSERT INTO TERMIN(br_prijavljenih_clanova, cena, datum, vreme, sala_id, trening_id) VALUES(0, 2500.0, '2021-7-14', '21:00', 1, 3);
INSERT INTO TERMIN(br_prijavljenih_clanova, cena, datum, vreme, sala_id, trening_id) VALUES(0, 1200.0, '2021-7-16', '20:00', 1, 1);

INSERT INTO LISTAPRIJAVA(clan_id, termin_id) VALUES(3, 1);
INSERT INTO LISTAPRIJAVA(clan_id, termin_id) VALUES(2, 1);
INSERT INTO LISTAPRIJAVA(clan_id, termin_id) VALUES(5, 1);
INSERT INTO LISTAPRIJAVA(clan_id, termin_id) VALUES(5, 2);
INSERT INTO LISTAPRIJAVA(clan_id, termin_id) VALUES(5, 6);

INSERT INTO ODRADJENI(clan_id, termin_id) VALUES(1, 2);
INSERT INTO ODRADJENI(clan_id, termin_id) VALUES(2, 2);
INSERT INTO ODRADJENI(clan_id, termin_id) VALUES(3, 1);


