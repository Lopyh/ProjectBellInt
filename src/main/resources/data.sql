INSERT INTO Client (id, login, password, name, activation_code)
VALUES (1, 'Pahsa322', 'e474e8808cfde82e38e98990761042422248e03e7284ddb5d9556d5a23cfff6a','vasya322','');

INSERT INTO Client (id, login, password, name, activation_code)
VALUES (2, 'loadsfg', 'password','vasya322','');


INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, isActive)
VALUES (1, 'Samsung', 'Samsung Company', '1234', '31345', 'Vilisa 21', '9676531', TRUE);

INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, isActive)
VALUES (2, 'Mazda', 'Mazda Company', '2345', '23456', 'Vilisa 221', '9676532', TRUE);

INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, isActive)
VALUES (3, 'Aqua', 'Aqua Lins', '3456', '56357', 'Vilisa 21', '9676533', FALSE );


INSERT INTO Office (id, org_id, name, address, phone, isActive)
VALUES (1, 2, 'Mazda Office 1', 'Vilisa  221','9435245', TRUE);

INSERT INTO Office (id, org_id, name, address, phone, isActive)
VALUES (2, 2, 'Mazda Office 2', 'Vilisa  2221','9435245', TRUE);

INSERT INTO Office (id, org_id, name, address, phone, isActive)
VALUES (3, 2, 'Mazda Office 3', 'Vilisa  2231','9435245', TRUE);

INSERT INTO Office (id, org_id, name, address, phone, isActive)
VALUES (4, 3, 'Aqua Office 2', 'Opa  2221','9435245', FALSE );

INSERT INTO Office (id, org_id, name, address, phone, isActive)
VALUES (5, 3, 'Aqua Office 3', 'Opa  2231','9435245', FALSE );



INSERT INTO User (id, office_id, first_name, last_name,
 middle_name, position, phone, doc_type_id, doc_number, doc_date, country_id, is_identified
)
VALUES (1, 2, 'Vladislav', 'Petrov', 'Sidorovich', 'Teacher', '322', 3, '2134-52',
'2009-03-05', 4, TRUE);


INSERT INTO User (id, office_id, first_name, last_name,
 middle_name, position, phone, doc_type_id, doc_number, doc_date, country_id, is_identified
)
VALUES (2, 2, 'Dmitry', 'Ivanov', 'Pavlovich', 'Doctor', '322', 3, '1234-54',
'2011-07-15', 3, TRUE);

INSERT INTO User (id, office_id, first_name, last_name,
 middle_name, position, phone, doc_type_id, doc_number, doc_date, country_id, is_identified
)
VALUES (3, 2, 'Aleksey', 'Golovanov', 'Evgenich', 'Himik', '322', 3, '1234-68',
'2010-12-22', 3, TRUE);


INSERT INTO DocType (id, name_doc, code)
VALUES(1, 'Certificate of registration of an immigrant''s application', 11);

INSERT INTO DocType (id, name_doc, code)
VALUES(2, 'Residence permit', 12);

INSERT INTO DocType (id, name_doc, code)
VALUES(3, 'Passport of the citizen of the Russian Federation', 21);

INSERT INTO DocType (id, name_doc, code)
VALUES(4, 'Seafarer''s passport', 26);

INSERT INTO Country (id, name, code)
VALUES(1, 'Austria', 40);

INSERT INTO Country (id, name, code)
VALUES(2, 'France', 250);

INSERT INTO Country (id, name, code)
VALUES(3, 'Poland', 616);

INSERT INTO Country (id, name, code)
VALUES(4, 'Russian Federation', 643);

INSERT INTO Country (id, name, code)
VALUES(5, 'Vietnam', 704);



