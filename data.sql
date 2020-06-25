create database IF NOT EXISTS PersonnelManagement;

use PersonnelManagement;

CREATE TABLE IF NOT EXISTS USER(
	user_id varchar(20) PRIMARY KEY,
	password varchar(20) NOT NULL

);

insert into USER values('root','123456');


    CREATE TABLE IF NOT EXISTS FORM(
	FORM_id INT PRIMARY KEY, 
	FORM_name VARCHAR(5) NOT NULL

);
    insert into FORM values(1,'临时员工');
    insert into FORM values(2,'正式员工');

CREATE TABLE IF NOT EXISTS origin(
	origin_id INT PRIMARY KEY,
	origin_name VARCHAR(5) NOT NULL

);
 insert into origin values (1,"校园招聘");
 insert into origin values (2,'社会招聘');
 insert into origin values (3,'其他');

CREATE TABLE IF NOT EXISTS statu(
	statu_id INT PRIMARY KEY,
	statu_name VARCHAR(10) NOT NULL
);

insert into statu values(1,'试用期');
insert into statu values(2,'正式入职');
insert into statu values(3,'离职');

CREATE TABLE IF NOT EXISTS department(
	department_id INT PRIMARY key,
	department_name VARCHAR(15)
	);

insert into department values(1,"人事部");
insert into department values(2,"战忽部");

CREATE TABLE IF NOT EXISTS job(
	job_id INT PRIMARY key,
	job_name VARCHAR(15),
	current_number INT NOT NULL,
	max_number INT NOT NULL,
	check (current_number<max_number or current_number=max_number),
	UNIQUE(job_id)

) ;

insert into job values(1,"首席执行官",0,1);
insert into job values(2,"艺术总监",0,1);
insert into job values(3,"软件工程师",0,20);
insert into job values(4,"美术设计",0,10);



CREATE TABLE IF NOT EXISTS staff(
	SID INT PRIMARY KEY AUTO_INCREMENT,
	SEX VARCHAR(1)  NOT NULL,
	NAME VARCHAR(20) NOT NULL,
	BIRTHDAY DATE NOT NULL,
	ID_NO char(18) NOT NULL,
	origin_id INT NOT NULL,#外码关联来 
	FORM_id INT NOT NULL,  #外码关联形式 
	department_id INT NOT NULL, #外码关联部门 
	job_id INT NOT NULL,     #外码关联岗位 
	statu_id INT NOT NULL,
	check(SEX in('男','女')
	 AND length(ID_NO)=18 
	 AND NOT ID_NO REGEXP '[^0-9.]'),#约束身份证只能使2代18位且只能使数字 
	FOREIGN KEY (origin_id) REFERENCES origin(origin_id),
	FOREIGN KEY (job_id) REFERENCES job(job_id),
	FOREIGN KEY (department_id) REFERENCES department(department_id),
	FOREIGN KEY (FORM_id) REFERENCES FORM(FORM_id),
	FOREIGN KEY (statu_id) REFERENCES statu(statu_id)

	);
alter table staff AUTO_INCREMENT=10000;

insert INTO staff values(0,"男","叶良辰","1980-5-14","456987198005144073",3,2,1,1,2);


CREATE TABLE IF NOT EXISTS TEST_USE(
	SID INT PRIMARY KEY,
	START_TIME DATETIME NOT NULL,
	LAST INT NOT NULL,
	END_TIME DATETIME,
	FOREIGN KEY (SID) REFERENCES staff(SID)
);

CREATE TABLE IF NOT EXISTS staff_statu(
	SID INT NOT NULL,
	statu_id INT NOT NULL,
	START_TIME DATETIME NOT NULL,
	END_TIME DATETIME,
	PRIMARY KEY(SID,START_TIME),
	FOREIGN KEY (SID) REFERENCES staff(SID),
	FOREIGN KEY (statu_id) REFERENCES statu(statu_id)
);

CREATE TABLE IF NOT EXISTS department_move(
	SID INT NOT NULL,
	department_id INT NOT NULL,
	move_time DATETIME NOT NULL,
	PRIMARY KEY (SID,move_time),
	FOREIGN KEY (SID) REFERENCES staff(SID),
	FOREIGN KEY (department_id) REFERENCES department(department_id)

);

CREATE TABLE IF NOT EXISTS job_move(
	SID INT NOT NULL,
	job_id INT NOT NULL,
	move_time DATETIME NOT NULL,
	PRIMARY KEY (SID,move_time),
	FOREIGN KEY (SID) REFERENCES staff(SID),
	FOREIGN KEY (job_id) REFERENCES job(job_id)

);


delimiter $$
CREATE procedure insert_staff(IN sid INT,sex varchar(1),name varchar(20),BIRTHDAY DATE,
ID_NO char(18),origin_id INT,FORM_id INT, department_id INT, job_id INT,statu_id INT)
begin
declare erro INT;
declare continue handler for sqlexception set erro=1;
start transaction;
     insert INTO staff values(sid,sex,name,BIRTHDAY,ID_NO,origin_id,FORM_id,department_id,job_id,statu_id); 
     insert into staff_statu(sid,statu_id,START_TIME) values(sid,statu_id,now());
     	IF(erro=1) then
     	rollback;
     	else
     	commit;
     	end IF;
end$$
delimiter ;

call insert_staff(10001,"女",'颜玉书','1995-4-23','430304199504232106',1,2,2,2,2);



select sid,sex,name,BIRTHDAY,ID_NO,origin_name,FORM_name,department_name,job_name,statu_name
from staff,origin,FORM,department,job,statu
where staff.origin_id=origin.origin_id AND
staff.FORM_id=FORM.FORM_id AND 
staff.department_id=department.department_id AND
staff.job_id=job.job_id AND
staff.statu_id=statu.statu_id;