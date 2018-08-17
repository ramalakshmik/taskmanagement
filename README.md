# taskmanagement

Task Management System





hi all

#SQL Queries

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