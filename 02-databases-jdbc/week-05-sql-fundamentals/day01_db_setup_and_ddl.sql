-- ============================================================================
-- SPPU MCA Track | 6-Month Java Backend Developer Roadmap
-- Track: Database & SQL Mastery (Month 2)
-- Week 05: SQL Fundamentals
-- Day 01: PostgreSQL Setup, Database Creation & DDL Essentials
-- Author: Nayan Deshmukh (SPPU Class of 2027)
-- ============================================================================

-- ----------------------------------------------------------------------------
-- 1. CLEANUP (Idempotency: Allows re-running the script cleanly anytime)
-- ----------------------------------------------------------------------------
DROP TABLE IF EXISTS students;

-- ----------------------------------------------------------------------------
-- 2. CREATE TABLE (DDL - Data Definition Language)
-- ----------------------------------------------------------------------------
CREATE TABLE students (
    student_id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    roll_number VARCHAR(20) UNIQUE NOT NULL,
    cgpa NUMERIC(3, 2) CHECK (cgpa >= 0.00 AND cgpa <= 10.00),
    is_active BOOLEAN DEFAULT TRUE,
    enrolled_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- ----------------------------------------------------------------------------
-- 3. INSERT SAMPLE DATA (DML - Data Manipulation Language)
-- ----------------------------------------------------------------------------
INSERT INTO students (first_name, last_name, email, roll_number, cgpa)
VALUES 
    ('Nayan', 'Deshmukh', 'nayan.deshmukh@sppu.ac.in', 'MCA2027001', 9.45),
    ('Rahul', 'Sharma', 'rahul.sharma@sppu.ac.in', 'MCA2027002', 8.80),
    ('Priya', 'Patil', 'priya.patil@sppu.ac.in', 'MCA2027003', 9.15);

-- ----------------------------------------------------------------------------
-- 4. VERIFY DATA (DQL - Data Query Language)
-- ----------------------------------------------------------------------------
SELECT 
    student_id,
    first_name,
    last_name,
    email,
    roll_number,
    cgpa,
    is_active,
    enrolled_at
FROM students;