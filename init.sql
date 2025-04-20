use torneo;

SET NAMES utf8mb4;

create table players
(
    dni           char(13) primary key,
    name          varchar(50)  not null,
    l_name1       varchar(50)  not null,
    l_name2       varchar(50),
    email         varchar(255) not null,
    phone         char(13)     not null,
    team_name     varchar(150),
    date_of_birth date         not null,
    user_name     varchar(50)
);

create table team
(
    name          varchar(150) primary key,
    creation_date date not null
);

INSERT INTO team (name, creation_date) VALUES
    ('Los Halcones', '2020-05-15'),
    ('Dragones Voladores', '2019-03-22'),
    ('Tigres del Norte', '2021-01-10'),
    ('Águilas Rojas', '2018-11-30'),
    ('Leones del Sur', '2022-07-05');


INSERT INTO players (dni, name, l_name1, l_name2, email, phone, team_name, date_of_birth, user_name)
VALUES ('001-1234567-8', 'Juan', 'Pérez', 'Gómez', 'juan.perez@email.com', '809-555-1234', 'Los Halcones', '1995-08-12',
        'juanpg'),
       ('002-2345678-9', 'María', 'Rodríguez', 'López', 'maria.rl@email.com', '809-555-2345', 'Dragones Voladores',
        '1998-03-25', 'mariarl'),
       ('003-3456789-0', 'Carlos', 'Martínez', NULL, 'carlos.mtz@email.com', '829-555-3456', 'Tigres del Norte',
        '1992-11-05', 'carlosm'),
       ('004-4567890-1', 'Ana', 'García', 'Sánchez', 'ana.gs@email.com', '809-555-4567', 'Águilas Rojas', '1997-07-19',
        'anags'),
       ('005-5678901-2', 'Luis', 'Hernández', 'Díaz', 'luis.hd@email.com', '829-555-5678', 'Leones del Sur',
        '1994-09-30', 'luishd'),
       ('006-6789012-3', 'Sofía', 'Torres', 'Jiménez', 'sofia.tj@email.com', '809-555-6789', 'Los Halcones',
        '1999-02-14', 'sofiatj'),
       ('007-7890123-4', 'Pedro', 'Ramírez', 'Fernández', 'pedro.rf@email.com', '829-555-7890', 'Dragones Voladores',
        '1993-12-08', 'pedrorf'),
       ('008-8901234-5', 'Laura', 'Díaz', 'Vargas', 'laura.dv@email.com', '809-555-8901', 'Tigres del Norte',
        '1996-04-21', 'lauradv'),
       ('009-9012345-6', 'Jorge', 'Morales', 'Pérez', 'jorge.mp@email.com', '829-555-9012', 'Águilas Rojas',
        '1991-10-17', 'jorgemp'),
       ('010-0123456-7', 'Elena', 'Castillo', 'Reyes', 'elena.cr@email.com', '809-555-0123', 'Leones del Sur',
        '2000-06-28', 'elenacr');