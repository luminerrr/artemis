CREATE TABLE authors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT,
    description TEXT
);


CREATE TABLE genres (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);


CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id INT REFERENCES authors(id),
    genre_id INT references genres(id)
);

ALTER TABLE books
ADD COLUMN isbn VARCHAR(20) NOT NULL;

ALTER TABLE books
ADD COLUMN published_date DATE;

alter table books
rename publisheddate to published_date

alter table authors rename description to bio

alter table authors drop age

alter table genres drop description

insert into genres (
name 
) values (
'blenger'
)