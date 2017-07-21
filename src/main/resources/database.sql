CREATE TABLE list (
  id          INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(255) NOT NULL,
  created     DATE         NOT NULL,
  prioroty    INT          NOT NULL,
  due_date    DATE         NOT NULL
)
