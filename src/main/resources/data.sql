CREATE TABLE IF NOT EXISTS specialization (
                                id SERIAL PRIMARY KEY,
                                name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS operatingRoom (
                               id SERIAL PRIMARY KEY,
                               title VARCHAR(50) NOT NULL,
                               idSpecialization INT REFERENCES specialization(id),
                               occupied TSRANGE[]
);

CREATE TABLE IF NOT EXISTS doctor (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        idSpecialization INT REFERENCES specialization(id),
                        shifts TSRANGE[],
                        busyness TSRANGE[]
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
                        time TIMESTAMPTZ NOT NULL,
                        idDoctor INT REFERENCES doctor(id),
                        idOperatingRoom INT REFERENCES operatingRoom(id)
);


/*INSERT INTO specialization (name)
VALUES
    ('Orthopedics'),
    ('Pediatrics'),
    ('Neurology'),
    ('Cardiology');

INSERT INTO operatingRoom (id, title, idSpecialization, occupied)
VALUES
    (1, 'Room 1', 1, ARRAY[tsrange('2024-06-10 08:00:00', '2024-06-10 10:00:00'), tsrange('2024-06-10 14:00:00', '2024-06-10 16:00:00')]),
    (2, 'Room 2', 2, ARRAY[tsrange('2024-06-10 10:00:00', '2024-06-10 12:00:00'), tsrange('2024-06-10 16:00:00', '2024-06-10 18:00:00')]),
    (3, 'Room 3', 3, ARRAY[tsrange('2024-06-10 08:00:00', '2024-06-10 20:00:00')]),
    (4, 'Room 4', 4, ARRAY[tsrange('2024-06-10 08:00:00', '2024-06-10 20:00:00')]);

INSERT INTO doctor (id, name, idSpecialization, shifts, busyness)
VALUES
    (1, 'Dr. John Smith', 4, ARRAY[tsrange('2024-06-10 14:00:00', '2024-06-10 16:00:00')], ARRAY[tsrange('2024-06-10 14:00:00', '2024-06-10 15:00:00')]),
    (2, 'Dr. Emily Johnson', 3, ARRAY[tsrange('2024-06-10 08:00:00', '2024-06-10 10:00:00'), tsrange('2024-06-10 14:00:00', '2024-06-10 16:00:00')], ARRAY[]::TSRANGE[]),
    (3, 'Dr. Michael Williams', 1, ARRAY[tsrange('2024-06-10 08:00:00', '2024-06-10 10:00:00')], ARRAY[tsrange('2024-06-10 08:00:00', '2024-06-10 09:00:00')]),
    (4, 'Dr. Sarah Brown', 2, ARRAY[tsrange('2024-06-10 08:00:00', '2024-06-10 10:00:00'), tsrange('2024-06-10 14:00:00', '2024-06-10 16:00:00')], ARRAY[]::TSRANGE[]);

INSERT INTO patient (id, name, surname, insurance)
VALUES
    (1, 'Alice', 'Johnson', 'XYZ Insurance'),
    (2, 'Bob', 'Smith', 'ABC Insurance'),
    (3, 'Charlie', 'Brown', 'DEF Insurance'),
    (4, 'Diana', 'Williams', 'GHI Insurance');

INSERT INTO orders (id, idPatient, time, idDoctor, idOperatingRoom)
VALUES
    (1, 1, TIMESTAMPTZ '2024-06-10 10:00:00+00', 1, 1),
    (2, 2, TIMESTAMPTZ '2024-06-15 14:00:00+00', 2, 2),
    (3, 3, TIMESTAMPTZ '2024-06-20 08:00:00+00', 3, 3),
    (4, 2, TIMESTAMPTZ '2024-06-25 10:00:00+00', 4, 4);*/