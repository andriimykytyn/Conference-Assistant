CREATE DATABASE IF NOT EXISTS conferences;
USE conferences;

CREATE TABLE IF NOT EXISTS users (
  user_id INT NOT NULL,
  user_name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  role ENUM('USER', 'ADMIN', 'MODER') NOT NULL,
  surname VARCHAR(45) NULL,
  nickname VARCHAR(45) NULL,
  PRIMARY KEY (user_id)
) ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS conferences (
  conference_id INT NOT NULL,
  conference_name VARCHAR(45) NOT NULL,
  conference_info TEXT NOT NULL,
  PRIMARY KEY (conference_id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS reports (
  report_id INT NOT NULL,
  report_name VARCHAR(45) NOT NULL,
  announcer_info TEXT NOT NULL,
  fk_conference_id INT NOT NULL,
  PRIMARY KEY (report_id),
  FOREIGN KEY (fk_conference_id) REFERENCES conferences(conference_id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS questions (
  question_id INT NOT NULL,
  question TEXT NULL,
  answer TEXT NULL,
  rating INT NULL,
  fk_report_id INT NOT NULL,
  fk_user_id INT NOT NULL,
  PRIMARY KEY(question_id),
  FOREIGN KEY(fk_report_id) REFERENCES reports(report_id),
  FOREIGN KEY(fk_user_id) REFERENCES users(user_id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS users_has_conferences (
  users_id_user INT NOT NULL,
  conferences_id_conference INT NOT NULL,
  PRIMARY KEY (users_id_user, conferences_id_conference),
  FOREIGN KEY (users_id_user) REFERENCES users(user_id),
  FOREIGN KEY (conferences_id_conference) REFERENCES conferences(conference_id)
) ENGINE = InnoDB;