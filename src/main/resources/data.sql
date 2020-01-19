drop table if exists users;

CREATE TABLE users
(
    id integer NOT NULL,
	city VARCHAR(128) NOT NULL,
	fname VARCHAR(128) NOT NULL,
	sname VARCHAR(128) NOT NULL,
	user_tel integer NOT NULL,
    date_add VARCHAR(128)NOT NULL,
    login VARCHAR(50) NOT NULL,
    pass VARCHAR(50) NOT NULL,
    email VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);
select * from users;

drop table if exists books;

CREATE TABLE books
(
    book_id VARCHAR(128)  NOT NULL,
	title VARCHAR(128) NOT NULL,
	author VARCHAR(128) NOT NULL,
	price integer NOT NULL,
	description VARCHAR(128) NOT NULL,
    rdate VARCHAR(128)NOT NULL,

    PRIMARY KEY (book_id)
);
select * from books;

drop table if exists orders;

CREATE TABLE orders
(
    order_id VARCHAR(128)  NOT NULL,
	order_date VARCHAR(128) NOT NULL,
	quantity integer NOT NULL,
	price integer NOT NULL,
	status VARCHAR(128) NOT NULL,
    invoice VARCHAR(128)NOT NULL,

    PRIMARY KEY (order_id)
);
select * from orders;