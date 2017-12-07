CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`login`)
);

CREATE TABLE notes (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  notebook_id INT,
  content TIMESTAMP NOT NULL,
  date TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE notebooks (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
)

CREATE TABLE tags (
  id INT NOT NULL AUTO_INCREMENT,
  name  VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
)

CREATE TABLE notesTags (
  id INT NOT NULL AUTO_INCREMENT,
  note_id INT NOT NULL,
  tag_id  INT NOT NULL,
  PRIMARY KEY (`id`)
)