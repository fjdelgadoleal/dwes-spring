CREATE DATABASE spring5app;

GRANT ALL ON spring5app.* TO spring5appuser@'%' IDENTIFIED BY 'pspring5appuser';
GRANT ALL ON spring5app.* TO spring5appuser@localhost IDENTIFIED BY 'pspring5appuser';

USE spring5app;

CREATE TABLE products (
  id INTEGER PRIMARY KEY,
  description varchar(255),
  price decimal(15,2)
);
CREATE INDEX products_description ON products(description);