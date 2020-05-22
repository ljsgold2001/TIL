# 프로그래머스 SQL 



### 1.SELECT

 ```mysql
#1번문제

SELECT * From ANIMAL_INS Order by ANIMAL_ID

#2번문제

SELECT NAME, DATETIME
From  ANIMAL_INS
order by ANIMAL_ID desc

#3번문제

SELECT ANIMAL_ID , NAME
From ANIMAL_INS
where INTAKE_CONDITION = "Sick"
Order By ANIMAL_ID

#4번문제

SELECT ANIMAL_ID, NAME
From ANIMAL_INS
Where  INTAKE_CONDITION !="Aged"
Order by ANIMAL_ID

#5번문제

SELECT ANIMAL_ID ,NAME
From ANIMAL_INS
order by ANIMAL_ID

#6번문제

SELECT ANIMAL_ID ,NAME, DATETIME
From ANIMAL_INS
order by NAME ASC , DATETIME DESC

#7번문제

SELECT NAME
From ANIMAL_INS

order by DATETIME
Limit 1


 ```



### 2.SUM,MIN,MAX

```mysql
#1번문제

SELECT max(DateTIME)
From ANIMAL_INS

#2번문제

SELECT min(DateTIME)
From ANIMAL_INS

#3번문제

SELECT count(ANIMAL_ID)
From ANIMAL_INS

#4번문제

SELECT count(DISTINCT NAME)
From ANIMAL_INS
```



### 3. GROUP BY

```mysql
#1번 문제
select ANIMAL_type , count(ANIMAL_TYPE)
from ANIMAL_INS
group by ANIMAL_TYPE
order by ANIMAL_TYPE

#2번문제

SELECT NAME, count(*) As "COUNT"
From ANIMAL_INS
where NAME is not null
Group by NAME
having count(*)>=2

#3번문제

SELECT HOUR(DATETIME) as "HOUR" , count(*) as "COUNT"
from ANIMAL_OUTS
group by HOUR
having HOUR between 9 and 19
order by hour(DATETIME)

#4번문제 - 프로그래머스 SQL 중에 가장어려운것 같다(참고했음)

set @time := -1;
Select 
    (@time := @time +1) as 'HOUR',
    (select count(*)
     from animal_outs
     where hour(DATETIME) = @time) as "COUNT"
From
    animal_outs
where
    @time <23;
```



### ISNULL

```mysql
#1번문제

SELECT ANIMAL_ID
from ANIMAL_INS
where name is null

#2번문제

SELECT ANIMAL_ID
From ANIMAL_INS
where NAME is not null

#3번문제

SELECT 
    ANIMAL_TYPE, 
    IFNULL(NAME, "No name") AS NAME, 
    SEX_UPON_INTAKE 
FROM 
    ANIMAL_INS
```



### JOIN



```mysql
#1번문제

SELECT O.ANIMAL_ID, O.NAME
From ANIMAL_INS  I right join  ANIMAL_OUTS O on I.ANIMAL_ID = O.ANIMAL_ID
where I.ANIMAL_ID is null
order by O.ANIMAL_ID

#2번문제

SELECT I.ANIMAL_ID, I.NAME
From ANIMAL_INS I join ANIMAL_OUTS O on I.ANIMAL_ID = O.ANIMAL_ID
where I.DATETIME> O.DATETIME
Order by I.DATETIME

#3번문제

SELECT I.NAME , I.DATETIME
From ANIMAL_INS I LEFT JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.ANIMAL_ID is null   
order by I.DATETIME
limit 3

#4번문제

SELECT I.ANIMAL_ID,I.ANIMAL_TYPE,I.NAME
From 
    (select *
     from ANIMAL_INS
     where SEX_UPON_INTAKE  LIKE "%Intact%") I,
    ANIMAL_OUTS O
     
#5번문제
where
    I.ANIMAL_ID = O.ANIMAL_ID
    AND
    O.SEX_UPON_OUTCOME NOT LIKE "%Intact%"
```



### STIRNG DATE

```mysql
#1번문제

SELECT ANIMAL_ID, NAME,SEX_UPON_INTAKE
From ANIMAL_INS
where  NAME  in ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')

#2번문제

SELECT ANIMAL_ID ,NAME
From ANIMAL_INS
where name like "%el%" AND ANIMAL_TYPE = "Dog"
order by NAME

#3번문제 ->case공부

SELECT ANIMAL_ID, NAME, 
CASE
 WHEN SEX_UPON_INTAKE LIKE '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%'
 THEN 'O'
 ELSE 'X' END as '중성화'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

#4번문제

SELECT I.ANIMAL_ID , I.NAME
From
    ANIMAL_INS I join ANIMAL_OUTS O on I.ANIMAL_ID = O.ANIMAL_ID
order by I.DATETIME - O.DATETIME
limit 2

#5번문제

SELECT ANIMAL_ID , NAME , DATE_FORMAT(DATETIME, '%Y-%m-%d') AS 날짜
From ANIMAL_INS
#order by ANIMAL_ID

```

