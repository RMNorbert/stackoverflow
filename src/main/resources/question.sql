CREATE TABLE question(question_id serial PRIMARY KEY ,author VARCHAR(50),  title VARCHAR(100) NOT NULL, description TEXT, created TIMESTAMP NOT NULL);
CREATE TABLE answer(answer_id serial PRIMARY KEY ,question_id INT NOT NULL , description TEXT NOT NULL, created TIMESTAMP NOT NULL);
CREATE TABLE user(id serial PRIMARY KEY , status VARCHAR(50), name VARCHAR(50) NOT NULL , password VARCHAR NOT NULL, registration_date TIMESTAMP, number_of_questions INT NOT NUll, number_of_answers INT NOT NULL);
