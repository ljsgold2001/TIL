- #1과목-2

  성능데이터 모델이란

  - 데이터베이스의 성능 향상을 목적으로 정규화,반정규화,통합 분할등 반영되게 하는 것

  - ##### 성능 데이터 모델링 수행 시점

    - 날이 갈수록 증가한다.

  - **성능 데이터 모델링 고려사항**

    - 정규화 ->용량 산정->트랜잭션->반정규화->이력모델조정,pk/fk/서브타입조정->모델검증
    - 객체지향 모델링 ->클래스다이어그램확인

    - 2차정규화가 되어서 조회해도 pk unique index를 이요하여 조인성능저하가 되지 않음

  

  - ## 반정규화의 기법

    - ### 테이블

    - 테이블 병합

      - 1:1 관계 테이블 병합
      - 1:M 관계 테이블 병합
      - 슈퍼/서브 타입 테이블 병합

    - 테이블 분할

      - 수직분할
      - 수평분할

    - 테이블 추가

      - 중복 테이블 추가 : 다른업무이거나 다른 서버일 경우다.
      - 통계 테이블 추가 : 미리 계산해둠
      - 이력 테이블 추가 : 마스터 테이블에 존재하는 것을 이력테이블에도 존재
      - 부분 테이블 추가 : 자주 이용하는 것만 모아 둔것

    - ### 컬럼

    - 중복 컬럼 추가 : 조인을 감소

    - 파생 컬럼 추가 : 미리 계산해둠

    - 이력 테이블 칼럼추가 : 이력데이터에 최신값 갱신

    - Pk에 의한 컬럼 추가 : 복합 속성 PK여야하는데 단일 Pk를 이용하였을 경우

    - 응용시스템 오작동을 위한 컬럼 추가 : 복구하기위하여 임시적으로 중복하여 데이터를 가지고 있는 것

    - ### 관계

    - 중복관계 추가 : 추가적인 관계를 중복적으로 맺는 것

  

  - ## 대량 데이터

    - 수평 분할 : row 단위

    - 수직 분할 : column 단위

    - 대량의 데이터가 테이블에 존재하는 경우 인덱스의 Tree 구조가 너무 커지게 된다.

    - 대량의 컬럼이 존재하는 경우 여러개의 블록이 존재함으로 I/O가 증가하게 된다.

    - 대량의 컬럼은 로우 체이닝과 로우 마이그레이션을 발생한다.

      - 로우 체이닝 : 데이터가 여러블록에 저장이 되는 것 
      - 로우 마이그레이션 : 빈공간을 찾아서 저장하려고 하는 것

    - ### 컬럼의 수가 많을경우

      - 컬럼의 수가 많을 경우에는 1:1분리를 통해서 I/o를 감소시킬수있다.

    - ### 대량의 데이터일 경우

      - Range partition
        - 날짜 또는 숫자값으로 분리가 가능하다. / 관리가 용이
      - List partition
        - 날짜 또는 숫자값 분리 가능 / 관리가 용이 하지 않다.
      - Hash partition
        - 어떻게 나눠지는지 알 수 없다./ 관리가 용이 하지 않다.

    - ### 수평/수직 분할의 절차

      - 모델링 완성 - > 용량 산정 - >트랜잭션 패턴 분석 - >테이블 분할 검토

    - ### 슈퍼/서브타입 모델

      - 10만건도 되지 않는 작은 데이터의 양이라면 합쳐도 됨
      - 개별 테이블 구성
        - 트랜잭션이 슈퍼타입과 서브타입 각각 발생
          - 확장성 : 좋음
          - 조인성능 : 나쁨
          - I/O : 좋음 ( 테이블이 작을 수록 좋다.)
          - 관리 용이성 : 나쁨
      - 슈퍼타입 + 개별타입으로 묶어서 구성
        - 각각이 묶여서 트랜잭션이 구성할때 ex) ABC가 10 100 500만일때 각각 슈퍼타입과 합쳐진 하나의 엔티티로 구성
          - 확장성 : 보통
          - 조인성능 : 나쁨
          - i/o:좋음
          - 관리용이성 : 나쁨
      - 하나의 테이블로 구성
        - 계속해서 ABC테이블이 통합되어서 처리해야할때
          - 확장성 : 나쁨
          - 조인성능 : 우수
          - i/o : 나쁨
          - 관리용이성 : 좋음

    - ### 인덱스 특성을 고려 PK/FK를 이용한 성능 향상

      - PK : PK의 순서를 잘 맞추어야 한다. 상수값으로 비교되는 것이 먼저 앞에 와야한다.
      - FK : FK에 대한 인덱스를 생성하지 않으면 FULL TABLE SCAN이 일어난다.

  

  

  - ## 분산데이터 베이스

    - 병행 투명성 
      - 트랜잭션을 동시에 수행하여도 결과가 일관성 있어야한다. Time stamp
    - 장애 투명성
      - 장애가 나타나도 무관한 원자성 보장
    - 중복 투명성
      - DB가 여러 site에 중복되어 있는지 몰라도 된다.
    - 위치 투명성 
      - 데이터의 저장장소를 불명시 하여도 된다.
    - 지역사상 투명성
      - 지역 DBMS와 DB간의 사상 보장
    - 분할 투명성
      - 하나의 릴레이션이 여러 site에 분할되어 저장된다.

  - ### 장점

    - 지역자치성 , 용량증가 , 효율성 , 융통성 , 빠른응답 ,통신비용감소 ,요구 수용 증대

  - ### 단점

    - 개발비용 증가 , 오류의 잠재성 ,처리비용 증가 , 복잡도 증가 , 불규칙한 응답속도 , 무결성 위험

  - ### 분산데이터베이스 적용방법

    - 테이블 분할 
      - 수평분할
        - 지사별로 사용하는 데이터가 다를 경우 
        - 통합처리를 하려면 조인이 필요하다.
        - 지사마다 데이터가 다르기때문에 무결성이 보장된다.
      - 수직분할
        - 컬럼별로 분리한다.
        - 동일한 primary 키 구조를 가지고 있어야한다 .
        - 모아놔도 primary키로 인해서 데이터 중복은 일어나지 않는다.
    - 테이블 복제 분산
      - 동일한 테이블을 다른 지역이나 지사에서도 동일하게 만들어서 관리하는 것
        - 부분 복제
          - 통합된 하나를 두지사가 반반 나눠서 갖는 것 
          - 지사에서 데이터 통합 처리가 유용하다. 
          - 본사데이터처리는 통합본사테이블이용하기때문에 이것도 빠르다.
        - 광역복제
          - 지사와 본사 둘다 모든 데이터를 가지고 있는 것이다.
          - 특별한 제약을 받지 않는다.
          - 본사에서는 데이터처리를하면 지사에서는 빠르게 읽는다.
    - 테이블 요약 분산
      - 분산요약
        - 지사별로 요약한것을 본사에서 다시 통합하여 다시 요약하는 것
      - 통합요약
        - 본사에서 지사들의 내용을 요약해서 다시 산출하는 것

  - 데이터베이스를 분산하여 성능이 좋아진경우

    - 테이블이 잘못 속하여 있는 경우
    - 트랜잭션 개별적으로 원격지 조인

  

  

  # 2과목-1

  

  #### 

  - ### 데이터베이스

    - 넓은 의미에서의 데이터베이스는 이러한 일상적인 정보들을 모아 놓은 것 자체를 의미한다. 
    - 일반적으로 데이터베이스라고 말할 때는 특정 기업이나 조직 또는 개인이 필요에 의해(ex: 부가가치가 발생하는) 데이터를 일정한 형태로 저장해 놓은 것을 의미한다.
    - 데이터의 손상을 피하고, 필요시 필요한 데이터를 복구하기 위한 강력한 기능의 소프트웨어를 필요로 하게 되었고 이러한 기본적인 요구사항을 만족시켜주는 시스템을 DBMS(Database Management System)라고 한다.

  

  - ### 관계형 데이터베이스

    - 파일 시스템은 많은 사용자가 동시에 검색 할 수 있지만 입력,수정,삭제는 동시에 하지 못한다.
    - 원본 데이터 파일을 여러개 복사하여서 사용해야 한다.
    - 원본파일을 복사하였을때 복사본 파일까지 정보를 수정하지 않는 다면 정보의 불일치성이 발생 할 수 있다.
    - 단일사용자 ,단일 시스템은 파일 시스템이 유용하다.
    - 메타데이터를 총괄 관리 가능하여 데이터 표준화와 품질을 확보 할 수 있다.
    - 인증된 사용자만 사용할 수 있는 보안기능 제공한다.
    - 중요 데이터 삭제를 방지하는 무결성을 보장 한다.
    - 시스템 다운, 재해 등의 상황에서도 데이터를 회복/복구할 수 있는 기능을 제공한다.

    

  

  - #### SQL(Structured Query Language)

    

    - SQL은 관계형 데이터베이스에서 데이터 정의, 데이터 조작, 데이터 제어를 하기 위해 사용하는 언어이다. 
    - SQL 교육은 정확한 데이터를 출력하는 것이 목표이고, SQL 튜닝의 목적은 시스템에 큰 영향을 주는 SQL을 가장 효과적(응답시간, 자원 활용 최소화)으로 작성하는 것이 목표이다
    - 표준화된 SQL 이외에도 벤더 차별화 및 이용 편리성을 위해 추가 기능이나 내장 함수 등에서 독자적 개발을 계속 진행하고 있다
    - 일반적인 개발언어 처럼 독립된 하나의 개발 언어이다./관계형 데이터베이스 전담
    - 집합을 추출한다.

    

  ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_147.jpg)

  ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_148.jpg)

  - ### SQL 문장의 종류

    - DML
      - select, insert, update, delete
      - 데이터 베이스에 존재하는 데이터에 변형을 가하는 종류의 명령어들을 말한다.
    - DDL
      - Create, alter, drop, rename
      - 테이블과 같은 데이터의 구조를 정의하는데 사용하는 명령어들이다.
    - DCL
      - GRANT,REVOKE
      - 데이터 베이스에 접근하도록 객체들에게 권한을 주고 회수한다.
    - TCL
      - COMMIT , ROLLBACK
      - 논리적인 작업의 단위를 묵어서 조작된 결과를 트랜잭션 별로 제어한다.

  

  

  - ### TABLE

    - 데이터는 관계형 데이터베이스의 기본 단위인 테이블 형태로 저장된다.

    - 데이터를 저장하는 객체로서 관계형 데이터베이스의 기본 단위이다. 

    - 세로방향은 컬럼, 가로방향은 로우라고 하며 컬럼과 행이 합쳐지는 하나의 공간을 필드라고 한다.

    - 테이블을 분할하여 데이터의 불필요한 중복을 줄이는 것을 정규화(Normalization)라고 한다. (이상을 제거하기 위하여)

      

      

  ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_154.jpg)

  

  ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_156.jpg)

  ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_157.jpg)

  

  - ####  ERD(Entity Relationship Diagram)

    - ERD(Entity Relationship Diagram)는 이와 같은 관계의 의미를 직관적으로 표현할 수 있는 좋은 수단이다.

  ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_158.jpg)

  [

  K-리그 테이블 간의 양방향 관계는 다음과 같다.

  \- 하나의 팀은 여러 명의 선수를 포함할 수 있다. - 한 명의 선수는 하나의 팀에 꼭 속한다.

  \- 하나의 팀은 하나의 전용 구장을 꼭 가진다. - 하나의 운동장은 하나의 홈팀을 가질 수 있다.

  \- 하나의 운동장은 여러 게임의 스케줄을 가질 수 있다. - 하나의 스케줄은 하나의 운동장에 꼭 배정된다.

  ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_159.jpg)

  ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_160.jpg)

  

  \- 하나의 부서는 여러 명의 사원을 보유할 수 있다. - 한 명의 사원은 하나의 부서에 꼭 소속된다.

  ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_161.jpg)

  

  ## DDL

  - ### 데이터 유형

    - 데이터 유형은 데이터베이스의 테이블에 특정 자료를 입력할 때, 그 자료를 받아들일 공간을 자료의 유형별로 나누는 기준이다.

    -  Oracle은 숫자형 타입에 대해서 NUMBER 한 가지 숫자 타입의 데이터 유형만 지원한다.

    - ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_162.jpg)

      - CHARACTER(s)

        - 고정 기리 문자열 정보(oracle SQL 둘다 CHAR로 표현)
        - s는 기본길이 1바이트
        - 오라클은 최대 2000 SQL server는 최대 8000

      - NUMERIC(s)

        - 정수 , 실수 등 숫자 정보(오라클은 NUMBER, SQL은 많다.)
        - 오라클은 처음 전체 숫자를 지정후 소숫점지정한다.
          - Ex) NUMERIC(8,2) ->정수부분이 6자리 소숫점부분이 2자리다.

      - VARCHAR

        - s만큼의 최대 길이를 갖지만 가변길이로 조정이 되기 때문에 할당된 변수값의 바이트만 적용된다. 
        - 1바이트
        - 오라클 최대 4000 , SQL 최대 8000 

      - DATETIME

        - 날짜와 시각정보 (오라클은 DATE.1초단위 ,SQL 은 DATETIME.3.33ms단위 

        

    

    

    

    

    ## DDL

    - ### 데이터 유형

      - 데이터 유형은 데이터베이스의 테이블에 특정 자료를 입력할 때, 그 자료를 받아들일 공간을 자료의 유형별로 나누는 기준이다.
      -  Oracle은 숫자형 타입에 대해서 NUMBER 한 가지 숫자 타입의 데이터 유형만 지원한다.
      - ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_162.jpg)
        - CHARACTER(s)
          - 고정 기리 문자열 정보(oracle SQL 둘다 CHAR로 표현)
          - s는 기본길이 1바이트
          - 오라클은 최대 2000 SQL server는 최대 8000
        - NUMERIC(s)
          - 정수 , 실수 등 숫자 정보(오라클은 NUMBER, SQL은 많다.)
          - 오라클은 처음 전체 숫자를 지정후 소숫점지정한다.
            - Ex) NUMERIC(8,2) ->정수부분이 6자리 소숫점부분이 2자리다.
        - VARCHAR
          - s만큼의 최대 길이를 갖지만 가변길이로 조정이 되기 때문에 할당된 변수값의 바이트만 적용된다. 
          - 1바이트
          - 오라클 최대 4000 , SQL 최대 8000 
        - DATETIME
          - 날짜와 시각정보 (오라클은 DATE.1초단위 ,SQL 은 DATETIME.3.33ms단위 

    

- ## CREATE TABLE

  - PLAYER 테이블 설명 : K-리그 선수들의 정보를 가지고 있는 테이블 칼럼명 : 

  - PLAYER_ID (선수ID) 문자 고정 자릿수 7자리,

  - PLAYER_NAME (선수명) 문자 가변 자릿수 20자리,

  - TEAM_ID (팀ID) 문자 고정 자릿수 3자리,

  - E_PLAYER_NAME (영문선수명) 문자 가변 자릿수 40자리

  - ,NICKNAME (선수별명) 문자 가변 자릿수 30자리,

  - JOIN_YYYY (입단년도) 문자 고정 자릿수 4자리,

  - POSITION (포지션) 문자 가변 자릿수 10자리,

  - BACK_NO (등번호) 숫자 2자리

  - ,NATION (국적) 문자 가변 자릿수 20자리

  - ,BIRTH_DATE (생년월일) 날짜

  - ,SOLAR (양/음) 문자 고정 자릿수 1자리,

  - HEIGHT (신장) 숫자 3자리,

  - WEIGHT (몸무게) 숫자 3자리,

  -  제약조건 : 기본키(PRIMARY KEY) → PLAYER_ID (제약조건명은 PLAYER_ID_PK) 값이 반드시 존재 (NOT NULL) → PLAYER_NAME, TEAM_ID

  - **Oracle** 

  - CREATE TABLE PLAYER (

    -  PLAYER_ID CHAR(7) NOT NULL, 
    - PLAYER_NAME VARCHAR2(20) NOT NULL,
    -  TEAM_ID CHAR(3) NOT NULL,
    -  E_PLAYER_NAME VARCHAR2(40),
    -  NICKNAME VARCHAR2(30), 
    - JOIN_YYYY CHAR(4), 
    - POSITION VARCHAR2(10), 
    - BACK_NO NUMBER(2), 
    - NATION VARCHAR2(20), BIRTH_DATE DATE,
    -  SOLAR CHAR(1),
    -  HEIGHT NUMBER(3),
    -  WEIGHT NUMBER(3), 
    - CONSTRAINT PLAYER_PK PRIMARY KEY (PLAYER_ID),
    -  CONSTRAINT PLAYER_FK FOREIGN KEY (TEAM_ID) REFERENCES TEAM(TEAM_ID) ); 

  - #### 제약조건

    - PRIMARY KEY
      - DBMS는 자동으로 unique 인덱스를 생성하여 기본키를 구성 컬럼에는 NOT NULL
    - UNIQUE KEY
      - 행 데이터를 고유하게 식별하게 하기위한 고유키 ,NULL이 있어도 고유키 제약이 아니다.
    - NOT NULL
    - CHECK
      - 입력할수있는 값의 범위등을 제한한다. TRUE or FALSE 가능하다.
    - FOREIN KEY
      - 기본키를 다른테이블의 외래키로 복사하는 경우이다.
      - 참조 무결성 제약옵션 선택 가능

  - #### 생성된 테이블 구조 확인하는 방법

    - 오라클

      - DESC 테이블이름
      - Describe 테이블이름 ->NOT NULL만 데이터 타입 앞에 나온다.
      - PLAYER_ID NOT NULL CHAR(7)
      -  PLAYER_NAME NOT NULL VARCHAR2(20) 
      - TEAM_ID NOT NULL CHAR(3) 
      - E_PLAYER_NAME VARCHAR2(40) 
      - NICKNAME VARCHAR2(30) 
      - JOIN_YYYY CHAR(4) 
      - POSITION VARCHAR2(10)
      -  BACK_NO NUMBER(2) 
      - NATION VARCHAR2(20) 
      - BIRTH_DATE DATE 
      - SOLAR CHAR(1)
      -  HEIGHT NUMBER(3)
      -  WEIGHT NUMBER(3)

    - SQL SERVER

      - Exec sp_help 'dbo.테이블이름' go -> NULL여부가 나온다.
      - PLAYER_ID CHAR(7) 7 NO
      - PLAYER_NAME VARCHAR(20) 20 NO 
      - TEAM_ID CHAR(3) 3 NO
      -  E_PLAYER_NAME VARCHAR(40) 40 YES
      -  NICKNAME VARCHAR(30) 30 YES 
      - JOIN_YYYY CHAR(4) 4 YES
      -  POSITION VARCHAR(10) 10 YES
      -  BACK_NO TINYINT 1 YES 
      - NATION VARCHAR(20) 20 YES
      -  BIRTH_DATE DATE 3 YES 
      - SOLAR CHAR(1) 1 YES
      -  HEIGHT SMALLINT 2 YES 
      - WEIGHT SMALLINT 2 YES

    -  CREATE TABLE TEAM_TEMP AS SELECT * FROM TEAM

      - 오라클 DESC

      - TEAM_ID NOT NULL CHAR(3) 

        REGION_NAME NOT NULL VARCHAR2(4) 

        TEAM_NAME NOT NULL VARCHAR2(40)

         E_TEAM_NAME VARCHAR2(50) 

        ORIG_YYYY CHAR(4) 

        STADIUM_ID NOT NULL CHAR(3)

         ZIP_CODE1 CHAR(3)

         ZIP_CODE2 CHAR(3)

         ADDRESS VARCHAR2(80) 

        DDD VARCHAR2(3)

        TEL VARCHAR2(10) 

        FAX VARCHAR2(10) 

        HOMEPAGE VARCHAR2(50) 

        OWNER VARCHAR2(10)

      - SQL server

      - TEAM_ID CHAR(3) 3 NO

         REGION_NAME VARCHAR(8) 8 NO 

        TEAM_NAME VARCHAR(40) 40 NO 

        E_TEAM_NAME VARCHAR(50) 50 YES 

        ORIG_YYYY CHAR(4) 4 YES 

        STADIUM_ID CHAR(3) 3 NO 

        ZIP_CODE1 CHAR(3) 3 YES 

        ZIP_CODE2 CHAR(3) 3 YES 

        ADDRESS VARCHAR(80) 80 YES 

        DDD VARCHAR(3) 3 YES 

        TEL VARCHAR(10) 10 YES 

        FAX VARCHAR(10) 10 YES 

        HOMEPAGE VARCHAR(50) 50 YES 

        OWNER VARCHAR(10) 10 YES

- ## ALTER TABLE

  ### ADD COLUMN -오라클은 ()가 붙는다.

  

- 오라클

  - ALTER TABLE PLAYER ADD (ADDRESS VARCHAR2(80)); 

- SQL

  - ALTER TABLE PLAYER ADD ADDRESS VARCHAR(80);

  ### DROP COLUMN - 오라클 sql 같다.

  - ALTER TABLE 테이블명 DROP COLUMN 삭제할 칼럼명;

- 오라클

  - ALTER TABLE PLAYER DROP COLUMN ADDRESS;

- SQL-server

  -  ALTER TABLE PLAYER DROP COLUMN ADDRESS;

- ### MODIFY COLUMN

  - ALTER TABLE 테이블명 MODIFY (칼럼명1 데이터 유형 [DEFAULT 식] [NOT NULL], 칼럼명2 데이터 유형 …);
  - LTER TABLE TEAM_TEMP MODIFY (ORIG_YYYY VARCHAR2(8) DEFAULT '20020129' NOT NULL);
  - SQL SERVER
    - ALTER TABLE TEAM_TEMP ALTER COLUMN ORIG_YYYY VARCAHR(8) NOT NULL; 
    - ALTER TABLE TEAM_TEMP ADD CONSTRAINT DF_ORIG_YYYY DEFAULT '20020129' FOR ORIG_YYYY; 

  

- ### RENAME COLUMN - 오라클과 sql 같다.

  - ALTER TABLE 테이블명 RENAME COLUMN 변경해야 할 칼럼명 TO 새로운 칼럼명
  - 오라클
    - ALTER TABLE PLAYER RENAME COLUMN PLAYER_ID TO TEMP_ID;
  - Sql-server
    - ALTER TABLE PLAYER RENAME COLUMN TEMP_ID TO PLAYER_ID; 

- ### DROP CONSTRAINT-오라클과 sql 같다.

  - ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명;
  - 오라클
    - ALTER TABLE PLAYER DROP CONSTRAINT PLAYER_FK; 
  - sql
    - ALTER TABLE PLAYER DROP CONSTRAINT PLAYER_FK; 

- ### ADD CONSTRAINT -오라클과 sql 같다.

  - ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건 (칼럼명);
  - 오라클
    - ALTER TABLE PLAYER ADD CONSTRAINT PLAYER_FK FOREIGN KEY (TEAM_ID) REFERENCES TEAM(TEAM_ID)
  - sql
    -  ALTER TABLE PLAYER ADD CONSTRAINT PLAYER_FK FOREIGN KEY (TEAM_ID) REFERENCES TEAM(TEAM_ID);

- ## RENAME TABLE

  - RENAME 변경전 테이블명 TO 변경후 테이블명;
  - 오라클
    - RENAME TEAM TO TEAM_BACKUP; 
  - sql
    - sp_rename 'dbo.TEAM','TEAM_BACKUP';
  - rename을 하게되면 스크립트 및 저장 프로시저를 손상시킬수 있다.

- ## DROP TABLE - 오라클과 sql 같다.

- DROP TABLE 테이블명 [CASCADE CONSTRAINT];

  - 제약조건들도 다 삭제한다는 것을 의미한다.
  - sql에서는 테이블을 삭제하기전에 참조하는 foreign key 제약조건 또는 참조하는 테이블을 먼저 삭제해야한다.
    - DROP TABLE PLAYER

- ## TRUNCATE TABLE -오라클과 sql 같다.

- 해당 테이블에 들어있던 모든 행들이 제거되고 저장 공간을 재사용 가능하도록 해제한다.

-  TRUNCATE TABLE TEAM; 

### DDL에서 오라클과 sql중 다른것

- rename table
- Modify column
- add column
- desc 의 결과값



# DML

- ## INSERT

  - INSERT INTO 테이블명 (COLUMN_LIST)VALUES (COLUMN_LIST에 넣을 VALUE_LIST);
  -  INSERT INTO 테이블명VALUES (전체 COLUMN에 넣을 VALUE_LIST);
  -  INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID, POSITION, HEIGHT, WEIGHT, BACK_NO) VALUES ('2002007', '박지성', 'K07', 'MF', 178, 73, 7); 
    - NULL값을 표현하고 싶으면 '' 작은따옴표두개를 붙이던지 NULL이라고 쓴다.

- ## UPDATE

  - UPDATE 테이블명 SET 수정되어야 할 칼럼명 = 수정되기를 원하는 새로운 값;
  - UPDATE PLAYER SET BACK_NO = 99;  (숫자는 작은따옴표 안붙인다.)
  - UPDATE PLAYER SET POSITION = 'MF';  (문자는 따옴표안에 쓴다.

- ## DELETE

  - DELETE [FROM] 삭제를 원하는 정보가 들어있는 테이블명;
  - DELETE FROM PLAYER

---

---



- DDL은 직접 데이터베이스 테이블에 영향을 미치기때문에 DDL을 입력하는 순간 명령어를 즉시 완료한다.(AUTO COMMIT)
- DML(INSERT , UPDATE, DELETE , SELECT)는 테이블을 메모리 버퍼에 올려두기떄문에 실시간 반영이 되진 않는다.
  - 바로하기위해선 COMMIT
    - 하지만 SQL server는 auto commit 된다. DML도
- 테이블 전체 데이터 삭제할때 DELETE TABLE 보다는 TURNCATE TABLE을 권고한다.
  - 하지만 TURNCATE는 로그가 없으므로 ROLLBACK이 불가능하다.
    - 하지만 SQL server는 ROLLBACK 가능하다.

---

---

- ### SELECT

  - ALL은 생략가능
    - [예제] SELECT PLAYER_ID, PLAYER_NAME, TEAM_ID, POSITION, HEIGHT, WEIGHT, BACK_NO FROM PLAYER;
    - SELECT ALL POSITION FROM PLAYER
    - SELECT POSITION FROM PLAYER;
    - SELECT * FROM PLAYER; (와일드카드인 애스터리스크(*) 사용)
  - DISTICNT
    - SELECT DISTINCT POSITION FROM PLAYER;
  - 결과는 문자 및 날짜 데이터는 좌측정렬, 숫자데이터는 우측정렬
  - ALIAS
    - SELECT PLAYER_NAME AS 선수명, POSITION AS 위치, HEIGHT AS 키, WEIGHT AS 몸무게 FROM PLAYER; 
    - SELECT PLAYER_NAME 선수명, POSITION 위치, HEIGHT 키, WEIGHT 몸무게 FROM PLAYER;
    - SELECT PLAYER_NAME "선수 이름", POSITION "그라운드 포지션", HEIGHT "키", WEIGHT "몸무게" FROM PLAYER
      - "선수 이름" 과 같이 컬럼명 사이에 공백이있으면 ""를 무조건 사용

- ### 산술 연산자

  - ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_169.jpg)
  - SELECT PLAYER_NAME 이름, HEIGHT - WEIGHT "키-몸무게" FROM PLAYER;
  - SELECT PLAYER_NAME 이름, ROUND(WEIGHT/((HEIGHT/100)*(HEIGHT/100)),2) "BMI 비만지수" FROM PLAYER;

- ### 합성 연산자

  -  별도의 프로그램 도움 없이도 SQL 문장만으로도 유용한 리포트를 출력할 수 있다.
  - 오라클
    - SELECT PLAYER_NAME || '선수,' || HEIGHT || 'cm,' || WEIGHT || 'kg' 체격정보 FROM PLAYER;
  - SQL
    -  SELECT PLAYER_NAME +'선수, '+ HEIGHT +'cm, '+ WEIGHT +'kg'체격정보 FROM PLAYER;

- # TCL

  - 트랜잭션이란 데이터베이스의 논리적 연산단위이다.
  - 트랜잭션이란 밀접히 관련되어 분리될 수 없는 한개 이상의 데이터베이스 조작
  - ALL or Nothing
  - COMMIT - 올바르게 반영된 데이터를 DB에 반영하는것을 커밋
  - ROLLBACK - 트랜잭션 시작 이전의 상태로 되돌리는 것을 롤백
  - TCL - SAVEPOINT 기능과 함께 3가지 명렁어를 컨트롤한다.
  - 트랜젝션의 대상이 되는것은 update , insert, delete
  - update등 베타적 lock을 요구하는 select도 대상이 될 수 있다.

- ### 트랜잭션의 특성

  - 원자성
    - 모두 성공하던지 모두 실패하던지
  - 일관성 
    - 트랜잭션 이후에도 데이터베이스 내용에 잘못이 있으면 안됨
  - 고립성
    - 다른 트랜잭션의 영향을 받으면 안됨
  - 지속성
    - 성공적으로 수행이 되면 데이터베이스 내용은 영구히 저장

- 원자성을 충족시키기 위해서 LOCKing 기능을 제공하고 있다.





