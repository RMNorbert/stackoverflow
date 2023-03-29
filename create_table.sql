CREATE TABLE question(question_id serial PRIMARY KEY, user_id INT NOT NULL , title VARCHAR NOT NULL, description TEXT, created DATE NOT NULL);
CREATE TABLE answer(answer_id serial PRIMARY KEY ,question_id INT NOT NULL, user_id INT NOT NULL,  description TEXT NOT NULL, created DATE NOT NULL);
CREATE TABLE "user"(id serial PRIMARY KEY , status VARCHAR, name VARCHAR NOT NULL , password VARCHAR NOT NULL, registration_date DATE, number_of_questions INT NOT NUll, number_of_answers INT NOT NULL);

