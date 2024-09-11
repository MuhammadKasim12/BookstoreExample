CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    price DECIMAL(10, 2)
);

INSERT INTO book(id,title, author,price) VALUES
(1, 'Book1' ,'Kasim', 10.99),
(2, 'Book2' ,'Tharik', 9.99),
(3, 'Book3' ,'Saddam', 11.99),
(4, 'Book4' ,'Shaik', 6.99);