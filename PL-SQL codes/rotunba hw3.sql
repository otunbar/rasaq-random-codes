-- Student: Otunba Olaleye Rasaq (G00466185)
-- Homework #3
-- Section 002 – Thursday
-- Instructor – Dr. Alex Brodsky
-- Email: rotunba@gmu.edu

--1
Select C.D_code, C.C_no, S.S_Name
From Class C, Enrollment E, Student S
Where E.Class_no = C.Class_no and
      E. Student_Ssn = S.Ssn
order by C.D_CODE ASC;

--2
Select C.D_code, C.C_no
From Course C, Transcript T, Student S
Where T.C_no = C.C_no and
      T.D_code = C.D_code and
      T.Student_ssn = S.ssn and 
      S.S_name = 'John' and
      T.grade = 'A';

--3
Select C.D_code, C.C_no
From Course C Where NOT EXISTS (select P.D_code, P.c_no
From Prereq P  where P.D_code =  C.D_code and P.c_no = C.C_no);

--4
SELECT distinct T.student_ssn
FROM Transcript T
WHERE NOT EXISTS (select P.p_code,P.p_no from prereq P where P.D_code = 'INFS' and P.c_no = 614
AND (NOT EXISTS (SELECT T1.student_ssn
FROM Transcript T1
WHERE T1.student_ssn = T.student_ssn and
      T1.D_code = P.p_code and
      T1.C_no = P.p_no)));

--5
SELECT  S.ssn, S.S_Name,  COUNT (*) AS scount
FROM  Student S, Enrollment E
WHERE  S.ssn = E.student_ssn(+) 
GROUP BY  (S.ssn, S.S_Name);

--6
SELECT  S.ssn, S.S_Name,  COUNT (*) AS scount
FROM  Student S, Enrollment E, Class C, Prereq P
WHERE  S.ssn=E.student_ssn and E.class_no = C.class_no and C.D_code = P.D_code and C.C_no = P.C_no
GROUP BY  (S.ssn, S.S_Name);

--7
Select T.D_code, AVG(DECODE (T.grade, 'A',4,'B',3,'c',2)) AS DGPA From Transcript T
Group By T.D_code;