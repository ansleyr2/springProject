CREATE TABLE WORD(
	word_id bigint AUTO_INCREMENT PRIMARY KEY,
	word varchar(100) not null,
	meaning varchar(200) not null,
	sentence varchar(3000) not null,
	created_date date
);