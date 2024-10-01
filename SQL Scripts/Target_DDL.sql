CREATE DATABASE Harbour_Retail_Target;
USE Harbour_Retail_Target;


-- Creating Target Tables 
CREATE TABLE Store_Dim (
    store_key INT PRIMARY KEY AUTO_INCREMENT,
    store_id INT,
    name VARCHAR(100),
    address VARCHAR(100),
    zip_code INT,
    city VARCHAR(100),
    country VARCHAR(100),
    openedsince DATE,
    last_redesigned DATE,
    selling_square_footage INT,
    total_square_footage INT
);

CREATE TABLE Employee_Dim (
    emp_key INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT,
    first_name VARCHAR(100),
    surname VARCHAR(100),
    department VARCHAR(100),
    salary INT,
    address VARCHAR(100),
    zip_code INT,
    city VARCHAR(100),
    country VARCHAR(100),
    employed_since DATE,
    manager VARCHAR(100),
    start_date DATE,
    end_date DATE,
    active_flag VARCHAR(100)
);


