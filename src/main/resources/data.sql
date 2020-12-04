DROP TABLE IF EXISTS blocks;

CREATE TABLE blocks (
  id INT AUTO_INCREMENT,
  hashData VARCHAR(255) NOT NULL,
  parentHash VARCHAR(255) NOT NULL,
  captionData VARCHAR(255),
  PRIMARY KEY (id)
);

INSERT INTO blocks (ID, hashData, parentHash, captionData) VALUES
  (1, 'testHash', '0000', 'test caption')