INSERT INTO Client (login, password, name)
VALUES ('log', 'password','vasya322');

INSERT INTO Client (login, password, name)
VALUES ('loadsfg', 'password','vasya322',);


INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, isActive)
VALUES (1, 'ОАО Рог', 'ОАО Рога', 1234, 456, 'Вилиса 21', '9676534', TRUE);

INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, isActive)
VALUES (2, 'ОАО Рога', 'ОАО Копыта', 1234, 456, 'Вилиса 221', '9676534', TRUE);

INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, isActive)
VALUES (3, 'ОАО Рога', 'ОАО Рога и Копыта', 1234, 456, 'Вилиса 21', '9676534', FALSE );


INSERT INTO Office (id, org_id, name, address, phone, isActive)
VALUES (1, 2, 'ОАО Копыта Оффис', 'Вилиса 221','9435245', TRUE);

INSERT INTO Office (id, org_id, name, address, phone, isActive)
VALUES (2, 2, 'ОАО Копыта Оффис 2', 'Вилиса 2221','9435245', TRUE);

INSERT INTO Office (id, org_id, name, address, phone, isActive)
VALUES (3, 2, 'ОАО Копыта Оффис 3', 'Вилиса 2231','9435245', TRUE);


INSERT INTO User (id, office_id, first_name, last_name,
 middle_name, position, phone, doc_number, doc_name, doc_date, citizenship_name, citizenship_code, is_identified
)
VALUES (1, 2,  'Василий', 'Петров', 'Сидорович', 'Повар', '322', 123,'паспорт',
'2012-07-24', 'УФМС Опа', 322, TRUE);


INSERT INTO User (id, office_id, first_name, last_name,
 middle_name, position, phone, doc_number, doc_name, doc_date, citizenship_name, citizenship_code, is_identified
)
VALUES (2, 2, 'Дмитрий', 'Петров', 'Сидорович', 'Врач', '322', 123,'паспорт',
'2010-07-24', 'УФМС Опа', 322, TRUE);


INSERT INTO Docs (name_doc, code)
VALUES('Свидетельство о регистрации ходатайства иммигранта', 11);

INSERT INTO Docs (name_doc, code)
VALUES('Вид на жительство', 12);

INSERT INTO Docs (name_doc, code)
VALUES('Паспорт гражданина РФ', 21);

INSERT INTO Docs (name_doc, code)
VALUES('Паспорт моряка', 26);

INSERT INTO Docs (name_doc, code)
VALUES('Паспорт моряка', 26);

INSERT INTO Countri (name, code)
VALUES('Австрия', 40);

INSERT INTO Countri (name, code)
VALUES('Франция', 250);

INSERT INTO Countri (name, code)
VALUES('Польша', 616);

INSERT INTO Countri (name, code)
VALUES('Российская Федерация', 643);

INSERT INTO Countri (name, code)
VALUES('Вьетнам', 704);



