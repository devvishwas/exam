-- Create table DEPARTMENT
CREATE TABLE department (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100)
);

-- Create table EMPLOYEE
CREATE TABLE employee (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150),
    position VARCHAR(100),
    salary DOUBLE,
    department_id VARCHAR(50),
    CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE SET NULL
);

-- Insert Departments
INSERT INTO department (id, name, location) VALUES ('dept01', 'Human Resources', 'Building A');
INSERT INTO department (id, name, location) VALUES ('dept02', 'Engineering', 'Building B');

-- Insert Employees

-- HR Department Employees
INSERT INTO employee (id, name, email, position, salary, department_id) VALUES
('emp001', 'Alice Smith', 'alice.smith@example.com', 'Recruiter', 60000, 'dept01');

INSERT INTO employee (id, name, email, position, salary, department_id) VALUES
('emp003', 'Charlie Brown', 'charlie.brown@example.com', 'HR Assistant', 40000, 'dept01');

-- Engineering Department Employees
INSERT INTO employee (id, name, email, position, salary, department_id) VALUES
('emp002', 'Bob Johnson', 'bob.johnson@example.com', 'Software Engineer', 80000, 'dept02');

INSERT INTO employee (id, name, email, position, salary, department_id) VALUES
('emp004', 'Diana Prince', 'diana.prince@example.com', 'System Architect', 90000, 'dept02');
