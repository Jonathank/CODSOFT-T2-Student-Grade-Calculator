create database StudentGrade_Calculation;

use StudentGrade_Calculation;

create table auto_id(
ID_NO int primary key
);

create table Student(
studentID varchar(255) primary key,
std_name varchar(255),
gender varchar(255)
);

create table Subjects_and_Marks(
ID int primary key,
studentID varchar(255),
Academic_year varchar(255),
Term varchar(255),
subject_name varchar(255),
Marks int,
Grade varchar(255)

);

Alter table Subjects_and_Marks add foreign key(studentID) references student(studentID) on delete cascade;


