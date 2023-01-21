DROP DATABASE IF EXISTS dmjava_juliette_jeremy_brice_flavien;
CREATE DATABASE dmjava_juliette_jeremy_brice_flavien;
USE dmjava_juliette_jeremy_brice_flavien;

CREATE TABLE Docs
(
    id         SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Livre
(
    id               SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Docs_id          SMALLINT,
    title            CHAR(255),
    author           CHAR(255),
    publication_year SMALLINT,
    borrowed         BOOL,
    FOREIGN KEY (Docs_id) REFERENCES Docs (id)
);

CREATE TABLE CD
(
    id               SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Docs_id          SMALLINT,
    title            CHAR(255),
    artist           CHAR(255),
    number_of_tracks SMALLINT,
    borrowed         BOOL,
    FOREIGN KEY (Docs_id) REFERENCES Docs (id)
);

CREATE TABLE DVD
(
    id       SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Docs_id SMALLINT,
    title    CHAR(255),
    director CHAR(255),
    studio   CHAR(255),
    borrowed BOOL,
    FOREIGN KEY (Docs_id) REFERENCES Docs (id)
);

CREATE TABLE Magazine
(
    id               SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Docs_id         SMALLINT,
    title            CHAR(255),
    issue_number     SMALLINT,
    publication_date CHAR(255),
    FOREIGN KEY (Docs_id) REFERENCES Docs (id)
);

INSERT INTO Docs
VALUES (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10),
       (11),
       (12);

INSERT INTO livre
VALUES (1, 1, 'Les Fleurs du mal', 'Charles Baudelaire', 1857, 1),
       (2, 2, 'Dune', 'Frank Herbert', 1970, 1),
       (3, 3, 'La Nuit des temps', 'René Barjavel', 1960, 0);

INSERT INTO cd
VALUES (1, 4, 'Deux frères', 'PNL', 12, 1),
       (2, 5, 'Anarchie', 'SCH', 19, 1),
       (3, 6, 'Jul', 'Loin du monde', 10, 0);

INSERT INTO dvd
VALUES (1, 7, 'Alibi.com', 'Philippe Lacheau', 'TF1 Studio', 1),
       (2, 8, 'Épouse-Moi Mon pote', 'Tarek Boudali', 'Studiocanal', 1),
       (3, 9, 'Cars', 'John Lasseter et Joe Ranft', 'Disney PIXAR', 0);

INSERT INTO magazine
VALUES (1, 10, 'CHEVAL MAGAZINE', 613, '20/01/2023'),
       (2, 11, 'Jeux Vidéo Magazine', 263, '30/11/2022'),
       (3, 12, '30 millions d amis', 414, '01/12/2022');
