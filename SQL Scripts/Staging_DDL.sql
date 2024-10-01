-- Creating Database 
CREATE DATABASE Harbour_Retail;
CREATE SCHEMA Harbour_Retail_Target;

USE Harbour_Retail;

-- Creating Staging Tables 
CREATE TABLE staging_employee (
	Emp_ID int PRIMARY KEY,
	First_Name VARCHAR(100),
	Surname VARCHAR(100),
	Department VARCHAR(100),
	Salary int,
	Address VARCHAR(100),
	ZIP_Code int,
	City VARCHAR(100),
	Country VARCHAR(100),
	Employed_Since DATE,
	Manager VARCHAR(100)
);

CREATE TABLE staging_product (
	PRODUCT_ID INT PRIMARY KEY,
	BRAND VARCHAR(100),
	TYPE VARCHAR(100),
	CATEGORY VARCHAR(100),
	FIT VARCHAR(100),
	SIZE INT,
	SEX VARCHAR(100),
	DESCRIPTION VARCHAR(100),
	PURCHASEPRICE FLOAT,
	SELLINGPRICE FLOAT,
	PACKAGESIZE FLOAT,
	SUPPLIER_ID FLOAT
);

CREATE TABLE staging_sales (
    SALES_ID FLOAT PRIMARY KEY,
    CUSTOMER_ID FLOAT,
    EMP_ID FLOAT,
    STORE_ID FLOAT,
    PRODUCT_ID FLOAT,
    SELLING_DATE DATETIME,
    QUANTITY FLOAT
);

CREATE TABLE staging_store (
    Store_ID INT PRIMARY KEY,
	Name VARCHAR(100),
	Address VARCHAR(100),
	ZIP_Code INT,
	City VARCHAR(100),
	Country VARCHAR(100),
	OpenedSince DATETIME,
	Last_Redesigned DATETIME,
	Selling_Square_Footage DECIMAL(38,0),
	Total_Square_Footage DECIMAL(38,0)
);

CREATE TABLE staging_supplier (
	Supplier_ID INT PRIMARY KEY,
	Company_Name VARCHAR(10),
	Bank_Account BIGINT,
	Preferred VARCHAR(10),
	Address VARCHAR(12),
	ZIP_Code VARCHAR(10),
	City VARCHAR(9),
	Country VARCHAR(5)
);

-- Creating Reject Tables 
CREATE TABLE staging_employee_reject (
	Emp_ID int PRIMARY KEY,
	First_Name VARCHAR(100),
	Surname VARCHAR(100),
	Department VARCHAR(100),
	Salary int,
	Address VARCHAR(100),
	ZIP_Code int,
	City VARCHAR(100),
	Country VARCHAR(100),
	Employed_Since DATE,
	Manager VARCHAR(100),
	Error_Code VARCHAR(100),
	Error_Message VARCHAR(100)
);

CREATE TABLE staging_supplier_reject (
	Supplier_ID INT PRIMARY KEY,
	Company_Name VARCHAR(10),
	Bank_Account BIGINT,
	Preferred VARCHAR(10),
	Address VARCHAR(12),
	ZIP_Code VARCHAR(10),
	City VARCHAR(9),
	Country VARCHAR(5),
    Error_Code VARCHAR(100),
	Error_Message VARCHAR(100)
);

CREATE TABLE staging_product_reject (
	PRODUCT_ID INT,
	BRAND VARCHAR(100),
	TYPE VARCHAR(100),
	CATEGORY VARCHAR(100),
	FIT VARCHAR(100),
	SIZE INT,
	SEX VARCHAR(100),
	DESCRIPTION VARCHAR(100),
	PURCHASEPRICE FLOAT,
	SELLINGPRICE FLOAT,
	PACKAGESIZE FLOAT,
	SUPPLIER_ID INT,
	Error_Code VARCHAR(100),
	Error_Message VARCHAR(100)
);

CREATE TABLE staging_sales_reject (
	SALES_ID FLOAT,
    CUSTOMER_ID FLOAT,
    EMP_ID FLOAT,
    STORE_ID FLOAT,
    PRODUCT_ID FLOAT,
    SELLING_DATE DATETIME,
    QUANTITY FLOAT,
	Error_Code VARCHAR(100),
	Error_Message VARCHAR(100)
);

CREATE TABLE staging_store_reject (
	STORE_ID INT,
	NAME VARCHAR(100),
	ADDRESS VARCHAR(100),
	ZIP_CODE INT,
	CITY VARCHAR(100),
	COUNTRY VARCHAR(100),
	OPENEDSINCE DATETIME,
	LAST_REDESIGNED DATETIME,
	SELLING_SQUARE_FOOTAGE DECIMAL(38,0),
	TOTAL_SQUARE_FOOTAGE DECIMAL(38,0),
	Error_Code VARCHAR(100),
	Error_Message VARCHAR(100)
);

-- Creating Audit Table 
CREATE TABLE Audit (
    execution_key INT PRIMARY KEY AUTO_INCREMENT,
    project_name VARCHAR(250),
    job_name VARCHAR(50),
    status VARCHAR(50),
    start_date DATE,
    start_time TIME,
    end_date DATE,
	end_time TIME,
    source_count INT,
    target_count INT,
    lookup_count INT,
    reject_count INT
);


-- Truncate staging tables
TRUNCATE TABLE staging_employee;
TRUNCATE TABLE staging_product;
TRUNCATE TABLE staging_sales;
TRUNCATE TABLE staging_store;
TRUNCATE TABLE staging_supplier;

-- Truncate reject tables
TRUNCATE TABLE staging_employee_reject;
TRUNCATE TABLE staging_supplier_reject;
TRUNCATE TABLE staging_product_reject;
TRUNCATE TABLE staging_sales_reject;
TRUNCATE TABLE staging_store_reject;


-- Truncate audit tables
TRUNCATE TABLE Audit;














