
        CREATE TABLE IF NOT EXISTS Client (
        login             VARCHAR(10) NOT NULL,
        password          VARCHAR(10) NOT NULL,
        name           VARCHAR(10) NOT NULL,
         );

         CREATE TABLE IF NOT EXISTS Countries(
         nameCo           VARCHAR(100) NOT NULL,
         code             INTEGER  NOT NULL,
         );

        CREATE TABLE IF NOT EXISTS Docs(
         nameDo          VARCHAR(100) NOT NULL,
         code            INTEGER  NOT NULL,
         );

        CREATE TABLE IF NOT EXISTS Organization (
        id            INTEGER  PRIMARY KEY AUTO_INCREMENT,
        nameOr        VARCHAR(50) NOT NULL,
        fullName      VARCHAR(150) NOT NULL,
        inn           INTEGER  NOT NULL,
        kpp           INTEGER  NOT NULL,
        address       VARCHAR(200) NOT NULL,
        phone         VARCHAR(11) NOT NULL,
        isActive      BOOLEAN
        );

        CREATE TABLE IF NOT EXISTS Office (
        id            INTEGER  PRIMARY KEY AUTO_INCREMENT,
        org_id        INTEGER NOT NULL,
        nameOf        VARCHAR(200) NOT NULL,
        address       VARCHAR(200) NOT NULL,
        phone         VARCHAR(11) NOT NULL,
        isActive      BOOLEAN
        );

        CREATE INDEX IX_Office_Id ON Office (org_id);
        ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);


        CREATE TABLE IF NOT EXISTS Users (
        id                INTEGER  PRIMARY KEY AUTO_INCREMENT,
        office_id         INTEGER,
        first_name        VARCHAR(30) NOT NULL,
        last_name         VARCHAR(30) NOT NULL,
        middle_name       VARCHAR(30) NOT NULL,
        positionUs        VARCHAR(100) NOT NULL,
        phone             VARCHAR(11) NOT NULL,
        doc_number        INTEGER NOT NULL,
        doc_name          VARCHAR(100) NOT NULL,
        doc_date          DATE,
        sitizenship_name  VARCHAR(100) NOT NULL,
        sitizenship_code  INTEGER NOT NULL,
        is_identified     BOOLEAN
        );


        CREATE INDEX IX_Users_Id ON Users (office_id);
        ALTER TABLE Users ADD FOREIGN KEY (office_id) REFERENCES Office(id);

