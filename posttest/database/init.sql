DROP TABLE IF EXISTS lottery;
DROP TABLE IF EXISTS user_ticket;

CREATE TABLE lottery (
  ticket_no VARCHAR(6) PRIMARY KEY,
  price DECIMAL NOT NULL,
  amount INT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_ticket (
  id SERIAL PRIMARY KEY,
  ticket_no VARCHAR(6) NOT NULL,
  user_id INT NOT NULL,
  price_paid DECIMAL NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (ticket_no) REFERENCES lottery(ticket_no)
);

CREATE INDEX ON lottery (ticket_no);
CREATE INDEX ON user_ticket (user_id);
