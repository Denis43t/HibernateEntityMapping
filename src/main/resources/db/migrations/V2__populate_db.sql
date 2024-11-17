INSERT INTO Client (name)
VALUES ('Alice Smith'),
       ('Bob Johnson'),
       ('Charlie Brown'),
       ('Diana Prince'),
       ('Edward King'),
       ('Fiona Queen'),
       ('George Baker'),
       ('Helen Star'),
       ('Ivan Turner'),
       ('Jasmine Collins');

INSERT INTO Planet (id, name)
VALUES ('MARS', 'Mars'),
       ('VENUS', 'Venus'),
       ('EARTH', 'Earth'),
       ('JUPITER', 'Jupiter'),
       ('SATURN', 'Saturn');
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id)
VALUES (1, 'EARTH', 'MARS'),
       (2, 'MARS', 'VENUS'),
       (3, 'VENUS', 'JUPITER'),
       (4, 'JUPITER', 'SATURN'),
       (5, 'SATURN', 'EARTH'),
       (6, 'EARTH', 'VENUS'),
       (7, 'VENUS', 'MARS'),
       (8, 'JUPITER', 'EARTH'),
       (9, 'SATURN', 'MARS'),
       (10, 'MARS', 'JUPITER');