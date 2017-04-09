use rubrica;

insert into Telefono(modello,size,weight,marca) values
	('HTC One M8', '146x70x9', 160, 'HTC'),
	('Iphone 5S', '123x58x8', 112, 'APPLE'),
	('Galaxy Note 3', '151x79x8', 168, 'SAMSUNG'),
	('Galaxy S4', '136x69x8', 130, 'SAMSUNG'),
	('Galaxy S5', '142x72x8', 145, 'SAMSUNG'),
	('Galaxy S4 mini', '125x61x9', 107, 'SAMSUNG'),
	('Moto X', '129x65x6', 130, 'MOTOROLA'),
	('Lumia 1020', '130x71x10', 158, 'NOKIA'),
	('Nexus 5', '138x69x8', 130, 'SAMSUNG'),
	('G2', '138x71x9', 143, 'SAMSUNG'),
	('Lumia 930', '137x71x10', 167, 'NOKIA'),
	('Galaxy S III','136x70x8', 133, 'SAMSUNG'),
	('Galaxy S II', '123x66x8.5', 116, 'SAMSUNG'),
	('Blackberry Z30','140x72x9.4', 170, 'BLACKBERRY'),
	('Vivo Xplay 3S', '158x82x8', 172, 'BBK'),
	('Lumia 520', '119x64x10', 124, 'NOKIA'),
	('8S','120x63x10', 113, 'HTC'),
	('Ativ S Neo','135x69x9', 144, 'SAMSUNG'),
	('8X','32,35 x 66,2 x 10,12', 130, 'HTC');
    
insert into Utente(nome,cognome,indirizzo,telefono,email,idTel) values
	('Ignazio','Mennito','Via Roma','3332545896','i.mennito@gmail.com',10),
    ('Pasquale','Grasso','Viale Italia','3332120876','p.grasso@gmail.com',9),
    ('Alessio','Priore','Via Napoli','3202578855','a.priore@libero.com',11),
    ('Angela','Peluso','Piazza Liberta','3402845776','a.peluso@libero.com',7),
    ('Giuseppe','Viviani','Piazza di Spagna','0825768512','g.viviani@libero.com',18),
    ('Francesco','Orioli','Via Provinciale','0824675210','f.orioli@gmail.com',1),
    ('Alessandro','Cardinale','Via Tapparelle','3318745802','a.cardinale@gmail.com',5),
    ('Carmine','Di Gruttola','Via Pisacane','0827410385','c.digruttola@libero.com',4),
    ('Mariangela','Schiavone','Via Nazionale','3284103856','m.schiavone@gmail.com',14),
    ('Carmen','Lino','Piazza Macello','0224567489','c.lino@libero.com',8),
    ('Antonio','Rossi','Via Nappi','0826784120','a.rossi@gmail.com',12),
    ('Mario','Verdi','Via Annarumma','3208014636','m.verdi@libero.com',2);
  
#Visualizzazione delle informazioni anagrafiche e del modello di telefono posseduto
select nome, cognome, indirizzo, telefono, email, modello from Utente as U join Telefono as T on U.idTel=T.id;

#Update sia delle informazioni anagrafiche che del telefono 
update Utente set nome='Patrizia', email='pat.gr@libero.it' where cognome='Grasso';
update Telefono set marca='ASDASD' where id=3;

#Visualizzazione delle informazioni relative al telefono
select modello,size,weight from Telefono where marca='SAMSUNG' order by modello;
select T.modello,T.marca from Telefono as T join Utente as U on T.id=U.idTel where U.nome='Ignazio';