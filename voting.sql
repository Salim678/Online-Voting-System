
-- MySQL schema for Online Voting System
CREATE DATABASE IF NOT EXISTS online_voting;
USE online_voting;

CREATE TABLE IF NOT EXISTS voters (
  voter_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS candidates (
  candidate_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  party VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS elections (
  election_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(150) NOT NULL,
  start_date DATE,
  end_date DATE
);

CREATE TABLE IF NOT EXISTS votes (
  vote_id INT AUTO_INCREMENT PRIMARY KEY,
  voter_id INT NOT NULL,
  candidate_id INT NOT NULL,
  election_id INT NOT NULL,
  cast_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY unique_vote (voter_id, election_id),
  FOREIGN KEY (voter_id) REFERENCES voters(voter_id),
  FOREIGN KEY (candidate_id) REFERENCES candidates(candidate_id),
  FOREIGN KEY (election_id) REFERENCES elections(election_id)
);

-- sample data
INSERT INTO voters (name, email, password) VALUES
('Alice', 'alice@example.com', 'pass123'),
('Bob', 'bob@example.com', 'pass123');

INSERT INTO candidates (name, party) VALUES
('John Doe', 'Party A'),
('Jane Smith', 'Party B');

INSERT INTO elections (title, start_date, end_date) VALUES
('Student Council 2025', '2025-11-01', '2025-12-01');
