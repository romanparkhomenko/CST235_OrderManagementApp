-- SQL Statement to create app schema:
DROP TABLE IF EXISTS app.Products;
DROP SCHEMA IF EXISTS app RESTRICT;
CREATE SCHEMA app;

-- SQL Statement to create products table:
CREATE TABLE app.Products
		(
			ID SERIAL PRIMARY KEY,
			PRODUCT_NAME VARCHAR(128) NOT NULL,
			QUANTITY INTEGER NOT NULL,
			COST FLOAT NOT NULL,
			DESCRIPTION VARCHAR(250) NOT NULL
		);

-- Insert first generic item into database
INSERT INTO app.Products(PRODUCT_NAME, QUANTITY, COST, DESCRIPTION) 
VALUES('Alienware 17', '11', 1500.00, 'The best gaming laptop the dell has to offer.');

-- Print all rows to database:
SELECT * FROM app.Products;