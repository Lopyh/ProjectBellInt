INSERT INTO Client (id, login, password, name)
VALUES (1, 'log', 'password','vasya322');

INSERT INTO Client (id, login, password, name)
VALUES (2, 'loadsfg', 'password','vasya322');


INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, isActive)
VALUES (1, 'Samsung', 'ОАО Рога', '1234', '31345', 'Вилиса 21', '9676531', TRUE);

INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, isActive)
VALUES (2, 'ОАО Рога', 'ОАО Копыта', '2345', '23456', 'Вилиса 221', '9676532', TRUE);

INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, isActive)
VALUES (3, 'ОАО Рога', 'ОАО Рога и Копыта', '3456', '56357', 'Вилиса 21', '9676533', FALSE );


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


INSERT INTO DocType (id, name_doc, code)
VALUES(1, 'Свидетельство о регистрации ходатайства иммигранта', 11);

INSERT INTO DocType (id, name_doc, code)
VALUES(2, 'Вид на жительство', 12);

INSERT INTO DocType (id, name_doc, code)
VALUES(3, 'Паспорт гражданина РФ', 21);

INSERT INTO DocType (id, name_doc, code)
VALUES(4, 'Паспорт моряка', 26);

INSERT INTO DocType (id, name_doc, code)
VALUES(5, 'Паспорт моряка', 26);

INSERT INTO Country (id, name, code)
VALUES(1, 'Австрия', 40);

INSERT INTO Country (id, name, code)
VALUES(2, 'Франция', 250);

INSERT INTO Country (id, name, code)
VALUES(3, 'Польша', 616);

INSERT INTO Country (id, name, code)
VALUES(4, 'Российская Федерация', 643);

INSERT INTO Country (id, name, code)
VALUES(5, 'Вьетнам', 704);



