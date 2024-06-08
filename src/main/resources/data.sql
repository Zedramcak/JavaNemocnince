CREATE TABLE IF NOT EXISTS specialization (
                                id SERIAL PRIMARY KEY,
                                name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS operatingRoom (
                               id SERIAL PRIMARY KEY,
                               title VARCHAR(50) NOT NULL,
                               idSpecialization INT REFERENCES specialization(id)
);

CREATE TABLE IF NOT EXISTS doctor (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        idSpecialization INT REFERENCES specialization(id),
                        shifts VARCHAR()
);

CREATE TABLE IF NOT EXISTS patient (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         surname VARCHAR(100) NOT NULL,
                         insurance VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
                        id SERIAL PRIMARY KEY,
                        idPatient INT REFERENCES patient(id),
                        workingTime VARCHAR() NOT NULL,
                        idDoctor INT REFERENCES doctor(id),
                        idOperatingRoom INT REFERENCES operatingRoom(id)
);


INSERT INTO specialization (name)
VALUES
    ('Orthopedics'),
    ('Pediatrics'),
    ('Neurology'),
    ('Cardiology');

INSERT INTO operatingRoom (id, title, idSpecialization)
VALUES
    (1, 'Room 1', 1),
    (2, 'Room 2', 2),
    (3, 'Room 3', 3),
    (4, 'Room 4', 4);

INSERT INTO doctor (id, name, idSpecialization, shifts)
VALUES
    (1, 'Dr. John Smith', 4, '6|7|8|17!6|8|8|17!6|9|8|17'),
    (2, 'Dr. Emily Johnson', 3, '6|7|8|17!6|8|8|17!6|9|8|17'),
    (3, 'Dr. Michael Williams', 1, '6|7|8|17!6|8|8|17!6|9|8|17'),
    (4, 'Dr. Sarah Brown', 2, '6|7|8|17!6|8|8|17!6|9|8|17');

INSERT INTO patient (id, name, surname, insurance)
VALUES
    (1, 'Alice', 'Johnson', 'XYZ Insurance'),
    (2, 'Bob', 'Smith', 'ABC Insurance'),
    (3, 'Charlie', 'Brown', 'DEF Insurance'),
    (4, 'Diana', 'Williams', 'GHI Insurance');

INSERT INTO orders (id, idPatient, workingTtime, idDoctor, idOperatingRoom)
VALUES
    (1, 1, '6|8|8|10', 1, 1),
    (2, 2, '6|8|14|16', 2, 2),
    (3, 3, '6|8|10|12', 3, 3),
    (4, 2, '6|8|16|17', 4, 4);