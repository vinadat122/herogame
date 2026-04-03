DROP DATABASE IF EXISTS HeroGame;
CREATE DATABASE HeroGame;
USE HeroGame;

CREATE TABLE National (
    NationalId INT AUTO_INCREMENT,
    NationalName VARCHAR(100),
    PRIMARY KEY (NationalId)
);

CREATE TABLE Player (
    PlayerId INT,
    NationalId INT,
    PlayerName VARCHAR(100),
    HighScore INT,
    Level INT,
    PRIMARY KEY (PlayerId, NationalId),
    FOREIGN KEY (NationalId) REFERENCES National(NationalId)
);

INSERT INTO National (NationalName) VALUES
('Vietnam'), ('USA'), ('Japan');

INSERT INTO Player VALUES
(1, 1, 'Player 1', 100, 2),
(2, 2, 'Player 2', 1050, 10),
(3, 3, 'Player 3', 200, 5);
