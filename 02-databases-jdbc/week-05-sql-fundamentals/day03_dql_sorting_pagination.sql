-- ============================================================================
-- SPPU MCA Track | 6-Month Java Backend Developer Roadmap
-- Track: Database & SQL Mastery (Month 2)
-- Week 05: SQL Fundamentals
-- Day 03: DQL Mastery: Pattern Matching, Sorting & Pagination
-- Author: Nayan Deshmukh (SPPU Class of 2027)
-- ============================================================================

-- ----------------------------------------------------------------------------
-- 1. PATTERN MATCHING (LIKE vs ILIKE)
-- ----------------------------------------------------------------------------

-- Query 1: Find all students with an official SPPU university email domain
SELECT student_id, first_name, last_name, email
FROM students
WHERE email LIKE '%@sppu.ac.in';

-- Query 2: Case-Insensitive search for names starting with 'a' or 'A' (Search bar simulation)
SELECT student_id, first_name, last_name
FROM students
WHERE first_name ILIKE 'a%';

-- Query 3: Using the single-character wildcard '_' (Find roll numbers 001 to 009)
SELECT student_id, first_name, roll_number
FROM students
WHERE roll_number LIKE 'MCA202700_';

-- ----------------------------------------------------------------------------
-- 2. SORTING (ORDER BY)
-- ----------------------------------------------------------------------------

-- Query 4: SPPU Merit List (Rank by CGPA descending, then by Last Name ascending)
SELECT 
    student_id,
    first_name || ' ' || last_name AS "Full Name",
    cgpa
FROM students
WHERE is_active = TRUE
ORDER BY cgpa DESC, last_name ASC;

-- ----------------------------------------------------------------------------
-- 3. PAGINATION (LIMIT & OFFSET for REST APIs)
-- ----------------------------------------------------------------------------

-- Scenario: A frontend table displays 3 students per page (Page Size = 3)

-- Page 1: Top 3 students (Offset = 0)
SELECT student_id, first_name, last_name, cgpa
FROM students
ORDER BY cgpa DESC
LIMIT 3 OFFSET 0;

-- Page 2: Next 3 students (Offset = 3)
SELECT student_id, first_name, last_name, cgpa
FROM students
ORDER BY cgpa DESC
LIMIT 3 OFFSET 3;

-- Page 3: Next 3 students (Offset = 6)
SELECT student_id, first_name, last_name, cgpa
FROM students
ORDER BY cgpa DESC
LIMIT 3 OFFSET 6;