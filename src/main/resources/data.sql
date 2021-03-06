DROP TABLE IF EXISTS HASHBLOCKS;

CREATE TABLE HASHBLOCKS (
  ID INT NOT NULL AUTO_INCREMENT,
  HASHDATA VARCHAR(255) NOT NULL,
  PARENTHASH VARCHAR(255) NOT NULL,
  CAPTIONDATA VARCHAR(255),
  NONCE INT NOT NULL,
  WORKPROVEN BIT,
  BLOCKTIME BIGINT,
  PRIMARY KEY (ID)
);

INSERT INTO HASHBLOCKS (ID, HASHDATA, PARENTHASH, CAPTIONDATA, NONCE, WORKPROVEN, BLOCKTIME) VALUES
  (1, '00000000000', '0000', 'test caption', 0, 0, 101010)