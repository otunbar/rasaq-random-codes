-- Student: Otunba Olaleye Rasaq (G00466185)
-- Homework #4
-- Section 002 – Thursday
-- Instructor – Dr. Alex Brodsky
-- Email: rotunba@gmu.edu

--1
SELECT S.S_Name, S.Major, count(E.class_no) As Num_Enrollment
FROM student S, enrollment E
WHERE S.SSN=E.Student_SSN 
Group by S.S_Name,S.Major
HAVING count(E.class_no) < 5;

--2
SELECT S.S_Name, S.SSN, count(T.c_no) As Num_courses
FROM student S, transcript T
WHERE S.SSN=T.Student_SSN(+) 
Group by S.S_Name,S.SSN
order by Num_courses, S.SSN ASC;

--3
select class_no from 
(
SELECT c.class_no, c.c_no, count(p.p_code) as num_prereq
FROM class c, prereq p
WHERE c.d_code=p.d_code
and   c.c_no = p.c_no 
Group by c.c_no,c.class_no
) 
where num_prereq = (SELECT min(num_prereq) from
(
SELECT c.class_no, c.c_no, count(p.p_code) as num_prereq
FROM class c, prereq p
WHERE c.d_code=p.d_code
and   c.c_no = p.c_no 
Group by c.c_no,c.class_no
));

--4
select chair_ssn from 
department where d_name = 'T%';

--5
select count(*) As Num_major from student where major is NOT NULL;

--6
SELECT S.S_Name, S.ssn, SUM(C.units) As Num_units
FROM student S, course c, Enrollment E, class k
WHERE S.SSN=E.Student_SSN
and  E.class_no = k.class_no
and C.d_code = k.d_code
and c.c_no = k.c_no
Group by S.S_Name, S.ssn
HAVING SUM(C.units) > 9;

--7
SELECT S.S_Name, S.ssn, AVG(DECODE(T.Grade, 'A', 4, 'B', 3, 'C', 2, 0)) AS GPA
FROM transcript T, Student S
where s.ssn = T.student_ssn
GROUP BY S.S_Name, S.ssn
ORDER BY GPA DESC;

--8
select c_no,(count(*))/(Select count(distinct student_ssn) from transcript) * 100
AS "Percentage Of Total Students"
from transcript where grade = 'A' group by c_no;

--9
select d_code,c_no, count(decode(grade, 'A',4))A,count(decode(grade, 'B',3))B,count(decode(grade, 'C',2))C, count(decode(grade, 'F',0))F
from transcript where
d_code = 'INFS' 
group by d_code,c_no;


--10
SELECT d_code, c_no, count(p_code) as num_prereq
FROM prereq 
Group by c_no,d_code
having count(p_code) = 3;