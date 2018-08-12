
SET NAMES 'cp866';

INSERT INTO countries (code, name) VALUES (0,'Гражданство отсутствует');
INSERT INTO countries (code, name) VALUES (1,'Россия');
INSERT INTO countries (code, name) VALUES (2,'Белоруссия');
INSERT INTO countries (code, name) VALUES (3,'Китай');
INSERT INTO countries (code, name) VALUES (4,'Япония');
INSERT INTO countries (code, name) VALUES (5,'Тайланд');
INSERT INTO countries (code, name) VALUES (6,'Канада');

INSERT INTO docs (code, name) VALUES (0,'Документ отсутствует');
INSERT INTO docs (code, name) VALUES (1,'Паспорт РФ');
INSERT INTO docs (code, name) VALUES (2,'Загранпаспорт');
INSERT INTO docs (code, name) VALUES (3,'Военный билет');
INSERT INTO docs (code, name) VALUES (4,'Водительское удостоверение');
INSERT INTO docs (code, name) VALUES (5,'Удостоверение офицера МО');
INSERT INTO docs (code, name) VALUES (6,'СНИЛС');

INSERT INTO Organizations (name, inn, isActive, fullName, kpp, address, phone)
  VALUES ('Агропром','123456789012',true,'OOO Агропром','123456789','Саратов, ул. Бахметьевская, д. 35/37','+78452123456');
INSERT INTO organizations (name, inn, isActive, fullName, kpp, address, phone)
  VALUES ('Мария','223456789013',true,'OOO Торговый дом Мария','223456789','Саратов, ул. Фабричная, д. 23','+78452654321');
INSERT INTO organizations (name, inn, isActive, fullName, kpp, address, phone)
  VALUES ('СГПА','323456789014',false,'OOO СаратовГазПриборАвтоматика','323456789','Саратов, ул. Шелковичная, д. 11','+78452951753');

INSERT INTO Offices (orgId, name, phone, isActive, address)
  VALUES (1,'Toronto','+78452123457',true,'Саратов, ул. Бахметьевская, д. 35/37 оф.1');
INSERT INTO offices (orgId, name, phone, isActive, address)
  VALUES (1,'Vancouver','+78452123458',true,'Саратов, ул. Бахметьевская, д. 35/37 оф.2');
INSERT INTO offices (orgId, name, phone, isActive, address)
  VALUES (1,'Alberta','+78452123459',true,'Саратов, ул. Бахметьевская, д. 35/37 оф.3');
INSERT INTO offices (orgId, name, phone, isActive, address)
  VALUES (2,'Москва','+78452654322',true,'Саратов, ул. Фабричная, д. 23 к. 15');
INSERT INTO offices (orgId, name, phone, isActive, address)
  VALUES (3,'Переговорка','+78452951754',true,'Саратов, ул. Шелковичная, д. 11 оф. 13');

INSERT INTO Users (officeId, firstName, lastName, middleName, position, docId, citizenshipId, phone, docNumber, docDate, isIdentified)
  VALUES (1,'Антон','Суряпин','Александрович','Директор',2,2,'89061490174','6304123456','2004-11-19',true);
INSERT INTO Users (officeId, firstName, lastName, middleName, position, docId, citizenshipId, phone, docNumber, docDate, isIdentified)
  VALUES (2,'Елена','Иманова','Александровна','Заместитель директора',2,2,'89061490173','6304123465','2011-10-11',true);
INSERT INTO Users (officeId, firstName, lastName, middleName, position, docId, citizenshipId, phone, docNumber, docDate, isIdentified)
  VALUES (1,'Альваро','Мехиа','','Водитель',3,7,'89171234567','111222333','1999-05-11',true);
INSERT INTO Users (officeId, firstName, lastName, middleName, position, docId, citizenshipId, phone, docNumber, docDate, isIdentified)
  VALUES (3,'Дмитрий','Можаров','Николаевич','Начальник отдела маркетинга',2,2,'89031564574','6304179456','2004-05-25',true);
INSERT INTO Users (officeId, firstName, lastName, middleName, position, docId, citizenshipId, phone, docNumber, docDate, isIdentified)
  VALUES (4,'Кокунов','Роман','Игоревич','Начальник СБ',6,3,'89041112223','5551313','1998-10-12',false);
INSERT INTO Users (officeId, firstName, lastName, middleName, position, docId, citizenshipId, phone, docNumber, docDate, isIdentified)
  VALUES (4,'Пак','Юджи','Свон','Директор',3,5,'89995656398','4449876','2008-08-30',true);
INSERT INTO Users (officeId, firstName, lastName, middleName, position, docId, citizenshipId, phone, docNumber, docDate, isIdentified)
  VALUES (4,'Мэй','В-ши','Свон','Заместитель директора',3,6,'89999638521','5551555','2009-01-15',true);
INSERT INTO Users (officeId, firstName, lastName, middleName, position, docId, citizenshipId, phone, docNumber, docDate, isIdentified)
  VALUES (5,'Сунь','Пунь','Чунь','Директор',3,4,'89033353353','91959195','2001-02-08',true);
INSERT INTO Users (officeId, firstName, lastName, middleName, position, docId, citizenshipId, phone, docNumber, docDate, isIdentified)
  VALUES (5,'Иван','Миронов','Андреевич','Уборщик',4,2,'89048759864','6304548659','2002-10-1',false);
