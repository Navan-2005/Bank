create table banksystem;
use  banksystem;
create table signup(form_no varchar(30),Name varchar(30),Fathe_Name varchar(30),DOB varchar(30),Gender varchar(30),email varchar(60),Marital varchar(60),PIN varchar(30));
select * from signup;
create table signup2(form_no varchar(30),Religion varchar(30),Category varchar(30),Income varchar(30),Occupation varchar(30),PAN varchar(30),Aadhaar varchar(30),Senior_Citizen varchar(30), Existing_Account varchar(30));
select * from signup2;
create table signup3(form_no varchar(30),Account_Type varchar(30),Card_No varchar(30),PIN_No varchar(30),Facility varchar(300));
select * from signup3;
create table login(form_no varchar(30),Card_No varchar(30),PIN_No varchar(30));
select * from login;
