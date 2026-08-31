-- ============================================================================
-- SPPU MCA Track | 6-Month Java Backend Developer Roadmap
-- Track: Database & SQL Mastery (Month 2)
-- Week 05: SQL Fundamentals
-- Day 02: DML Masterclass: CRUD, Safe Updates & WHERE Filtering
-- Author: Nayan Deshmukh (SPPU Class of 2027)
-- ============================================================================

-- ----------------------------------------------------------------------------
-- 1. SEED DATA (Batch INSERT with diverse records)
-- ----------------------------------------------------------------------------
INSERT INTO students (first_name, last_name, email, roll_number, cgpa, is_active)
VALUES 
    ('Aarav', 'Kulkarni', 'aarav.k@sppu.ac.in', 'MCA2027004', 9.10, TRUE),
    ('Neha', 'Joshi', 'neha.j@sppu.ac.in', 'MCA2027005', 7.80, TRUE),
    ('Rohan', 'Shinde', 'rohan.s@sppu.ac.in', 'MCA2027006', 8.40, FALSE),
    ('Ananya', 'Desai', 'ananya.d@sppu.ac.in', 'MCA2027007', 9.65, TRUE),
    ('Vikram', 'More', 'vikram.m@sppu.ac.in', 'MCA2027008', 6.90, TRUE),
    ('Tanvi', 'Gupte', 'tanvi.g@sppu.ac.in', 'MCA2027009', 8.95, TRUE)
ON CONFLICT (email) DO NOTHING; -- Prevents duplicate errors if re-run

-- ----------------------------------------------------------------------------
-- 2. READ (DQL) - Selective Columns with Aliasing (AS)
-- ----------------------------------------------------------------------------
-- Fetch clean report with friendly column names
SELECT 
    student_id AS "ID",
    first_name || ' ' || last_name AS "Full Name",
    email AS "Email Address",
    cgpa AS "Grade Point Average"
FROM students;

-- ----------------------------------------------------------------------------
-- 3. FILTERING CHALLENGES (WHERE Clause Mastery)
-- ----------------------------------------------------------------------------

-- Challenge A: SPPU Dean's Honor List (CGPA >= 9.00 and currently active)
SELECT first_name, last_name, cgpa
FROM students
WHERE cgpa >= 9.00 
  AND is_active = TRUE;

-- Challenge B: First Class Distinction (CGPA between 8.00 and 8.99 inclusive)
SELECT first_name, last_name, cgpa
FROM students
WHERE cgpa BETWEEN 8.00 AND 8.99;

-- Challenge C: Target lookup using IN operator
SELECT first_name, last_name, roll_number, email
FROM students
WHERE roll_number IN ('MCA2027001', 'MCA2027005', 'MCA2027007');

-- ----------------------------------------------------------------------------
-- 4. SAFE UPDATE (Using 2-Step Protocol + RETURNING)
-- ----------------------------------------------------------------------------
-- Scenario: Neha Joshi improved her score; update CGPA to 8.20
UPDATE students
SET cgpa = 8.20
WHERE roll_number = 'MCA2027005'
RETURNING student_id, first_name, last_name, cgpa;

-- ----------------------------------------------------------------------------
-- 5. SOFT DELETE vs HARD DELETE
-- ----------------------------------------------------------------------------
-- Industry Standard: Deactivate student account instead of deleting (Soft Delete)
UPDATE students
SET is_active = FALSE
WHERE roll_number = 'MCA2027008'
RETURNING student_id, roll_number, is_active;