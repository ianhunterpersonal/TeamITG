CREATE TABLE USERS (
	id VARCHAR(100) PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	login_token VARCHAR(255)
);

