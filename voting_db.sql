CREATE DATABASE IF NOT EXISTS voting_db;
USE voting_db;

CREATE TABLE voters (
    voter_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin', 'voter') DEFAULT 'voter',
    has_voted TINYINT(1) DEFAULT 0,

    CONSTRAINT uq_voter_email UNIQUE (email),
    CONSTRAINT chk_has_voted CHECK (has_voted IN (0,1))
);

CREATE TABLE candidates (
    candidate_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    party VARCHAR(100) NOT NULL
);

CREATE TABLE votes (
    vote_id INT AUTO_INCREMENT PRIMARY KEY,
    voter_id INT NOT NULL,
    candidate_id INT NOT NULL,

    CONSTRAINT fk_vote_voter
        FOREIGN KEY (voter_id)
        REFERENCES voters(voter_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_vote_candidate
        FOREIGN KEY (candidate_id)
        REFERENCES candidates(candidate_id)
        ON DELETE CASCADE,

    CONSTRAINT uq_one_vote_per_voter UNIQUE (voter_id)
);
