CREATE TABLE operatingRoom (
                               id SERIAL PRIMARY KEY,
                               title VARCHAR(50) NOT NULL,
                               specialization VARCHAR(50) NOT NULL,
                               occupied TIMESTAMPTZ[]
);

CREATE TABLE doctor (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        specialization VARCHAR(50) NOT NULL,
                        shifts TIMESTAMPTZ[],
                        busyness TIMESTAMPTZ[]
);

CREATE TABLE patient (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         surname VARCHAR(100) NOT NULL,
                         insurance VARCHAR(100) NOT NULL
);

CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        idPatient INT REFERENCES patient(id),
                        time TIMESTAMPTZ NOT NULL,
                        idDoctor INT REFERENCES doctor(id),
                        idOperatingRoom INT REFERENCES operatingRoom(id)
);


INSERT INTO operatingRoom (id, title, specialization, occupied)
VALUES
    (1, 'Room 1', 'Orthopedics', ['2024-06-10 08:00-2024-06-10 10:00', '2024-06-10 14:00-2024-06-10 16:00']),
    (2, 'Room 2', 'pediatrics', ['2024-06-10 10:00-2024-06-10 12:00', '2024-06-10 16:00-2024-06-10 18:00']),
    (3, 'Room 3', 'Neurology', ['2024-06-10 08:00-2024-06-10 20:00']),
    (4, 'Room 4', 'Cardiology', ['2024-06-10 08:00-2024-06-10 20:00']);

INSERT INTO doctor (id, name, specialization, shifts, busyness)
VALUES
    (1, 'Dr. John Smith', 'Cardiology', ['2024-06-10 14:00:00-2024-06-10 16:00:00'], ['2024-06-10 14:00:00-2024-06-10 15:00:00']),
    (2, 'Dr. Emily Johnson', 'Neurology', ['2024-06-10 08:00:00-2024-06-10 10:00:00', '2024-06-10 14:00:00-2024-06-10 16:00:00'], []),
    (3, 'Dr. Michael Williams', 'Orthopedics', ['2024-06-10 08:00:00-2024-06-10 10:00:00'], ['2024-06-10 08:00:00-2024-06-10 09:00:00']),
    (4, 'Dr. Sarah Brown', 'Pediatrics', ['2024-06-10 08:00:00-2024-06-10 10:00:00', '2024-06-10 14:00:00-2024-06-10 16:00:00'], []);

INSERT INTO patient (id, name, surname, insurance)
VALUES
    (1, 'Alice', 'Johnson', 'XYZ Insurance'),
    (2, 'Bob', 'Smith', 'ABC Insurance'),
    (3, 'Charlie', 'Brown', 'DEF Insurance'),
    (4, 'Diana', 'Williams', 'GHI Insurance');

INSERT INTO orders (id, idPatient, time, idDoctor, idOperatingRoom)
VALUES
    (1, 1, '2024-06-10 10:00:00', 1, 1),
    (2, 2, '2024-06-15 14:00:00', 2, 2),
    (3, 3, '2024-06-20 08:00:00', 3, 3),
    (4, 2, '2024-06-25 10:00:00', 4, 4);
