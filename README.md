# taskmanagement

Task Management System





hi all

#SQL Queries for table creation

create table project(id int primary key auto_increment,project_name varchar(50),project_desc varchar(200),created_on datetime,created_by varchar(20),updated_on datetime,updated_by varchar(20));


create table module(id int primary key auto_increment,module_name varchar(50),module_desc varchar(200),created_on datetime,created_by varchar(20),updated_on datetime,updated_by varchar(20));

create table project_module(id int primary key auto_increment,project_id int,module_id int,created_on datetime,created_by varchar(20),updated_on datetime,updated_by varchar(20));

create table address(id int primary key auto_increment,address_type varchar(10),address_line1 varchar(50),address_line2 varchar(50),city varchar(50),state varchar(30),zipcode varchar(10),created_on datetime,created_by varchar(20),updated_on datetime,updated_by varchar(20));


CREATE TABLE `tmsdb`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NULL,
  `first_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NULL,
  `designation` VARCHAR(50) NULL,
  `department` VARCHAR(50) NULL,
  `phone` VARCHAR(20) NULL,
  `email_address` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  INDEX `address_id_idx` (`address_id` ASC),
  CONSTRAINT `address_id`
    FOREIGN KEY (`address_id`)
    REFERENCES `tmsdb`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `tmsdb`.`employee` 
ADD COLUMN `created_by` VARCHAR(20) NULL AFTER `email_address`,
ADD COLUMN `created_on` DATETIME NULL AFTER `created_by`,
ADD COLUMN `updated_by` VARCHAR(20) NULL AFTER `created_on`,
ADD COLUMN `updated_on` DATETIME NULL AFTER `updated_by`;
CREATE TABLE `tmsdb`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NULL,
  `role_description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
ALTER TABLE `tmsdb`.`role` 
ADD COLUMN `created_by` VARCHAR(20) NULL AFTER `role_description`,
ADD COLUMN `created_on` DATETIME NULL AFTER `created_by`,
ADD COLUMN `updated_by` VARCHAR(20) NULL AFTER `created_on`,
ADD COLUMN `updated_on` DATETIME NULL AFTER `updated_by`;

CREATE TABLE `tmsdb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `emp_id` INT NULL,
  `user_name` VARCHAR(50) NULL,
  `password` VARCHAR(45) NULL,
  `is_active` TINYINT NULL,
  `created_by` VARCHAR(20) NULL,
  `created_on` DATETIME NULL,
  `updated_by` VARCHAR(20) NULL,
  `updated_on` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emp_id_idx` (`emp_id` ASC),
  CONSTRAINT `fk_emp_id`
    FOREIGN KEY (`emp_id`)
    REFERENCES `tmsdb`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

create table user_role(id int primary key auto_increment,user_id int,role_id int,created_on datetime,created_by varchar(20),updated_on datetime,updated_by varchar(20));


CREATE TABLE `tmsdb`.`task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `project_id` INT NULL,
  `module_id` INT NULL,
  `task_description` VARCHAR(200) NULL,
  `actual_start_date` DATETIME NULL,
  `actual_end_date` DATETIME NULL,
  `expected_start_date` DATETIME NULL,
  `expected_end_date` DATETIME NULL,
  `status` VARCHAR(20) NULL,
  `reason` VARCHAR(250) NULL,
  `assigned_to` VARCHAR(50) NULL,
  `assigned_by` VARCHAR(50) NULL,
  `created_on` DATETIME NULL,
  `created_by` VARCHAR(20) NULL,
  `updated_on` DATETIME NULL,
  `updated_by` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  
  #SQL queries for table entries
  
  #Address
INSERT INTO address (address_type ,address_line1 ,address_line2 ,city ,state ,zipcode)
VALUES ('Present', 'Ram Nagar','Kailashpuram', 'Madurai', 'TamilNadu','625070');

INSERT INTO address (address_type ,address_line1 ,address_line2 ,city ,state ,zipcode)
VALUES ('Permanent', 'Anna Nagar','', 'Madurai', 'TamilNadu','625020');

INSERT INTO address (address_type ,address_line1 ,address_line2 ,city ,state ,zipcode)
VALUES ('Permanent', 'KK Nagar','', 'Madurai', 'TamilNadu','625023');

INSERT INTO address (address_type ,address_line1 ,address_line2 ,city ,state ,zipcode)
VALUES ('Present', 'Anna Nagar','', 'Chennai', 'TamilNadu','600017');

INSERT INTO address (address_type ,address_line1 ,address_line2 ,city ,state ,zipcode)
VALUES ('Permanent', 'Lakhmi Nagar','Porur', 'Chennai', 'TamilNadu','600027');

#Employee

INSERT INTO employee (`address_id`,`first_name`,`last_name`,`designation`,`department`,`phone`,`email_address`)
VALUES (1,'Srilekha','Vasanth','Analyst','Development','9874563210','srilekha.vasanth@gmail.com');

INSERT INTO employee (`address_id`,`first_name`,`last_name`,`designation`,`department`,`phone`,`email_address`)
VALUES (1,'Vasanth','Prabhakar','Project Manager','Development','8745632109','vasanth.prabhakar@gmail.com');

INSERT INTO employee (`address_id`,`first_name`,`last_name`,`designation`,`department`,`phone`,`email_address`)
VALUES (2,'Guru','','Software Engineer','Development','7456321089','guru123@gmail.com');

INSERT INTO employee (`address_id`,`first_name`,`last_name`,`designation`,`department`,`phone`,`email_address`)
VALUES (2,'Vinay','','Technical Lead','Development','7896541230','clicktovinay@gmail.com');

INSERT INTO employee (`address_id`,`first_name`,`last_name`,`designation`,`department`,`phone`,`email_address`)
VALUES (3,'Pavithra','Raghavan','Trainee','Support','8520147963','pavithra.raghavan@gmail.com');

INSERT INTO employee (`address_id`,`first_name`,`last_name`,`designation`,`department`,`phone`,`email_address`)
VALUES (3,'Manisha','Raghavan','Trainee','Development','8965471230','manisha.raghavan@gmail.com');

INSERT INTO employee (`address_id`,`first_name`,`last_name`,`designation`,`department`,`phone`,`email_address`)
VALUES (4,'Kavin','Kumar','Senior Software Engineer','Support','7441025896','kavin.kumar@gmail.com');

INSERT INTO employee (`address_id`,`first_name`,`last_name`,`designation`,`department`,`phone`,`email_address`)
VALUES (4,'Ragu','Ram','Senior Software Engineer','Development','8899654712','ragu.ram@gmail.com');

INSERT INTO employee (`address_id`,`first_name`,`last_name`,`designation`,`department`,`phone`,`email_address`)
VALUES (5,'Vanthana','','Senior Associate','Testing','7745112369','vanthana95@gmail.com');

INSERT INTO employee (`address_id`,`first_name`,`last_name`,`designation`,`department`,`phone`,`email_address`)
VALUES (5,'Mathi','','Senior Associate','Testing','9963258741','mathicse@gmail.com');

#Role

INSERT INTO role (`role_name`,`role_description`)
VALUES ('Project Manager','Manages project procedures,mapps resource to modules');

INSERT INTO role (`role_name`,`role_description`)
VALUES ('Developer','Works on tasks and reports the task completion');

#User

INSERT INTO user (`emp_id`,`user_name`,`password`,`is_active`)
VALUES (1,'srilekha.vasanth@gmail.com','analyst@123',1);

INSERT INTO user (`emp_id`,`user_name`,`password`,`is_active`)
VALUES (2,'vasanth.prabhakar@gmail.com','manager@123',1);

INSERT INTO user (`emp_id`,`user_name`,`password`,`is_active`)
VALUES (3,'guru123@gmail.com','developer@123',1);

INSERT INTO user (`emp_id`,`user_name`,`password`,`is_active`)
VALUES (4,'clicktovinay@gmail.com','lead@123',1);

INSERT INTO user (`emp_id`,`user_name`,`password`,`is_active`)
VALUES (5,'pavithra.raghavan@gmail.com','trainee1@123',1);

INSERT INTO user (`emp_id`,`user_name`,`password`,`is_active`)
VALUES (6,'manisha.raghavan@gmail.com','trainee2@123',1);

INSERT INTO user (`emp_id`,`user_name`,`password`,`is_active`)
VALUES (7,'kavin.kumar@gmail.com','sse1@123',1);

INSERT INTO user (`emp_id`,`user_name`,`password`,`is_active`)
VALUES (8,'ragu.ram@gmail.com','sse2@123',1);

INSERT INTO user (`emp_id`,`user_name`,`password`,`is_active`)
VALUES (9,'vanthana95@gmail.com','tester1@123',1);

INSERT INTO user (`emp_id`,`user_name`,`password`,`is_active`)
VALUES (10,'mathicse@gmail.com','tester2@123',1);

#User Role

INSERT INTO user_role (user_id,role_id)
VALUES (1,1);

INSERT INTO user_role (user_id,role_id)
VALUES (2,1);

INSERT INTO user_role (user_id,role_id)
VALUES (3,2);

INSERT INTO user_role (user_id,role_id)
VALUES (4,2);

INSERT INTO user_role (user_id,role_id)
VALUES (5,2);

INSERT INTO user_role (user_id,role_id)
VALUES (6,2);

INSERT INTO user_role (user_id,role_id)
VALUES (7,2);

INSERT INTO user_role (user_id,role_id)
VALUES (8,2);

INSERT INTO user_role (user_id,role_id)
VALUES (9,2);

INSERT INTO user_role (user_id,role_id)
VALUES (10,2);

#Project

INSERT INTO project (project_name ,project_desc )
VALUES ('HRM System', 'Human Resource Management System');

INSERT INTO project (project_name ,project_desc )
VALUES ('CII', 'Event management');

INSERT INTO project (project_name ,project_desc )
VALUES ('Asset Management', 'Deals with loans and asset');


#Module

INSERT INTO module (module_name,module_desc )
VALUES ('DB Creation', 'Creates database for the application/project');

INSERT INTO module (module_name,module_desc )
VALUES ('UI design', 'UI Design for the application/project');

INSERT INTO module (module_name,module_desc )
VALUES ('Development', 'Developes the application/project');

INSERT INTO module (module_name,module_desc )
VALUES ('Testing', 'V&V for the application/project');

INSERT INTO module (module_name,module_desc )
VALUES ('Bug Fixing', 'Fixes the reported issues');

#Project Module

INSERT INTO project_module(project_id ,module_id)
VALUES (1,1);

INSERT INTO project_module (project_id ,module_id)
VALUES (1,2);

INSERT INTO project_module (project_id ,module_id)
VALUES (1,3);

INSERT INTO project_module (project_id ,module_id)
VALUES (1,4);

INSERT INTO project_module (project_id ,module_id)
VALUES (1,5);

INSERT INTO project_module (project_id ,module_id)
VALUES (2,1);

INSERT INTO project_module (project_id ,module_id)
VALUES (2,2);

INSERT INTO project_module (project_id ,module_id)
VALUES (2,3);

INSERT INTO project_module (project_id ,module_id)
VALUES (2,4);

INSERT INTO project_module (project_id ,module_id)
VALUES (2,5);

INSERT INTO project_module (project_id ,module_id)
VALUES (3,1);

INSERT INTO project_module (project_id ,module_id)
VALUES (3,2);

INSERT INTO project_module (project_id ,module_id)
VALUES (3,3);

INSERT INTO project_module (project_id ,module_id)
VALUES (3,4);

INSERT INTO project_module (project_id ,module_id)
VALUES (3,5);

