/*----------------------------------------------------------------------*/
drop table student;
create table student (
   SSN      char(9),
  S_Name     varchar(20),
   Status   varchar(5),
   Major    char(4)
);

insert into student values ( '324513111' , 'Tuner'     , 'Under' , 'ENGL'
);
insert into student values ( '415671238' , 'William'   , 'Grad'  , 'INFS'
);
insert into student values ( '521090112' , 'Adam'      , 'Grad'  , 'INFS'
);
insert into student values ( '900081239' , 'Johnson'   , 'Grad'  , 'MATH'
);
insert into student values ( '701281118' , 'Glenn'     , 'Grad'  , 'MATH'
);
insert into student values ( '654322221' , 'Brooks'    , 'Non'   , 'INFS'
);
insert into student values ( '600000001' , 'John'      , 'Under' , 'BUSI'
);
insert into student values ( '601111111' , 'Bob'       , 'Grad'  , 'BUSI'
);
insert into student values ( '244400001' , 'Smith'     , 'Non'   , 'BUSI'
);
insert into student values ( '811111111' , 'Clinton'   , 'Grad'  , 'INFS'
);
insert into student values ( '911111111' , 'Alex'      , 'Under' , 'MATH'
);
insert into student values ( '711111111' , 'Peter'     , 'Grad'  , 'INFS'
);
insert into student values ( '300000000' , 'Simpson'   , 'Grad'  , 'INFS'
);
insert into student values ( '500000001' , 'Michael'   , 'Grad'  , 'MATH'
);
insert into student values ( '411111110' , 'Jean'      , 'Under' , 'MATH'
);
insert into student values ( '544443333' , 'Julia'     , 'Under' , 'ENGL'
);
insert into student values ( '633354444' , 'Ann'       , 'Under' , 'BUSI'
);
                                            
/*----------------------------------------------------------------------*/
drop table enrollment;
create table enrollment (
   Student_SSN      char(9),
   Class_no number(6)
); 

insert into enrollment values ( '324513111' , 20001 );
insert into enrollment values ( '415671238' , 10002 );
insert into enrollment values ( '415671238' , 10003 );
insert into enrollment values ( '521090112' , 10001 );
insert into enrollment values ( '900081239' , 30001 );
insert into enrollment values ( '701281118' , 10001 );
insert into enrollment values ( '701281118' , 30001 );
insert into enrollment values ( '654322221' , 10002 );
insert into enrollment values ( '600000001' , 20002 );
insert into enrollment values ( '600000001' , 40001 );
insert into enrollment values ( '600000001' , 40002 );
insert into enrollment values ( '601111111' , 40002 );
insert into enrollment values ( '601111111' , 20002 );
insert into enrollment values ( '244400001' , 40001 );
insert into enrollment values ( '811111111' , 10004 );
insert into enrollment values ( '911111111' , 30001 );
insert into enrollment values ( '300000000' , 10001 );
insert into enrollment values ( '500000001' , 30001 );
insert into enrollment values ( '411111110' , 30002 );
insert into enrollment values ( '544443333' , 20002 );
insert into enrollment values ( '633354444' , 40001 );

/*----------------------------------------------------------------------*/
drop table transcript;
create table transcript (
   Student_SSN      char(9),
   D_Code   char(4),
   C_no number(6),
   Grade    char(1)
);

insert into transcript values ( '415671238' , 'INFS' , 600 , 'A' );
insert into transcript values ( '521090112' , 'ENGL' , 200 , 'B' );
insert into transcript values ( '600000001' , 'ENGL' , 200 , 'A' );
insert into transcript values ( '811111111' , 'INFS' , 600 , 'A' );
insert into transcript values ( '811111111' , 'MATH' , 321 , 'B' );
insert into transcript values ('811111111', 'INFS', 501, 'C');
/*----------------------------------------------------------------------*/
drop table class;
create table class (
   Class_No    number(6),
   D_Code   char(4),
   C_no    number(6),
   Instructor_SSN  char(9)
); 

insert into class values ( 10001 , 'INFS' , 600, '134400029');
insert into class values ( 10002 , 'INFS' , 614, '243466681');
insert into class values ( 10003 , 'INFS' , 762, '134400029');
insert into class values ( 10004 , 'INFS' , 614, '235466789');
insert into class values ( 20001 , 'ENGL' , 200, '154456789');
insert into class values ( 20002 , 'ENGL' , 400, '244400001');
insert into class values ( 30001 , 'MATH' , 501, '235456788');
insert into class values ( 30002 , 'MATH' , 321, '235456788');
insert into class values ( 40001 , 'BUSI' , 620, '156676789');
insert into class values ( 40002 , 'BUSI' , 580, '166678789');

/*----------------------------------------------------------------------*/
drop table course;
create table course (
   D_Code  char(4),
   C_no   number(6),
   Title   varchar(20),
   Units   number(6)
);

insert into course values ( 'INFS' , 614 ,  'Database'          , 3 );
insert into course values ( 'INFS' , 600 ,  'Operating System'  , 3 );
insert into course values ( 'INFS' , 762 ,  'Security'          , 3 );
insert into course values ( 'ENGL' , 200 ,  'Grammar'           , 3 );
insert into course values ( 'ENGL' , 400 ,  'Technical Writing' , 3 );
insert into course values ( 'MATH' , 321 ,  'Calculus'          , 3 );
insert into course values ( 'MATH' , 501 ,  'Advance Algebra'   , 3 );
insert into course values ( 'BUSI' , 620 ,  'Finance'           , 3 );
insert into course values ( 'BUSI' , 580 ,  'Accounting'        , 3 );
insert into course values ( 'INFS' , 501 ,  'Discrete Math'     , 3 );

/*----------------------------------------------------------------------*/
drop table department;
create table department (
   D_Code      char(4),
   D_Name      varchar(20),
   Chair_SSN   char(9)
   );

insert into department values ( 'INFS' , 'Information System' ,
'134400029' );
insert into department values ( 'ENGL' , 'English'            ,
'244400001' );
insert into department values ( 'MATH' , 'Mathematics'        ,
'147777678' );
insert into department values ( 'BUSI' , 'Business'           ,
'156676789');
insert into department values ('Geop', 'Geophyics', '134400029');
/*----------------------------------------------------------------------*/
drop table prereq;
create table prereq (
   D_Code   char(4),
   C_no    number(6),
   P_Code   char(4),
   P_no    number(6)
);

insert into prereq values ( 'INFS' , 614 , 'INFS' , 600 );
insert into prereq values ( 'INFS' , 614 , 'MATH' , 321 );
insert into prereq values ( 'ENGL' , 400 , 'ENGL' , 200 );
insert into prereq values ('INFS', 614, 'INFS', 501);
/*----------------------------------------------------------------------*/
drop table faculty;
create table faculty (
   SSN      char(9),
   F_Name     varchar(20),
   Rank     varchar(6),
   Office   char(4),
   D_Code     char(4)
);

insert into faculty values ( '134400029' , 'Jones'     , 'Full'   , 'S500'
, 'INFS' );
insert into faculty values ( '244400001' , 'Smith'     , 'Full'   , 'S200'
, 'ENGL' );
insert into faculty values ( '243466681' , 'Lyle'      , 'Assist' , 'S211'
, 'INFS' );
insert into faculty values ( '235456788' , 'Lindsay'   , 'Assist' , 'T101'
, 'MATH' );
insert into faculty values ( '235466789' , 'Kudlic'    , 'Assoc'  , 'S101'
, 'INFS' );
insert into faculty values ( '154456789' , 'King'      , 'Assist' , 'R201'
, 'ENGL' );
insert into faculty values ( '166678789' , 'Korth'     , 'Assist' , 'T001'
, 'BUSI' );
insert into faculty values ( '177776789' , 'Fisherman' , 'Assist' , 'S040'
, 'INFS' );
insert into faculty values ( '147777678' , 'Hays'      , 'Full'   , 'S300'
, 'MATH' );
insert into faculty values ( '156676789' , 'Jackson'   , 'Full'   , 'R400'
, 'BUSI' );
