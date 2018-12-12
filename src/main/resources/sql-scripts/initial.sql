CREATE DATABASE IF NOT EXISTS conferences;
USE conferences;

CREATE TABLE IF NOT EXISTS users_usr (
  id_usr INT NOT NULL,
  name_usr VARCHAR(45) NOT NULL,
  email_usr VARCHAR(45) NOT NULL,
  role_usr ENUM('USER', 'ADMIN', 'MODER') NOT NULL,
  nickname_usr VARCHAR(45) NULL,
  PRIMARY KEY (id_usr)
) ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS conferences_cf (
  id_cf INT NOT NULL,
  name_cf VARCHAR(45) NOT NULL,
  info_cf TEXT NOT NULL,
  PRIMARY KEY (id_cf)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS reports_rp (
  id_rp INT NOT NULL,
  name_rp VARCHAR(45) NOT NULL,
  info_rp TEXT NOT NULL,
  announcer_info TEXT NOT NULL,
  fk_conference_id INT,
  PRIMARY KEY (id_rp)
  /*FOREIGN KEY (fk_id_cf) REFERENCES conferences_cf(id_cf)*/
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS questions_qs (
  id_qs INT NOT NULL,
  question_qs TEXT NULL,
  answer_qs TEXT NULL,
  rating_qs INT NULL,
  fk_id_rp INT NOT NULL,
  fk_id_usr INT NOT NULL,
  PRIMARY KEY(id_qs)
  /*FOREIGN KEY(fk_id_rp) REFERENCES reports_rp(id_rp),
  FOREIGN KEY(fk_id_usr) REFERENCES users_usr(id_usr)*/
) ENGINE = InnoDB;