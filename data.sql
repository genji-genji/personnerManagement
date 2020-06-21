create database IF NOT EXISTS PersonnelManagement;

use PersonnelManagement;


    CREATE TABLE IF NOT EXISTS FORM(
	FORM_id INT PRIMARY KEY,
	FORM_name VARCHAR(5) NOT NULL

);

CREATE TABLE IF NOT EXISTS origin(
	origin_id INT PRIMARY KEY,
	origin_name VARCHAR(5) NOT NULL

);

CREATE TABLE IF NOT EXISTS statu(
	statu_id INT PRIMARY KEY,
	statu_name VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS department(
	department_id INT PRIMARY key,
	department_name VARCHAR(15)
	);

CREATE TABLE IF NOT EXISTS job(
	job_id INT PRIMARY key,
	job_name VARCHAR(15),
	current_number INT NOT NULL,
	max_number INT NOT NULL,
	check (current_number<max_number or current_number=max_number),
	UNIQUE(job_id)

) ;

CREATE TABLE IF NOT EXISTS staff(
	SID INT PRIMARY KEY AUTO_INCREMENT,
	SEX VARCHAR(1)  NOT NULL,
	NAME VARCHAR(20) NOT NULL,
	BIRTHDAY DATE NOT NULL,
	ID_NO char(18) NOT NULL,
	origin_id INT NOT NULL,
	job_id INT NOT NULL,
	check(SEX in('男','女')
	 AND length(ID_NO)=18 
	 AND not ID_NO REGEXP '[^0-9.]'),
	FOREIGN KEY (origin_id) REFERENCES origin(origin_id),
	FOREIGN KEY (job_id) REFERENCES job(job_id)

	);
alter table staff AUTO_INCREMENT=10000;
