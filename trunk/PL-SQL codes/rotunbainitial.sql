Create Table ARTIST
(
ARTISTNAME varchar2(25) constraint artistkey primary key,
BIRTHPLACE varchar2(25),
AGE number(3),
GENRE varchar2(15)
);

Create Table MUSIC 
(
TITLE varchar2(25) constraint musickey primary key,
ALBUM varchar2(25),
YEAR date,
PRICE number(3)
);

Create Table CATEGORY 
(
LABEL varchar2(25) constraint categorykey primary key,
CATEGORYNAME varchar2(25),
);

Create Table CUSTOMER
 (
CID number(5) constraint customerkey primary key,
CUSTOMERNAME varchar2(25),
ADDRESS varchar2(50),
GENDER char(1),
AGE number(2),
AMOUNTSPENT number(8)
);

Create Table MUSIC_CATEGORY
(
TITLE varchar2(25) constraint fktitle2 references MUSIC(TITLE),
LABEL varchar2(25) not null constraint fklabel references CATEGORY(LABEL),
constraint nosamemusiccategories unique(TITLE, LABEL)
);

Create Table MUSIC_ARTIST 
(
TITLE varchar2(25) constraint fktitle references MUSIC(TITLE),
ARTISTNAME varchar2(25) not null constraint fkartistname references ARTIST(ARTISTNAME),
constraint nosamemusicartist unique(TITLE, ARTISTNAME)
);

Create Table FAV_ARTIST
(
ARTISTNAME varchar2(25) constraint fkartistname2 references ARTIST(ARTISTNAME),
CID number(5) constraint fkcustomer references CUSTOMER(CID),
constraint nosamefavartist unique(ARTISTNAME, CID)
);

Create Table FAV_CATEGORY
(
LABEL varchar2(25) constraint fklabel2 references CATEGORY(LABEL),
CID number(5) constraint fkcustomer2 references CUSTOMER(CID),
constraint nosamefavcategory unique(LABEL, CID)
);

insert into ARTIST values('TUFACE','PORT HARCOURT',30,'Rythm and Blues');
insert into ARTIST values('LIL WAYNE','CHICAGO',28,'RAP');

insert into MUSIC values('AFRICAN QUEEN','GRASS2GRACE','02-MAY-07',10);
insert into MUSIC values('MRS OFFICER','CARTERIII','02-FEB-08',12);

insert into CATEGORY values('CAT1','OPERA');
insert into CATEGORY values('CAT2','CLASSICAL');

insert into CUSTOMER values(1,'DANIEL OLALEYE','10305 FRIENDSHIP COURT','M',25,250);
insert into CUSTOMER values(2,'OTUNBA CHENILLE','10305 FRIENDSHIP COURT','F',29,1230);

insert into MUSIC_CATEGORY values('AFRICAN QUEEN','CAT1');
insert into MUSIC_CATEGORY values('MRS OFFICER','CAT1');

insert into MUSIC_ARTIST values('AFRICAN QUEEN','TUFACE');
insert into MUSIC_ARTIST values('MRS OFFICER','LIL WAYNE');

insert into FAV_ARTIST values('TUFACE',1);
insert into FAV_ARTIST values('LIL WAYNE',1);


insert into FAV_CATEGORY values('CAT1',1);
insert into FAV_CATEGORY values('CAT2',1);



------------------
YET TO BE TESTED
------------------

select * from ARTIST;
select * from CATEGORY;
select * from CUSTOMER ;
select * from FAV_ARTIST ;
select * from FAV_CATEGORY ;
select * from MUSIC ;
select * from MUSIC_ARTIST ;
select * from MUSIC_CATEGORY ;



//insert into ARTIST values(7999,'SCOTT','CLERK',7698,'31-OCT-94',450,10);



insert into MUSIC values('LIL WAYNE','CHICAGO',28,'RAP');




drop table ARTIST;
drop table CATEGORY;
drop table CUSTOMER;
drop table MUSIC;
drop table MUSIC_CATEGORY;
drop table MUSIC_ARTIST;
drop table FAV_ARTIST;
drop table FAV_CATEGORY;


select table_name
from all_tables
where owner='ROTUNBA';

drop table ARTIST;

http://dbis.ucdavis.edu/courses/sqltutorial/tutorial.pdf

