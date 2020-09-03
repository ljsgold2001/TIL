- 1과목-2

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
  - SQL SERVER**&&**
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

  - 제약조건들도 다 삭제한다는 것을 의미한다.**$$**
  - sql에서는 테이블을 삭제하기전에 참조하는 foreign key 제약조건 또는 참조하는 테이블을 먼저 삭제해야한다.
    - DROP TABLE PLAYER

- ## TRUNCATE TABLE -오라클과 sql 같다.

- 해당 테이블에 들어있던 모든 행들이 제거되고 저장 공간을 재사용 가능하도록 해제한다.

-  TRUNCATE TABLE TEAM; 

- truncate 와 drop은 로그를 남기지 않는다.

- 턴케이트는 디스크용량도 초기화하지만 delete는 초기화하지 못한다.

- drop은 스키마도 없에버린다.

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

------

------



- DDL은 직접 데이터베이스 테이블에 영향을 미치기때문에 DDL을 입력하는 순간 명령어를 즉시 완료한다.(AUTO COMMIT)
- DML(INSERT , UPDATE, DELETE , SELECT)는 테이블을 메모리 버퍼에 올려두기떄문에 실시간 반영이 되진 않는다.
  - 바로하기위해선 COMMIT
    - 하지만 SQL server는 auto commit 된다. DML도
- 테이블 전체 데이터 삭제할때 DELETE TABLE 보다는 TURNCATE TABLE을 권고한다.
  - 하지만 TURNCATE는 로그가 없으므로 ROLLBACK이 불가능하다.
    - 하지만 SQL server는 ROLLBACK 가능하다.

------

------

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



- ## COMMIT - 오라클과 SQL 다름

- 입력한 자료나 수정한 자료에 대해서 또는 삭제한 자료에 대해서 전혀 문제가 없다고 판단 되었을 경우 COMMIT 명령어를 통해서 트랜잭션을 완료할 수 있다.

- 메모리 BUFFER에만 영향을 받았기 때문에 데이터 변경 이전상태로 복구 가능하다.(commit 전) 다른 사용자는 현재 사용자가 수행한 명령의 결과를 볼 수 없다. 변경된 행은 잠금(locking)이 설정 되어서 다른 사용자가 변경할 수 없다.

- **오라클** 

  - INSERT INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO) VALUES ('1997035', 'K02', '이운재', 'GK', 182, 82, 1); 
  - COMMIT (커밋이 생성 되었다.)
  - DELETE FROM PLAYER; 
  - COMMIT(커밋이 생성 되었다.)

- COMMIT 이후시점

  - 데이터에 대한 변경 사항이 데이베이스에 반영된다.
  - 이전 데이터는 영원히 잃어버리게 된다.
  - 사용자는 결과를 볼 수 있다.
  - LOCKING 이 풀리고 행을 조작할 수 있게 된다.

- 오라클은 트랜잭션이 종료되게 되면 항상 COMMIT 이라던지 ROLLBACK을 해주어야하지만 SQL server는 AUTO COMMIT 이기 때문에 자동으로 처리된다.

- **SQL server**

  - Auto commit 이 기본 방식이며 DDL, DML을 수행할때 마다 DBMS가 트랜잭션을 컨트롤 하는 방식이다. 성공하면 자동 COMMIT 실패하면 자동 ROLLBACK
  - 암시적 트랜잭션
    - oracle과 같다. 시작은 DBMS가 처리하고 트랜잭션의 끝은 사용자가 COMMIT 혹은 ROLLBACK처리
    - 인스턴스나 세션 단위로 설정가능
    - 세션단위로 하기 위해서는 SET IMPLICIT TRANSACTION ON설정
  - 명시적 트랜잭션
    - 시작과 끝을 모두다 사용자가 명시적으로 지정한다.
    - BEGIN TRANSACTION(BEGIN IN TRAN 구문도가능)
    - 완료되면 COMMIT TRANSACTION(COMMIT)
    - 혹은 ROLLBACK TRANSACTION(ROLLBACK)
    - ROLLBACK을 만나면 최초의 BEGIN TRANSACTION시점까지 ROLLBACK수행

- ## ROLLBACK - 오라클과 sql 다름

- 데이터 변경사항이 취소되어 데이터의 이전 상태로 복구되며 관련된 행의 LOCKING이 풀리고 데이터를 변경할 수 있게 한다.

- 오라클

  - NSERT INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO) VALUES ('1999035', 'K02', '이운재', 'GK', 182, 82, 1); 
  - ROLLBACK

- SQL

  - auto commit 이 default이기 때문에 명시적으로 해주어야한다.
  - **BEGIN TRAN** INSERT INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO) VALUES ('1999035', 'K02', '이운재', 'GK', 182, 82, 1);
  - ROLLBACK

- 즉 데이터의 변경사항이 취소되고 행에대한 LOCKING이 풀리고 행을 조작할수 있게 된다.

- 무결성 보장 

  - 영구적인 변경을 하기 전에 데이터의 변경사항확인 가능, 논리적으로 연관된 작업을 그룹핑하여 처리 가능

- ## SAVEPOINT

- 저장점을 정의하면 ROLLBACK할때 트랜잭션에 포함된 전체 작업을 rollback하는 것이 아니라 savepoint 까지 일부만 롤백할 수 있다.

- 오라클

  - SAVEPOINT SVPT1;
  - ROLLBACK TO SVPT1;
    -  SAVEPOINT SVPT1; 
    - INSERT INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO) VALUES ('1999035', 'K02', '이운재', 'GK', 182, 82, 1);
    - . ROLLBACK TO SVPT1;

- SQL

  - SAVE **TRANSACTION** SVTR1;
  - ROLLBACK **TRANSACTION** SVTR1;
    - SAVE TRAN SVTR1;
    - . INSERT INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO) VALUES ('1999035', 'K02', '이운재', 'GK', 182, 82, 1); 
    - ROLLBACK TRAN SVTR1; 

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_171.jpg)

  - 그림과 같이 A까지 rollback 을 하게 되면 A이후의 시점은 무효가 되기때문에 B까지 rollback 할 수 없다.
  - 아무 시점 없이 ROLLBACK을 실행하게 되면 모든 변경사항을 취소하고 되돌아 간다.

-  SELECT COUNT(*) FROM PLAYER; ->480

-  SELECT COUNT(*) FROM PLAYER WHERE WEIGHT = 100; ->0

  - INSERT INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO) VALUES ('1999035', 'K02', '이운재', 'GK', 182, 82, 1)



- SAVEPOINT SVPT_A; 
- UPDATE PLAYER SET WEIGHT = 100; 
  - 481개의 행이 수정되었다.



- SAVEPOINT SVPT_B; 
- DELETE FROM PLAYER; 
  - 481개의 행이 삭제 되었다.



- SAVEPOINT B 저장점까지 롤백(ROLLBACK)을 수행하고 롤백 전후 데이터를 확인해본다.
  -  SELECT COUNT(*) FROM PLAYER; COUNT(*)
    - 결과는 0
  - ROLLBACK TO SVPT_B; 이 쿼리문을 실행시킨다.
  - SELECT COUNT(*) FROM PLAYER; COUNT(*)
    - 결과는 481개의 행이 삭제된것들이 실행되지않고
    - 결과는 481
- SAVEPOINT A 저장점까지 롤백(ROLLBACK)을 수행하고 롤백 전후 데이터를 확인해본다.
  - SELECT COUNT(*) FROM PLAYER WHERE WEIGHT = 100; 
    - 결과는 481
  - ROLLBACK TO SVPT_A; 
  - SELECT COUNT(*) FROM PLAYER WHERE WEIGHT = 100;
    - 결과는 0으로 몸무게가 100으로 고쳐덨던 쿼리문이 실행되지 않음
- 트랜잭션 최초 시점까지 롤백(ROLLBACK)을 수행하고 롤백 전후 데이터를 확인해본다
  - SELECT COUNT(*) FROM PLAYER; 
    - 481개의 행이 현재 존재한다.
  - ROLLBACK; 
  - SELECT COUNT(*) FROM PLAYER
    - savepoint 설정하지않았기때문에 모든 트랜잭션이 취소되고 
    - 결과는 480
- **오라클**의 트랜잭션은 sql문장을 시작하면 자동으로 시작되고 Commit이나 rollback을 해주어야 종료된다.
  - 하지만 DDL문장을 실행하면 전후시점 자동 커밋
  - 데이터베이스를 정상적으로 접속종료하면 자동 트랜잭션 커밋
  - 에플리케이션이상종료로 데이터베이스와 단절되면 트랜잭션 자동 롤백
- SQL SERVER는 기본이 AUTO COMMIT방식이다.
  - 하지만 어플리케이션 이상 종료로 데이터베이스와 접속이 단절되면 자동 롤백



- # WHERE 절

- Where 절을 사용하지 않으면 FTS(full table scan)이 일어나게 된다.

- SELECT [DISTINCT/ALL] 칼럼명 [ALIAS명] FROM 테이블명 WHERE 조건식;

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_172.jpg)

- ### 비교연산자

  

- 연산자 우선순위를 염두해두지 않고 where절 을 작성하면 자료를 잘 찾을수 없을 수도 있다.

- SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE TEAM_ID = 'K02' ; ( TEAM ID는 char(3)이기때문에 따옴표 묶어야함)



- 비교연산자가 둘다 char일때
  - char의 크기가 다르면 space로 맞춘다.
  - 서로 다른 문자가나올때까지
  - 달라진 첫번째 문자의 값에따라 크기를 정함
  - blank 수만 다르다면 서로 같은값으로 결정
- 비 연산자의 어느한쪽이 varchar일때
  - 서로 다른 문자가 나올때까지
  - 짧으면 짧은것 까지만
  - 길이가 같고 다른것이 없다면 같다고
  - NOT NULL 까지의 길이를 말함
- 상수값과 비교할 경우
  - 상수쪽을 변수 타입과 동일하게 바꾼다.
  - 변수가 char이면 위의 char유형 넣어줌
  - 변수가 varchar이면 위의 varchar유형 넣어줌



- ### SQL 연산자

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_176.jpg)

- SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키
  FROM PLAYER
  WHERE TEAM_ID IN ('K02','K07');

- SELECT ENAME, JOB, DEPTNO 
  FROM EMP 
  WHERE (JOB, DEPTNO) IN (('MANAGER',20),('CLERK',30));

  - ->다수이면 괄호를 씌워주어야 한다.

-  SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키
  FROM PLAYER 
  WHERE POSITION LIKE 'MF';

  - 위와 같으면 안된다. 와일드카드이용 와일드 카드란?
    - ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_177.jpg)

- SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE PLAYER_NAME LIKE '장%';

- SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE HEIGHT BETWEEN 170 AND 180; 

- NULL이란 값이 존재하지 않는 것으로 확정되지 않는 값을 표현할때 사용한다.

  - 크거나 작지도 않고 0도 아닌 비교불가능한값이다.
  - NULL과 수치연산하면 NULL return
  - NULL과의 비교연산은 FALSE리턴
  - = , > , < 비교 불가능 하면 FALSE

- SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE POSITION = NULL; 

  - 위와같이 하면 실패

- SELECT PLAYER_NAME 선수이름, POSITION 포지션, TEAM_ID 
  FROM PLAYER 
  WHERE POSITION **IS NULL**; (= NULL아니다.)

-  SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE TEAM_ID = 'K02' AND HEIGHT >= 170;

- SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE TEAM_ID IN ('K02','K07') AND POSITION = 'MF';

- **@@@@@@@@@@@@@잘못된 예 @@@@@@@@@@@@@@@@**

- SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키
  FROM PLAYER 
  WHERE TEAM_ID = 'K02' OR TEAM_ID = 'K07' AND POSITION = 'MF' AND HEIGHT >= 170 AND HEIGHT <= 180;

  - **@@@@@@올바른 예 @@@@@@@@@@@@@@@**
  - SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
    FROM PLAYER 
    WHERE (TEAM_ID = 'K02' OR TEAM_ID = 'K07') AND POSITION = 'MF' AND HEIGHT >= 170 AND HEIGHT <= 180;
    - 논리연산자가 여러개 있을 경우에는 ()를 사용해야한다.
      - 순서는 () , NOT , AND, OR
    - @@@@@결과가 같은 예@@@@@@@@@@@2
    - SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
      FROM PLAYER 
      WHERE WHERE TEAM_ID IN ('K02','K07') AND POSITION = 'MF' AND HEIGHT BETWEEN 170 AND 180 ;

- ### 부정 연산자

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_180.jpg)

- SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE TEAM_ID = 'K02' AND NOT POSITION = 'MF' AND NOT HEIGHT BETWEEN 175 AND 185;

- 위와 같은 밑의 코드

- SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE TEAM_ID = 'K02' AND POSITION <> 'MF' AND HEIGHT NOT BETWEEN 175 AND 185;

  - <> ->anis/iso 표준이고 모든운영체제에서 사용가능하고 같지않다는 뜻

- SELECT PLAYER_NAME 선수이름, NATION 국적 
  FROM PLAYER
  WHERE NATION IS NOT NULL;



- ### ROWNUM 

- SELECT PLAYER_NAME 
  FROM PLAYER 
  WHERE ROWNUM = 1; 

- SELECT PLAYER_NAME 
  FROM PLAYER 
  WHERE ROWNUM <= 1;

- SELECT PLAYER_NAME 
  FROM PLAYER 
  WHERE ROWNUM < 2;

- 두 건 이상의 N행을 가지고 오고 싶을때는 rownum =n;처럼사용 불가

- SELECT PLAYER_NAME 
  FROM PLAYER 
  WHERE ROWNUM <= N;

- SELECT PLAYER_NAME 
  FROM PLAYER 
  WHERE ROWNUM

- 테이블 내의 고유한 키나 인덱스 값을 만들수 있다.

  -  UPDATE MY_TABLE SET COLUMN1 = ROWNUM;



- ### TOP/Expression

  - SQL server는 top 절을 이용해서 결과 집합으로 출력되는 행의 개수를 제한 할 수 있다.
  - expression은 반환할 행의 수를 지정하는 숫자이다.
  - Percent: 쿼리 결과 집합에서 처음 expression%의 행만 반환됨
  - with ties : order by만 지정된경우 사용가능
  - Top N (percent)
  - SELECT **TOP(1)** PLAYER_NAME 
    FROM PLAYER; 
  - SELECT **TOP(N)** PLAYER_NAME 
    FROM PLAYER; 
  - orderby는 차이를 부를수잇다.

- # 내장함수 (BUILT IN FUNCTION)

- 벤더에서 제공하는 함수는 built in function과 user defined function으로 나눌 수 있다.

  - 내장함수
    - 단일행함수
      - 문자형, 숫자형,날짜형,변환형,NULL관련
      - select, where, orderby 에 사용가능
    - 다중행 함수 
      - 집계함수 , 그룹함수 , 윈도우함수

- 함수는 아무리 많아도 출력은 하나만 된다는 M:1 관계라는 중요한 특징이 있다.



- ### 문자형 함수

  - LOWER

    - 문자열의 알파벳 문자를 소문자로 바꾸어준다.

  - UPPER

    - 문자열의 알파벳문자를 대문자로 바꾸어준다.

  - ASCII

    - 문자나 숫자를 아스키코드로 변환한다.

  - CHR/CHAR

    - 아스키를 문자나 숫자로 바꾸어준다.

  - CONCAT(str1, str2)

    - 문자열을 연결해주는 것으로 oracle에서는 || sql server 는 +와 동일

  - SUBSTR(oracle)

    - 문자열중에서 m위치에서 n개의 문자길이에 해당하는 문자를 돌려준다.
    - n이 생략되면 끝까지다.

  - SUBSTRING(sql server)

    - 문자열중에서 m위치에서 n개의 문자길이에 해당하는 문자를 돌려준다.
    - n이 생략되면 끝까지다.

  - LENGTH/LEN(문자열)

    - 문자열의 개수를 숫자값으로 돌려준다.

  - LTRIM(문자열 , [, 지정문자])

    - 문자열의 첫 문자부터 확인해서 지정문자가 나타나면 해당 문자를 제거한다. sql server는 공백제거만 가능하다.

  - RTRIM(문자열, [,지정문자])

    - 문자열의 마지막 문자부터 확인해서 지정문자가 나타나면 해당 문자를 제거한다. sql server는 공백제거만 가능하다

  - TRIM(|leading|trailing|both 지정문자 from 문자열)

    - 문자열에서 머리말, 꼬리말, 양쪽에 있는 지정문자를 제거한다.
    - SQL에서는 trim 함수에서 지정문자 사용불가 공백제거만

    

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_183.jpg)

- 오라클

  - SELECT LENGTH('SQL Expert') FROM DUAL;
  - LENGTH('SQL Expert') 
  -  SELECT LEN('SQL Expert') AS ColumnLength;
  - SELECT CONCAT(PLAYER_NAME, ' 축구선수') 선수명 FROM PLAYER;
  -  SELECT PLAYER_NAME || ' 축구선수' AS 선수명 
    - **sql server** 에서는
      - SELECT PLAYER_NAME + ' 축구선수' AS 선수명 FROM PLAYER;
  -  SELECT STADIUM_ID, DDD||TEL as TEL, LENGTH(DDD||TEL) as T_LEN
     FROM STADIUM;
    - 결과
      - D03 063273-1763 11
        B02 031753-3956 11 
        C06 054282-2002 11 
        D01 061792-5600 11 ....
    - SQL에서는
      -  Server SELECT STADIUM_ID, DDD+TEL as TEL, LEN(DDD+TEL) as T_LEN 
        FROM STADIUM;

- ### 숫자형

  - ABS(숫자)
    - 절대값
  - SIGN(숫자)
    - 양수인지 음수인지
  - MOD(int1 , int2)
    - int1을 int2로 나누어 나머지를 리턴함 %로 대체 가능
  - CEIL/CEILING(숫자) ->**오라클/sql**
    - 숫자보다 크거나 같은 최소 정수리턴
  - FLOOR(숫자)
    - 숫자보다 작거나 같은 최대 정수리턴
  - ROUND(숫자 [,m])
    - 숫자를 소숫점 m자리에서 반올림하여 리턴
    - m의 디폴트는 0
  - TRUNC(숫자 [,m])
    - 숫자를 소수 m 자리에서 잘라서 버린다.
    - 디폴트는 0 
    - Sql server는 안된다.
  - SIN,COS,TAN
    - 삼각함수 값을 리턴
  - EXP(),POWER(),SQRT(),LOG(),LN()
    - 지수 , 거듭제곱, 제곱근 , 자연로그값 리턴 



- **![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_185.jpg)**

- SQL

-  소수점 이하 한 자리까지 반올림 및 내림하여 출력한다.

  - SELECT ENAME, ROUND(SAL/12,1), TRUNC(SAL/12,1) 
    FROM EMP

- 정수 기준으로 반올림 및 올림하여 출력한다.

  - SELECT ENAME, ROUND(SAL/12), CEILING(SAL/12) 
    FROM EMP

- ### 날짜형 함수

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_186.jpg)

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_187.jpg)

- 오라클

  - SELECT SYSDATE FROM DUAL;

- sql

  - SELECT GETDATE() AS CURRENTTIME; 

- &&&&&&&&&&&&&&&&&&&&&&&&&익숙하지 않는 부분&&&&&&&&&&&&&&7

- 사원(EMP) 테이블의 입사일자에서 년, 월, 일 데이터를 각각 출력한다. 아래 4개의 SQL 문장은 같은 기능을 하는 SQL 문장이다

  - **오라클**
  - EXTRACT(MONTH FROM HIREDATE) 입사월, EXTRACT(DAY FROM HIREDATE) 입사일 
    FROM EMP;
  - SELECT ENAME, HIREDATE, TO_NUMBER(TO_CHAR(HIREDATE,'YYYY')) 입사년도, TO_NUMBER(TO_CHAR(HIREDATE,'MM')) 입사월, TO_NUMBER(TO_CHAR(HIREDATE,'DD')) 입사일 
    FROM EMP; 
  - **SQL**
  - SELECT ENAME, HIREDATE, DATEPART(YEAR, HIREDATE) 입사년도, DATEPART(MONTH, HIREDATE) 입사월, DATEPART(DAY, HIREDATE) 입사일
     FROM EMP;
  - SELECT ENAME, HIREDATE, YEAR(HIREDATE) 입사년도, MONTH(HIREDATE) 입사월, DAY(HIREDATE) 입사일 
    FROM EMP;

  -

- ### 변환형 함수

  - 데이터타입을 다양한 형식으로 출력하고 싶을 경우 사용하는 것이다.
    - 명시적 데이터 유형 변환
      - 데이터 변환형 함수로 데이터 유형을 변환하도록 명시해 주는 경우
    - 암시적 데이터 유형 변환
      - 데이터베이스가 자동으로 데이터 유형을 변환하여 계산하는 경우
  - 암시적보다는 명시적이 성능도 좋고 정확하다.
  - ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_189.jpg)
  - **오라클**
  - SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD') 날짜, TO_CHAR(SYSDATE, 'YYYY. MON, DAY') 문자형 FROM DUAL;
    - 결과
      - 2012-07-19 2012. 7월 , 월요일
  - **SQL**
    - SELECT CONVERT(VARCHAR(10),GETDATE(),111) AS CURRENTDATE
      - 결과
      - 2012/07/19
  - 금액을 달러와 원화로 표시한다.
  - 오라클
    - SELECT TO_CHAR(123456789/1200,'$999,999,999.99') 환율반영달러, TO_CHAR(123456789,'L999,999,999') 원화 FROM DUAL; 
    - 결과
      - $102,880.66 \123,456,789 
  - 팀(TEAM) 테이블의 ZIP 코드1과 ZIP 코드2를 숫자로 변환한 후 두 항목을 더한 숫자를 출력한다.
    - 오라클
      - SELECT TEAM_ID, TO_NUMBER(ZIP_CODE1,'999') + TO_NUMBER(ZIP_CODE2,'999') 우편번호합 
        FROM TEAM;
    - SQL
      - SELECT TEAM_ID, CAST(ZIP_CODE1 AS INT) + CAST(ZIP_CODE2 AS INT) 우편번호합 FROM TEAM;



- ### CASE 표현

-  ANSI/ISO SQL 표준에는 CASE Expression이라고 표시되어 있다.

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_190.jpg)

- 대표적으로 크게 simpole case expression / searched case expression이 있다.

-  부서 정보에서 부서 위치를 미국의 동부, 중부, 서부로 구분하라.

  - SELECT LOC, 
    		CASE LOC
      			 WHEN
      						 'NEW YORK' THEN 'EAST' 
      			 WHEN 
      						 'BOSTON' THEN 'EAST' 
      		     WHEN 
      						 'CHICAGO' THEN 'CENTER' 
      			 WHEN
      						 'DALLAS' THEN 'CENTER' 
      			 ELSE 
      						 'ETC' 
      		END as AREA
    FROM DEPT;

- 사원 정보에서 급여가 3000 이상이면 상등급으로, 1000 이상이면 중등급으로, 1000 미만이면 하등급으로 분류하라.

  - SELECT ENAME, 
    		CASE
      			 WHEN 
      				SAL >= 3000 THEN 'HIGH' 
      			 WHEN 
      				SAL >= 1000 THEN 'MID' 
      			 ELSE
      				 'LOW' 
      			 END AS SALARY_GRADE 
    FROM EMP;

- 사원 정보에서 급여가 2000 이상이면 보너스를 1000으로, 1000 이상이면 5000으로, 1000 미만이면 0으로 계산한다.

  - SELECT ENAME,SAL
    		CASE
      			WHEN
      				SAL >=2000 THEN 1000
      			ELSE(
      				CASE
      					WHEN 
      						SAL >=1000 THEN 5000
      					ELSE
      						0
      				END)
      		END as BONUS
    FROM EMP;

- ### NULL 관련함수

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_191.jpg)

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_192.jpg)

- 오라클의 경우 NVL사용 SQL일 경우 ISNULL 사용

  - NVL (NULL 판단 대상,‘NULL일 때 대체값’)
  - ISNULL (NULL 판단 대상,‘NULL일 때 대체값’)

- 오라클

  - SELECT NVL(NULL, 'NVL-OK') NVL_TEST FROM DUAL;
  - SELECT NVL('Not-Null', 'NVL-OK') NVL_TEST FROM DUAL; 

- SQL

  - SELECT ISNULL(NULL, 'NVL-OK') ISNULL_TEST
  - SELECT ISNULL('Not-Null', 'NVL-OK') ISNULL_TEST ;

- 선수 테이블에서 성남 일화천마(K08) 소속 선수의 이름과 포지션을 출력하는데, 포지션이 없는 경우는 '없음'으로 표시한다.

  - 오라클
    - SELECT PLAYER_NAME 선수명, POSITION, **NVL(POSITION,'없음')** 포지션 FROM PLAYER
      WHERE TEAM_ID = 'K08'
  - SQL
    - SELEC PLAYER_NAME 선수명, POSITION, **ISNULL(POSITION,'없음')** 포지션 FROM PLAYER 
      WHERE TEAM_ID = 'K08'
      - SELECT PLAYER_NAME 선수명, POSITION, 
                  CASE** 
          				**WHEN POSITION IS NULL**
          					 **THEN '없음'** 
          				**ELSE POSITION** 
          		END AS 포지션** 
        FROM PLAYER 
        WHERE TEAM_ID = 'K08'

  

- 급여와 커미션을 포함한 연봉을 계산하면서 NVL 함수의 필요성을 알아본다.

  - SELECT ENAME 사원명, SAL 월급, COMM 커미션, (SAL * 12) + COMM 연봉A, (SAL * 12) + NVL(COMM,0) 연봉B 
    FROM EMP;

- ### NULL 과 공집합

- 정상적으로 매니저 정보를 가지고 있는 SCOTT의 매니저를 출력한다.

  - SELECT MGR
     FROM EMP 
    WHERE ENAME='SCOTT'; 

- SELECT 1 FROM DUAL WHERE 1 = 2;

  - 대표적으로 공집합을 발생시키는 쿼리이며 위와 같은 조건에 맞는 데이터가 한건도 없는 경우 공집합이라고 하고 NULL 데이터와는 다르게 이해해야한다.

- ### NULL IF

- NULLIF (EXPR1, EXPR2)

  - EXPR1 과 EXPR2이 같으면 NULL을 같지 않으면 EXPR1을 리턴한다.
  - 특정값을 NULL로 대체하는 경우에 유용하게 사용할수 있다.

- 사원 테이블에서 MGR와 7698이 같으면 NULL을 표시하고, 같지 않으면 MGR를 표시한다.

  - SELECT ENAME, EMPNO, MGR, NULLIF(MGR,7698)
    FROM EMP;
    - SELECT ENAME, EMPNO, MGR, 
      		CASE 
        			WHEN MGR = 7698 
        					THEN NULL 
        			ELSE MGR 
        		END
      FROM EMP;

- ### COALESCE

  - 인수의 숫자가 한정되어 있지 않으며 임의의 개수 EXPR에서 NULL이 아닌 최초의 EXPR을 나타낸다. 만약 모든 EXPR이 NULL이라면 NULL 리턴



- 사원 테이블에서 커미션을 1차 선택값으로, 급여를 2차 선택값으로 선택하되 두 칼럼 모두 NULL인 경우는 NULL로 표시한다
  - SELECT ENAME, COMM, SAL, COALESCE(COMM, SAL) COAL 
    FROM EMP;
    - SELECT ENAME, COMM, SAL, 
      		CASE 
        				WHEN COMM IS NOT NULL 
        							THEN COMM
        				ELSE 
        						(CASE 
        								WHEN SAL IS NOT NULL 
        										THEN SAL 
        								ELSE NULL 
        						END) 
        		END COAL
       FROM EMP;



# GROUP BY / HAVING 절

- SELECT COUNT(*) "전체 행수", COUNT(HEIGHT) "키 건수", MAX(HEIGHT) 최대키, MIN(HEIGHT) 최소키, ROUND(AVG(HEIGHT),2) 평균키
   FROM PLAYER;
- 결과값
  - 480 447 196 165 179.31
  - 전체행과 count(height)가 다른것은 후자는  null을 포함하지 않는다.
-  집계 함수의 통계 정보는 NULL 값을 가진 행을 제외하고 수행한다
- 집계 함수는 WHERE 절에는 올 수 없다. (집계 함수를 사용할 수 있는 GROUP BY 절보다 WHERE 절이 먼저 수행된다
- WHERE 절은 전체 데이터를 GROUP으로 나누기 전에 행들을 미리 제거시킨다.
- AVING 절은 GROUP BY 절의 기준 항목이나 소그룹의 집계 함수를 이용한 조건을 표시할 수 있다.
- GROUP BY 절에 의한 소그룹별로 만들어진 집계 데이터 중, HAVING 절에서 제한 조건을 두어 조건을 만족하는 내용만 출력한다.
- 그룹으로 묶어도 자동으로 오름차순정렬이었으나 원칙은 orderby로 정렬해주어야한다.



- K-리그 선수들의 포지션별 평균키는 어떻게 되는가란 요구 사항을 접수하였다. GROUP BY 절을 사용하지 않고 집계 함수를 사용했을 때 어떤 결과를 보이는지 포지션별 평균키를 구해본다.

  - ### 오류

  - SELECT POSITION 포지션, AVG(HEIGHT) 평균키
    FROM PLAYER; 

    - select에서 오류다. 그룹을 정해주지 않았기 때문이다.

  - SELECT POSITION 포지션, AVG(HEIGHT) 평균키 
    FROM PLAYER 
    GROUP BY POSITION 포지션;

    - GROUP BY POSITION 포지션;이부분오류 ALIAS 사용 불가

  - ### 정답

  - SELECT POSITION 포지션, COUNT(*) 인원수, COUNT(HEIGHT) 키대상, MAX(HEIGHT) 최대키, MIN(HEIGHT) 최소키, ROUND(AVG(HEIGHT),2) 평균키
    eFROM PLAYER 
    GROUP BY POSITION;

- ## HAVING

- K-리그 선수들의 포지션별 평균키를 구하는데, 평균키가 180 센티미터 이상인 정보만 표시하라는 요구 사항이 접수되었으므로 WHERE 절과 GROUP BY 절을 사용해 SQL 문장을 작성한다.

- SELECT POSITION 포지션, ROUND(AVG(HEIGHT),2) 평균키 
  FROM PLAYER
  WHERE **AVG(HEIGHT) >= 180  오류 - 집계함수 사용불가**
  GROUP BY POSITION

- 수정후

- SELECT POSITION 포지션, ROUND(AVG(HEIGHT),2) 평균키 
  FROM PLAYER
  GROUP BY POSITION 
  HAVING AVG(HEIGHT) >= 180;

- 논리적 순서는 having 과 group by의 순서가 바뀌어 서 실행된다.
  
  
  
  

- K-리그의 선수들 중 삼성블루윙즈(K02)와 FC서울(K09)의 인원수는 얼마인가란 요구 사항이 접수되었다. WHERE 절과 GROUP BY 절을 사용한 SQL과 GROUP BY 절과 HAVING 절을 사용한 SQL을 모두 작성한다.

- SELECT TEAM_ID 팀ID, COUNT(*) 인원수 
  FROM PLAYER 
  WHERE TEAM_ID IN ('K09', 'K02') 
  GROUP BY TEAM_ID; 

- SELECT TEAM_ID 팀ID, COUNT(*) 인원수 
  FROM PLAYER 
  GROUP BY TEAM_ID 
  HAVING TEAM_ID IN ('K09', 'K02'); 

- 가능하면 where 절에서 제거하는것이 조금더 효율적이다.

- 포지션별 평균키만 출력하는데, 최대키가 190cm 이상인 선수를 가지고 있는 포지션의 정보만 출력한다.

- SELECT POSITION 포지션, ROUND(AVG(HEIGHT),2) 평균키 
  FROM PLAYER 
  GROUP BY POSITION 
  HAVING MAX(HEIGHT) >= 190; 주의요함



- ## CASE 표현을 활용한 월별 데이터 집계

- 집계 함수(CASE( ))~GROUP BY” 기능은 정해진 컬럼수만큼 확장해서 집계보고서를 만드는 기법이다.

- ### step1

  - 먼저 개별 입사정보에서 월별 데이터를 추출하는 작업을 진행한다. 이 단계는 월별 정보가 있다면 생략 가능하다.

    - 오라클

      - SELECT ENAME, DEPTNO, EXTRACT(MONTH FROM HIREDATE) 입사월, SAL 
        FROM EMP;

    - SQL

      - SELECT ENAME, DEPTNO, DATEPART(MONTH, HIREDATE) 입사월, SAL FROM EMP;
      - SELECT ENAME, DEPTNO, MONTH(HIREDATE) 입사월, SAL 
        FROM EMP;

    - 결과물

      - ENAME DEPTNO 입사월 SAL
        SMITH 20 12 800

        ALLEN 30 2 1600
        WARD 30 2 1250
        JONES 20 4 2975 
        MARTIN 30 9 1250 

- ### STEP2(월별 데이터 구분)

- 출된 MONTH 데이터를 Simple Case Expression을 이용해서 12개의 월별 칼럼으로 구분한다. 실행 결과에서 보여 주는 ENAME 칼럼은 최종 리포트에서 요구되는 데이터는 아니지만, 정보의 흐름을 이해하기 위해 부가적으로 보여 주는 임시 정보이다. 

- 이런 긴 문장을 해결해주는 것이 DECODE

- 이분은 그냥 읽어봐



- # ORDER BY

- 정렬을 하기위한 구문으로 ALIAS명이나 컬럼순서를 나타내는 정수도 사용가능

- 별도로 지정하지않으면 오름차순이 적용되며 SQL 문장의 제일 마지막에 위치



- 선수 테이블에서 선수들의 이름, 포지션, 백넘버를 출력하는데 사람 이름을 내림차순으로 정렬하여 출력한다.
  - SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버 
    FROM PLAYER 
    ORDER BY PLAYER_NAME DESC;
- ORDER BY 절의 예로 선수 테이블에서 선수들의 이름, 포지션, 백넘버를 출력하는데 선수들의 포지션 내림차순으로 출력한다. 칼럼명이 아닌 ALIAS를 이용한다.
  - SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버
    FROM PLAYER 
    ORDER BY 포지션 DESC;
- 포지션별로 정렬을 하였는데 NULL이 있을 수도있다. 오라클은 null을 가장큰값으로 출력하지만 sql은 가장작은 값으로 취급



- 한 개의 칼럼이 아닌 여러 가지 칼럼(Column)을 기준으로 정렬해본다. 먼저 키가 큰 순서대로, 키가 같은 경우 백넘버 순으로 ORDER BY 절을 적용하여 SQL 문장을 작성하는데, 키가 NULL인 데이터는 제외한다.
  - SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 FROM PLAYER 
    WHERE HEIGHT IS NOT NULL 
    ORDER BY HEIGHT DESC, BACK_NO;
- 속성과 alias 혼용 가능
- 칼럼명 사용 ORDER BY 절 사용
  - SELECT DNAME, LOC, DEPTNO 
    FROM DEPT 
    ORDER BY DNAME, LOC, DEPTNO DESC;
- Case2. 칼럼명 + ALIAS 명 사용 ORDER BY 절 사용
  - SELECT DNAME DEPT, LOC AREA, DEPTNO 
    FROM DEPT 
    ORDER BY DNAME, AREA, DEPTNO DESC;
- Case3. 칼럼 순서번호 + ALIAS 명 사용 ORDER BY 절 사용
  - SELECT DNAME, LOC AREA, DEPTNO 
    FROM DEPT
     ORDER BY 1, AREA, 3 DESC;

## SELECT 문장 실행 순서

- GROUP BY 절과 ORDER BY가 같이 사용될 때 SELECT 문장은 6개의 절로 구성이 되고, SELECT 문장의 수행 단계는 아래와 같다.

  

  - from
  - where
  - groupby
  - having
  - Select
  - orderby

-  SELECT 절에 없는 EMP 칼럼을 ORDER BY 절에 사용한다.

  - SELECT EMPNO, ENAME
    FROM EMP 
    ORDER BY MGR;
    - select 절에서 사용하지 않은 것을 사용해도 가능

- 인라인 뷰에 정의된 SELECT 칼럼을 메인쿼리에서 사용한다.

  - SELECT EMPNO 
    FROM (SELECT EMPNO, ENAME 
    			FROM EMP 
    			ORDER BY MGR);
    - SELECT MGR FROM (SELECT EMPNO, ENAME 
      									FROM EMP 
        									ORDER BY MGR); 
      **에러발생 SELECT MGR FROM ; * ERROR: "MGR": 부적합한 식별자**
      - 인쿼리 안에 없기 때문이다.
    - SELECT JOB, SAL 
      FROM EMP 
      GROUP BY JOB 
      HAVING COUNT(*) > 0 
      ORDER BY SAL; 
    - **에러발생 그룹으로 묶은 표현식이 아니다.**
    - SELECT JOB 
      FROM EMP 
      GROUP BY JOB 
      HAVING COUNT(*) > 0 
      ORDER BY SAL; 
    - **에러발생 orderby절에 일반컬럼 사용하였기때문에** job아닌 
    - GROUP BY 절 사용시 ORDER BY 절에 집계 칼럼을 사용해본다.
    - SELECT JOB 
      FROM EMP 
      GROUP BY JOB
      HAVING COUNT(*) > 0 
      ORDER BY MAX(EMPNO), MAX(MGR), SUM(SAL), COUNT(DEPTNO), MAX(HIREDATE);

- ## TopN쿼리 

- ### ROWNUM 오라클

- Oracle에서 순위가 높은 N개의 로우를 추출하기 위해

- 데이터의 일부가 먼저 추출된 후(ORDER BY 절은 결과 집합을 결정하는데 관여하지 않음) 데이터에 대한 정렬 작업이 일어나므로 주의해야 한다

- SELECT ENAME, SAL 
  FROM EMP 
  WHERE ROWNUM < 4 
  ORDER BY SAL DESC;

- order by 가 없으면 오라클의 rownum과 sql의 top절은 같은 결과를 보인다. 

- 하지만 order by절이 사용되는 경우 오라클은 orderby보다 먼저 쓰는  where절에서 처리하기 때문에 미리 인라인 뷰에서 정렬을 한후에 써야한다.

  - SELECT ENAME, SAL 
    FROM (SELECT ENAME, SAL 
    			 FROM EMP 
    			 ORDER BY SAL DESC) 
    WHERE ROWNUM < 4 ;

- ### TOP

- TOP (Expression) [PERCENT] [WITH TIES]

- With ties 옵션은 orderly 조건 기준으로 마지막 행으로 표시되는 추가행의 데이터가 같은 경우 N+동일 정렬 순서 데이터를 추가 반환하도록 지정하는 옵션이다.

- 사원 테이블에서 급여가 높은 2명을 내림차순으로 출력하고자 한다.

  -  SELECT TOP(2) ENAME, SAL 
     FROM EMP 
     ORDER BY SAL DESC;

- 사원 테이블에서 급여가 높은 2명을 내림차순으로 출력하는데 같은 급여를 받는 사원이 있으면 같이 출력한다.

  -  SELECT TOP(2) WITH TIES ENAME, SAL 
     FROM EMP 
     ORDER BY SAL DESC;

- # JOIN

- 일반적인 경우 행들은 PRIMARY KEY(PK)나 FOREIGN KEY(FK) 값의 연관에 의해 JOIN이 성립된다. 

- 하지만 어떤 경우에는 이러한 PK, FK의 관계가 없어도 논리적인 값들의 연관만으로 JOIN이 성립 가능하다

- FROM 절에 여러 테이블이 나열되더라도 SQL에서 데이터를 처리할 때는 단 두 개의 집합 간에만 조인이 일어난다.

- A, B, C 테이블이 나열되었더라도 특정 2개의 테이블만 먼저 조인 처리되고, 2개의 테이블이 조인되어서 처리된 새로운 데이터 집합과 남은 한 개의 테이블이 다음 차례로 조인된다. 

- A, B, C, D 4개의 테이블을 조인하고자 할 경우 옵티마이저는 ( ( (A JOIN D) JOIN C) JOIN B)



- ### EQUI JOIN

  - 두 개의 테이블 간에 컬럼 값들이 서로 정확하게 일치하는 경우에 사용하는 방법이다.(PK,FK)기반이다. 반드시 지켜야하지는 않다.

  - SELECT PLAYER.PLAYER_NAME 선수명, TEAM.TEAM_NAME 소속팀명 
    FROM PLAYER, TEAM
     WHERE PLAYER.TEAM_ID = TEAM.TEAM_ID;

    

  -  또는 INNER JOIN을 명시하여 사용할 수도 있다. 

    

  - SELECT PLAYER.PLAYER_NAME 선수명, TEAM.TEAM_NAME 소속팀명 
    FROM PLAYER INNER JOIN TEAM 
    ON PLAYER.TEAM_ID = TEAM.TEAM_ID;

    

  - 두개의 테이블에 중복되는 컬럼이있다면 꼭 테이블이름 명시해주어야한다.

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_195.jpg)

- 선수(PLAYER) 테이블과 팀(TEAM) 테이블에서 K-리그 소속 선수들의 이름, 백넘버와 그 선수가 소속되어 있는 팀명 및 연고지를 알고 싶다는 요구사항을 확인한다

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_196.jpg)

- SELECT PLAYER.PLAYER_NAME, PLAYER.BACK_NO, PLAYER.TEAM_ID, TEAM.TEAM_NAME, TEAM.REGION_NAME 
  FROM PLAYER, TEAM 
  WHERE PLAYER.TEAM_ID = TEAM.TEAM_ID; 

  

- 또는 INNER JOIN을 명시하여 사용할 수도 있다.

  
  
  
  
  

-  SELECT PLAYER.PLAYER_NAME, PLAYER.BACK_NO, PLAYER.TEAM_ID, TEAM.TEAM_NAME, TEAM.REGION_NAME
   FROM PLAYER INNER JOIN TEAM 
  ON PLAYER.TEAM_ID = TEAM.TEAM_ID;



- 좀더 간단하게 ALIAS를 이용하자



- SELECT P.PLAYER_NAME 선수명, P.BACK_NO 백넘버, P.TEAM_ID 팀코드, T.TEAM_NAME 팀명, T.REGION_NAME 연고지
  FROM PLAYER P, TEAM T 
  WHERE P.TEAM_ID = T.TEAM_ID; 

  또는 INNER JOIN을 명시하여 사용할 수도 있다. 

  

  SELECT P.PLAYER_NAME 선수명, P.BACK_NO 백넘버, P.TEAM_ID 팀코드, T.TEAM_NAME 팀명, T.REGION_NAME 연고지 
  FROM PLAYER P INNER JOIN TEAM T 
  ON P.TEAM_ID = T.TEAM_ID;



- 위 SQL 문장의 WHERE 절에 포지션이 골키퍼인(골키퍼에 대한 포지션 코드는 ‘GK’임) 선수들에 대한 데이터만을 백넘버 순으로 출력하는 SQL문을 만들어 본다.



- SELECT P.PLAYER_NAME 선수명, P.BACK_NO 백넘버, T.REGION_NAME 연고지, T.TEAM_NAME 팀명
  FROM PLAYER P, TEAM T 
  WHERE P.TEAM_ID = T.TEAM_ID AND P.POSITION = 'GK'
  ORDER BY P.BACK_NO; 

- 또는 INNER JOIN을 명시하여 사용할 수도 있다. 

  

- SELECT P.PLAYER_NAME 선수명, P.BACK_NO 백넘버, T.REGION_NAME 연고지, T.TEAM_NAME 팀명 
  FROM PLAYER P INNER JOIN TEAM T ON P.TEAM_ID = T.TEAM_ID 
  WHERE P.POSITION = 'GK' 
  ORDER BY P.BACK_NO;



- ### 오류

- SELECT PLAYER.PLAYER_NAME 선수명, P.BACK_NO 백넘버, T.REGION_NAME 연고지, T.TEAM_NAME 팀명 
  FROM PLAYER P, TEAM T 
  WHERE P.TEAM_ID = T.TEAM_ID AND P.POSITION = 'GK' 
  ORDER BY P.BACK_NO;



- **오류 이유**

- SELECT PLAYER.PLAYER_NAME 선수명, P.BACK_NO 백넘버, * 1행에 오류: ERROR: 열명이 부적합하다.



-  팀(TEAM) 테이블과 구장(STADIUM) 테이블의 관계를 이용해서 소속팀이 가지고 있는 전용구장의 정보를 팀의 정보와 함께 출력하는 SQL문을 작성한다.



- SELECT TEAM.REGION_NAME, TEAM.TEAM_NAME, TEAM.STADIUM_ID, STADIUM.STADIUM_NAME, STADIUM.SEAT_COUNT 
  FROM TEAM, STADIUM 
  WHERE TEAM.STADIUM_ID = STADIUM.STADIUM_ID; 

  

- 또는 INNER JOIN을 명시하여 사용할 수도 있다.
  
- SELECT TEAM.REGION_NAME, TEAM.TEAM_NAME, TEAM.STADIUM_ID, STADIUM.STADIUM_NAME, STADIUM.SEAT_COUNT
  FROM TEAM INNER JOIN STADIUM 
  ON TEAM.STADIUM_ID = STADIUM.STADIUM_ID;

  

-  위 SQL문과 ALIAS를 사용한 아래 SQL문은 같은 결과를 얻을 수 있다.

  

-  SELECT T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, S.STADIUM_NAME, S.SEAT_COUNT 
  FROM TEAM T, STADIUM S 
  WHERE T.STADIUM_ID = S.STADIUM_ID; 

- 또는 INNER JOIN을 명시하여 사용할 수도 있다. 
  
  
  
  

- SELECT T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, S.STADIUM_NAME, S.SEAT_COUNT 
  FROM TEAM T INNER JOIN STADIUM S 
  ON T.STADIUM_ID = S.STADIUM_ID; 

- 중복이 되지 않는 칼럼의 경우 ALIAS를 사용하지 않아도 되므로, 아래 SQL 문은 위 SQL문과 같은 결과를 얻을 수 있다. 그러나 같은 이름을 가진 중복 칼럼의 경우는 테이블명이나 ALIAS가 필수 조건이다. 
  
  
  
  

- SELECT REGION_NAME, TEAM_NAME, T.STADIUM_ID, STADIUM_NAME, SEAT_COUNT
   FROM TEAM T, STADIUM S 
  WHERE T.STADIUM_ID = S.STADIUM_ID;

- **중복되는 ALIAS 만 붙여주면 된다.**



- ## NON EQUI JOIN

- Non EQUI JOIN의 경우에는 “=” 연산자가 아닌 다른(Between, >, >=, <, <= 등) 연산자들을 사용하여 JOIN을 수행하는 것이다



- 어떤 사원이 받고 있는 급여가 어느 등급에 속하는 등급인지 알고 싶다는 요구사항에 대한 Non EQUI JOIN의 사례는 다음과 같다.
-  SELECT E.ENAME, E.JOB, E.SAL, S.GRADE 
  FROM EMP E, SALGRADE S 
  WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;



- SELECT E.ENAME 사원명, E.SAL 급여, S.GRADE 급여등급 
  FROM EMP E, SALGRADE S 
  WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;



- ## 3개 이상의 TABLE JOIN

- 선수 테이블의 소속팀코드(TEAM_ID)가 팀 테이블의 팀코드(TEAM_ID)와 PK-FK의 관계가 있다는 것을 알 수 있고, 운동장 테이블의 운동장코드(STADIUM_ID)와 팀 테이블의 전용구장코드(STADIUM_ID)가 PK-FK 관계인 것을 생각하며 다음 SQL을 작성한다. 세 개의 테이블에 대한 JOIN이므로 WHERE 절에 2개 이상의 JOIN 조건이 필요하다.

  

- SELECT P.PLAYER_NAME 선수명, P.POSITION 포지션, T.REGION_NAME 연고지, T.TEAM_NAME 팀명, S.STADIUM_NAME 구장명
  FROM PLAYER P, TEAM T, STADIUM S 
  WHERE P.TEAM_ID = T.TEAM_ID AND T.STADIUM_ID = S.STADIUM_ID 
  ORDER BY 선수명; 

  

- 또는 INNER JOIN을 명시하여 사용할 수도 있다.

  

-  SELECT P.PLAYER_NAME 선수명, P.POSITION 포지션, T.REGION_NAME 연고지, T.TEAM_NAME 팀명, S.STADIUM_NAME 구장명 
  FROM PLAYER P INNER JOIN TEAM T ON P.TEAM_ID = T.TEAM_ID INNER JOIN STADIUM S 
  ON T.STADIUM_ID = S.STADIUM_ID 
  ORDER BY 선수명;





# 2-2장

## STANDARD SQL

- 현재 기업형 DBMS는 순수 관계형 데이터베이스가 아닌 객체 지원기능이 포함딘 관계형 데이터베이스를 사용하고 있다.



- 일반 집합 연산자
  - Union
    - 공통 교집합의 중복을 없애기 위한 사전작업으로 시스템에 부하를 준다.
    - Union all 공통집합도 중복해서 보여준다.
  - Intersection
    - 두 집합의 공통집합을 추출한다.
  - difference
    - 첫번째 집합에서 두번째집합과의 공통집합 부분을 제외한다.
    - 대다수는 except oracle은 minus를 사용한다.
  - product
    - cross product 라고 불리는 곱집합
    - join 조건이 없는 경우 생길수있는 모든 조합
    - 카티션 product 라고도 함
- 8가지 관계형대수는 4개의 일반 집합 연산자와 순수 관계 연산자로 나뉜다.
- 순수 관계 연산자
  - select
    - where 절로 구성 되어있다.
    - Select 연산과 select 절의 의미는 다른 것이다.
  - project
    - select 절로 구현되어있다.
    - select 절의 컬럼 선택으로 구현된다.
  - (natural join)
    - 다양한 join 조건이 있다.
    - Natural join ,inner join, outer join, using 조건절 ,on 조건절
  - divide
    - 사용되지 않음
    - 



- FROM 절 join 형태
  - INNER JOIN
    - where 절에서부터 사용하던 default옵션으로 join default옵션으로 join 조건에서 동일한 값이 있는 행만 반환한다.
    - Cross join, outer join과 한번에 사용 불가
  - NATURAL JOIN
    - inner join의 하위 개념으로 동일한 이름을 갖는 컬럼에 equi join을 수행한다. Natural inner join 이라고표시가능
  - USING조건절
  - ON 조건절
  - CROSS JOIN
  - OUTER JOIN
  - sql server는 on 조건절만 지원하고 natural join 과 using 조건절을 지원하지 않는다.



- ## INNER JOIN

- 내부 조인이라고 부른다.

- join 조건에서 동일한 값이 있는 행만 반환한다.

- using이나 on 필수



- 예제] 사원 번호와 사원 이름, 소속부서 코드와 소속부서 이름을 찾아본다.

  

- WHERE 절 JOIN 조건 
  SELECT EMP.DEPTNO, EMPNO, ENAME, DNAME 
  FROM EMP, DEPT 
  WHERE EMP.DEPTNO = DEPT.DEPTNO;

  

  

-  위 SQL과 아래 SQL은 같은 결과를 얻을 수 있다. 
  
  
  
  

- FROM 절 JOIN 조건 
  
  
  
  

- SELECT EMP.DEPTNO, EMPNO, ENAME, DNAME 
  FROM EMP INNER JOIN DEPT 
  ON EMP.DEPTNO = DEPT.DEPTNO; 

  INNER는 JOIN의 디폴트 옵션으로 아래 SQL문과 같이 생략 가능하다. 

  SELECT EMP.DEPTNO, EMPNO, ENAME, DNAME
  FROM EMP JOIN DEPT 
  ON EMP.DEPTNO = DEPT.DEPTNO;



- ## NATURAL JOIN

- 동일한 이름을 갖는 모든 컬럼들에 대해  EQUI JOIN수행한다.

- Using, on , where에 join 조건 ,sql server 지원 불가



- 사원 번호와 사원 이름, 소속부서 코드와 소속부서 이름을 찾아본다.
  - SELECT DEPTNO, EMPNO, ENAME, DNAME 
    FROM EMP NATURAL JOIN DEPT;
  - join에 사용한 컬럼들은 같은 유형이어야하며 alias나 테이블명과같은 접두사를 붙일 수 없다.
  - 별도의 순서를 지정해주지 않으면 natural join의 기준이되는 컬럼부터 출력된다.
  - SELECT * FROM EMP NATURAL JOIN DEPT;
    - 결과의 시작은 deptno부터 나오게 된다.
  - 하지만 inner join의 경우 첫번째 두번때 테이블의 컬럼이 순서대로 출력된다.
    - [예제] SELECT * 
      		  FROM EMP INNER JOIN DEPT 
      		  ON EMP.DEPTNO = DEPT.DEPTNO;





- **Oracle** CREATE TABLE DEPT_TEMP AS SELECT * FROM DEPT;
- **SQL Server** SELECT * INTO DEPT_TEMP FROM DEPT;
- UPDATE DEPT_TEMP SET DNAME = 'R&D'
   WHERE DNAME = 'RESEARCH'; 
- UPDATE DEPT_TEMP SET DNAME = 'MARKETING'
   WHERE DNAME = 'SALES'; 
-  SELECT * FROM DEPT_TEMP;



- 실행결과
  - DEPT_TEMP 테이블
  - 10 ACCOUNTING NEW YORK 
    20 R&D DALLAS 
    30 MARKETING CHICAGO 
    40 OPERATIONS BOSTON 
- SELECT * 
  FROM DEPT NATURAL INNER JOIN DEPT_TEMP;
  SELECT * 
  FROM DEPT NATURAL JOIN DEPT_TEMP;



- **실행결과**

  - 10 ACCOUNTING NEW YORK 
    40 OPERATIONS BOSTON

- SELECT * 
  FROM DEPT JOIN DEPT_TEMP 
  ON DEPT.DEPTNO = DEPT_TEMP.DEPTNO AND DEPT.DNAME = DEPT_TEMP.DNAME AND DEPT.LOC = DEPT_TEMP.LOC;

-  위 SQL과 아래 SQL은 같은 결과를 얻을 수 있다. 

  

- SELECT * 
  FROM DEPT, DEPT_TEMP 
  WHERE DEPT.DEPTNO = DEPT_TEMP.DEPTNO AND DEPT.DNAME = DEPT_TEMP.DNAME AND DEPT.LOC = DEPT_TEMP.LOC;



- **실행결과**
- 10 ACCOUNTING NEW YORK 
  10 ACCOUNTING NEW YORK 
  40 OPERATIONS BOSTON 
  40 OPERATIONS BOSTON 



## USING 조건절



- 자연 조인에서는 모든 일치되는 컬럼들에 의해서만 join 이 이루어 진다.
- from 의 using 조건절을 이용하면 같은 이름을 가진 컬럼중에서 원하는 컬럼에 대해서만 선택적으로 equi join이 가능하다. sql server는 지원하지 않는다.

- SELECT * 
  FROM DEPT JOIN DEPT_TEMP 
  USING (DEPTNO)
  - 위와같이 *로 뽑으면 using에서 사용한것이 처음으로 나오게 된다.



- SELECT DEPT.DEPTNO, DEPT.DNAME, DEPT.LOC, DEPT_TEMP.DNAME, DEPT_TEMP.LOC
  FROM DEPT JOIN DEPT_TEMP 
  USING (DEPTNO); 
  - Join 컬럼에대해서는 alias 나 테이블이름과 같은 접두사를 붙일수 없다.
  - DEPT.DEPTNO ->dept no
- SELECT * 
  FROM DEPT JOIN DEPT_TEMP 
  USING (DNAME);
  - 결과는 2개의 행
- SELECT * 
  FROM DEPT JOIN DEPT_TEMP 
  USING (LOC, DEPTNO);
  - 결과는 4개의 행
- SELECT * 
  FROM DEPT JOIN DEPT_TEMP 
  USING (DEPTNO, DNAME);
  - 결과는 2개의 행



- ## ON조건절

- 컬럼명이 달라도 join을 사용할수있다.

- SELECT E.EMPNO, E.ENAME, E.DEPTNO, D.DNAME 
  FROM EMP E JOIN DEPT D 
  ON (E.DEPTNO = D.DEPTNO);

- alias 사용가능

- ### where 절과의 혼용가능

-  **ON 조건절과 WHERE 검색 조건은 충돌 없이 사용할 수 있다.** 부서코드 30인 부서의 소속 사원 이름 및 소속 부서 코드, 부서 코드, 부서 이름을 찾아본다.

  - SELECT E.ENAME, E.DEPTNO, D.DEPTNO, D.DNAME 
    FROM EMP E JOIN DEPT D 
    ON (E.DEPTNO = D.DEPTNO) 
    WHERE E.DEPTNO = 30;

- ON 조건절에 JOIN 조건 외에도 데이터 검색 조건을 추가할 수는 있으나, 검색 조건 목적인 경우는 WHERE 절을 사용할 것을 권고한다. (다만, 아우터 조인에서 조인의 대상을 제한하기 위한 목적으로 사용되는 추가 조건의 경우는 ON 절에 표기되어야 한다.)

  - SELECT E.ENAME, E.MGR, D.DEPTNO, D.DNAME 
    FROM EMP E JOIN DEPT D 
    ON (E.DEPTNO = D.DEPTNO AND E.MGR = 7698); 
  - SELECT E.ENAME, E.MGR, D.DEPTNO, D.DNAME 
    FROM EMP E JOIN DEPT D 
    ON (E.DEPTNO = D.DEPTNO) 
    WHERE E.MGR = 7698;

-  팀과 스타디움 테이블을 스타디움ID로 JOIN하여 팀이름, 스타디움ID, 스타디움 이름을 찾아본다.

- SELECT TEAM_NAME, TEAM.STADIUM_ID, STADIUM_NAME 
  FROM TEAM JOIN STADIUM 
  ON TEAM.STADIUM_ID = STADIUM.STADIUM_ID
  ORDER BY STADIUM_ID;;

  - stadium_id라는 공통 조건이 있기 때문이다.

  

- SELECT TEAM_NAME, STADIUM_ID, STADIUM_NAME 
  FROM TEAM JOIN STADIUM 
  USING (STADIUM_ID) 
  ORDER BY STADIUM_ID;

  - inner join 사용 가능

- SELECT TEAM_NAME, TEAM.STADIUM_ID, STADIUM_NAME 
  FROM TEAM, STADIUM 
  WHERE TEAM.STADIUM_ID = STADIUM.STADIUM_ID 
  ORDER BY STADIUM_ID



- 팀과 스타디움 테이블을 팀ID로 JOIN하여 팀이름, 팀ID, 스타디움 이름을 찾아본다. STADIUM에는 팀ID가 HOMETEAM_ID라는 칼럼으로 표시되어 있다.



- SELECT TEAM_NAME, TEAM_ID, STADIUM_NAME
  FROM TEAM JOIN STADIUM 
  ON TEAM.TEAM_ID = STADIUM.HOMETEAM_ID 
  ORDER BY TEAM_ID; 

  - innerjoin 방식 사용 가능

- SELECT TEAM_NAME, TEAM_ID, STADIUM_NAME 
  FROM TEAM, STADIUM 
  WHERE TEAM.TEAM_ID = STADIUM.HOMETEAM_ID 
  ORDER BY TEAM_ID;

- 공통인 컬럼의 ID가 다르기때문에  using 사용 불가

  

- ## 다중 테이블 JOIN

- 사원과 DEPT 테이블의 소속 부서명, DEPT_TEMP 테이블의 바뀐 부서명 정보를 출력한다.

- SELECT E.EMPNO, D.DEPTNO, D.DNAME, T.DNAME New_DNAME FROM EMP E JOIN DEPT D 
  ON (E.DEPTNO = D.DEPTNO) 
  JOIN DEPT_TEMP T 
  ON (E.DEPTNO = T.DEPTNO); 

- SELECT E.EMPNO, D.DEPTNO, D.DNAME, T.DNAME New_DNAME FROM EMP E, DEPT D, DEPT_TEMP T 
  WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO = T.DEPTNO;

- GK 포지션의 선수별 연고지명, 팀명, 구장명을 출력한다.

- SELECT P.PLAYER_NAME 선수명, P.POSITION 포지션, T.REGION_NAME 연고지명, T.TEAM_NAME 팀명, S.STADIUM_NAME 구장명 
  FROM PLAYER P JOIN TEAM T 
  ON P.TEAM_ID = T.TEAM_ID 
  JOIN STADIUM S 
  ON T.STADIUM_ID = S.STADIUM_ID 
  WHERE P.POSITION = 'GK' 
  ORDER BY 선수명; 

- SELECT P.PLAYER_NAME 선수명, P.POSITION 포지션, T.REGION_NAME 연고지명, T.TEAM_NAME 팀명, S.STADIUM_NAME 구장명 
  FROM PLAYER P, TEAM T, STADIUM S 
  WHERE P.TEAM_ID = T.TEAM_ID AND T.STADIUM_ID = S.STADIUM_ID AND P.POSITION = 'GK' 
  ORDER BY 선수명;



## CROSS JOIN

- join조건이 없는 경우 생길수 있는 모든 데이터 조합이다.
- M*N의 조합이 생길수있다.
- 사원 번호와 사원 이름, 소속부서 코드와 소속부서 이름을 찾아본다.
- SELECT ENAME, DNAME
   FROM EMP CROSS JOIN DEPT 
  ORDER BY ENAME;
- Natural join 은 where 절에서 join 조건을 추가할 수 없지만 cross join은 where 절에 join 조건을 추가 할 수 있다.
- SELECT ENAME, DNAME 
  FROM EMP CROSS JOIN DEPT 
  WHERE EMP.DEPTNO = DEPT.DEPTNO;
- SELECT ENAME, DNAME 
  FROM EMP INNER JOIN DEPT 
  WHERE EMP.DEPTNO = DEPT.DEPTNO;



## OUTER JOIN

## left outer JOIN

- 조인 수행시 좌측 테이블에 해당하는 데이터를 먼저 읽은 후에 나중 표기된 우측테이블에서 join 대상 데이터를 읽어 온다.

  - B의 join 컬럼에서 같은값이 있으면 가져오고 없다면 NULL값으로 가져온다.

- STADIUM에 등록된 운동장 중에는 홈팀이 없는 경기장도 있다. STADIUM과 TEAM을 JOIN 하되 홈팀이 없는 경기장의 정보도 같이 출력하도록 한다.

  - SELECT STADIUM_NAME, STADIUM.STADIUM_ID, SEAT_COUNT, HOMETEAM_ID, TEAM_NAME 
    FROM STADIUM LEFT OUTER JOIN TEAM 
    ON STADIUM.HOMETEAM_ID = TEAM.TEAM_ID 
    ORDER BY HOMETEAM_ID; 
  - SELECT STADIUM_NAME, STADIUM.STADIUM_ID, SEAT_COUNT, HOMETEAM_ID, TEAM_NAME 
    FROM STADIUM LEFT JOIN TEAM 
    ON STADIUM.HOMETEAM_ID = TEAM.TEAM_ID 
    ORDER BY HOMETEAM_ID;

- ## RIGHT OUTER JOIN

- A,B중에 B가 기준이 된다.

- A와 B를 비교해서 A의 join 컬럼에서 같은값이 있으면 해당 데이터를 가져오고 A의 join 컬럼에서 같은 경우가 없으면 A테이블에서 가져오는 컬럼들을 NULL로 채운다.

  

- DEPT에 등록된 부서 중에는 사원이 없는 부서도 있다. DEPT와 EMP를 조인하되 사원이 없는 부서 정보도 같이 출력하도록 한다.

  - ELECT E.ENAME, D.DEPTNO, D.DNAME 
    FROM EMP E RIGHT OUTER JOIN DEPT D 
    ON E.DEPTNO = D.DEPTNO; 
  - SELECT E.ENAME, D.DEPTNO, D.DNAME, D.LOC 
    FROM EMP E RIGHT JOIN DEPT D 
    ON E.DEPTNO = D.DEPTNO;



- ## FULL OUTER JOIN

- A와 B를 left outer join + right outerjoin 한것과 동일하다.

- Union all 이 아닌 union과 같다. 중복된 데이터는 삭제한다.



# 집합연산자

![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_204.jpg)

- Union = 중복행은 하나의 행으로 만든다.
- Union all = 중복행도 그대로 결과가 나온다. ,단순히 결과만
- Intersect =교집합이다 . 중복은 하나의 행으로
- Except =차집합 , 중복행은 하나의 행으로 만듬(minus)
- 집합 연산자는 select 문을 연결 하는 것에 지나지 않는다. oreder by는 가장 마지막에 위치한다.

 1) K-리그 소속 선수들 중에서 소속이 삼성블루윙즈팀인 선수들과전남드레곤즈팀인 선수들에 대한 내용을 모두보고 싶다. 
1) K-리그 소속 선수 중 소속이 삼성블루윙즈팀인 선수들의 집합과K-리그 소속 선수 중 소속이 전남드레곤즈팀인 선수들의 집합의 합집합



SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER 
WHERE TEAM_ID = 'K02' 
**UNION** 
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
 WHERE TEAM_ID = 'K07'



 K-리그 소속 선수들 중에서 소속이 삼성블루윙즈팀인 선수들과 포지션이 골키퍼(GK)인 선수들을 모두 보고 싶다. 
2) K-리그 소속 선수 중 소속이 삼성블루윙즈팀인 선수들의 집합과K-리그 소속 선수 중 포지션이 골키퍼(GK)인 선수들의 집합의 합집합

SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER 
WHERE TEAM_ID = 'K02' 
**UNION** 
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER 
WHERE POSITION = 'GK';





SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER 
WHERE TEAM_ID = 'K02' OR POSITION = 'GK';





K-리그 소속 선수들에 대한 정보 중에서 포지션별 평균키와 팀별 평균키를 알고 싶다. 
3) K-리그 소속 선수 중 포지션별 평균키에 대한 집합과K-리그 소속 선수 중 팀별 평균키에 대한 집합의 합집합



SELECT 'P' 구분코드, POSITION 포지션, AVG(HEIGHT) 평균키 
FROM PLAYER 
GROUP BY POSITION 
UNION 
SELECT 'T' 구분코드, TEAM_ID 팀명, AVG(HEIGHT) 평균키 
FROM PLAYER 
GROUP BY TEAM_ID 
ORDER BY 1;





4) K-리그 소속 선수를 중에서 소속이 삼성블루윙즈팀이면서 포지션이 미드필더(MF)가 아닌 선수들의 정보를 보고 싶다. 
4) K-리그 소속 선수 중 소속이 삼성블루윙즈팀인 선수들의 집합과K-리그 소속 선수 중 포지션이 미드필더(MF))인 선수들의 집합의 차집합



- 오라클
- SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE TEAM_ID = 'K02' 
  MINUS 
  SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE POSITION = 'MF' 
  ORDER BY 1, 2, 3, 4, 5



- sql

  - SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
    FROM PLAYER X 
    WHERE X.TEAM_ID = 'K02' AND NOT EXISTS (
    SELECT 1 
    FROM PLAYER Y 
    WHERE Y.PLAYER_ID = X.PLAYER_ID AND POSITION = 'MF') 
    ORDER BY 1, 2, 3, 4, 5; 

  

  SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE TEAM_ID = 'K02' AND PLAYER_ID NOT IN (SELECT PLAYER_ID FROM PLAYER WHERE POSITION = 'MF') 
  ORDER BY 1, 2, 3, 4, 5;



-  K-리그 소속 선수들 중에서 소속이 삼성블루윙즈팀이면서 포지션이 골키퍼(GK)인 선수들의 정보를 보고 싶다.
   5) K-리그 소속 선수 중 소속이 삼성블루윙즈팀인 선수들의 집합과K-리그 소속 선수 중 포지션이 골키퍼(GK)인 선수들의 집합의 교집합



- SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER 
  WHERE TEAM_ID = 'K02' 
  **INTERSECT** 
  SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키
   FROM PLAYER 
  WHERE POSITION = 'GK' 
  ORDER BY 1, 2, 3, 4, 5;



- SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER X 
  WHERE X.TEAM_ID = 'K02' AND EXISTS (SELECT 1 FROM PLAYER Y WHERE Y.PLAYER_ID = X.PLAYER_ID AND Y.POSITION = 'GK') 
  ORDER BY 1, 2, 3, 4, 5;



- SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키
   FROM PLAYER 
  WHERE TEAM_ID = 'K02' AND PLAYER_ID IN (SELECT PLAYER_ID FROM PLAYER WHERE POSITION = 'GK') ORDER BY 1, 2, 3, 4, 5;





- ## 서브쿼리

- ① 서브쿼리를 괄호로 감싸서 사용한다. 
  ② 서브쿼리는 단일 행(Single Row) 또는 복수 행(Multiple Row) 비교 연산자와 함께 사용 가능하다. 단일 행 비교 연산자는 서브쿼리의 결과가 반드시 1건 이하이어야 하고 복수 행 비교 연산자는 서브쿼리의 결과 건수와 상관 없다.
   ③ 서브쿼리에서는 ORDER BY를 사용하지 못한다. ORDER BY절은 SELECT절에서 오직 한 개만 올 수 있기 때문에 ORDER BY절은 메인쿼리의 마지막 문장에 위치해야 한다.



- 서브쿼리가 사용가능한 곳

  -  SELECT 절 
  - FROM 절 
  - WHERE 절 
  - HAVING 절 
  - ORDER BY 절 
  - INSERT문의 VALUES 절 
  - UPDATE문의 SET 절

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_215.jpg)

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_216.jpg)

- ### 단일행 서브쿼리

  

- 서브쿼리가 단일행 연산 (=, <, <=, >, >=, <>) 일때는 서브쿼리의 결과 건수가 반드시 1건 이하여야한다.

- SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버 
  FROM PLAYER 
  WHERE TEAM_ID = (SELECT TEAM_ID FROM PLAYER WHERE PLAYER_NAME = '정남일') 
  ORDER BY PLAYER_NAME;

  - **만약 정남일이라는 선수가 두명이라면 오류 반환한다.**



- SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버 
  FROM PLAYER 
  WHERE HEIGHT <= (SELECT AVG(HEIGHT) FROM PLAYER) 
  ORDER BY PLAYER_NAME;



- ### 다중행 서브쿼리

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_219.jpg)

- 선수들 중에서 ‘정현수’라는 선수가 소속되어 있는 팀 정보를 출력하는 서브쿼리를 작성하면 다음과 같다.

- SELECT REGION_NAME 연고지명, TEAM_NAME 팀명, E_TEAM_NAME 영문팀명 
  FROM TEAM 
  WHERE TEAM_ID = (SELECT TEAM_ID FROM PLAYER WHERE PLAYER_NAME = '정현수') 
  ORDER BY TEAM_NAME;

- "= " 라는 연산자를 사용했는데 서브쿼리의 결과가 1개 이상이기때문에 에러를 반환한다.

- 따라서 이런식으로 바뀌어야 한다.

- SELECT REGION_NAME 연고지명, TEAM_NAME 팀명, E_TEAM_NAME 영문팀명 
  FROM TEAM 
  WHERE TEAM_ID **IN** (SELECT TEAM_ID FROM PLAYER WHERE PLAYER_NAME = '정현수') 
  ORDER BY TEAM_NAME;

### 다중 컬럼 서브 쿼리 - SQL 지원 안함



- 서브쿼리의 결과가 여러 컬럼이기때문에 메인 쿼리의 조건과 동시에 비교되는 것이다.
- SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
  FROM PLAYER
  WHERE (TEAM_ID, HEIGHT) IN (SELECT TEAM_ID, MIN(HEIGHT)
   FROM PLAYER 
   GROUP BY TEAM_ID)
  ORDER BY TEAM_ID, PLAYER_NAME;

### 연관 서브 쿼리

- 서브쿼리 내에 메인 쿼리 컬럼이 사용되었다.
- SELECT T.TEAM_NAME 팀명, M.PLAYER_NAME 선수명, M.POSITION 포지션, M.BACK_NO 백넘버, M.HEIGHT 키 
  FROM PLAYER M, TEAM T 
  WHERE M.TEAM_ID = T.TEAM_ID AND M.HEIGHT < **( SELECT** **AVG(S.HEIGHT)**
   **FROM PLAYER S** 
  **WHERE S.TEAM_ID = M.TEAM_ID AND S.HEIGHT IS NOT NULL** 
  **GROUP BY S.TEAM_ID )** 
  ORDER BY 선수명;



- EXISTS 서브쿼리를 사용하여 '20120501' 부터 '20120502' 사이에 경기가 있는 경기장을 조회하는 SQL문이다.

  - SELECT STADIUM_ID ID, STADIUM_NAME 경기장명 
    FROM STADIUM A 
    WHERE **EXISTS (SELECT 1** 
    							**FROM SCHEDULE X** 
    							**WHERE X.STADIUM_ID = A.STADIUM_ID AND** 							**X.SCHE_DATE BETWEEN '20120501' AND									'20120502')**

- ### SELECT 절에 서브쿼리 사용하기

-  SELECT PLAYER_NAME 선수명, HEIGHT 키, (SELECT AVG(HEIGHT) FROM PLAYER X WHERE X.TEAM_ID = P.TEAM_ID) 팀평균키 
  FROM PLAYER P

- ### FROM절에서 서브쿼리 사용하기

  - from 절에서 사용하는 서브쿼리를 인라인 뷰라고 한다.
  - 일반적인 뷰를 정적인 뷰라고하고 인라인뷰를 동적뷰라고 한다.
  - 서브쿼리의 컬럼은 메인쿼리에서 사용할 수 없다.
  - 인라인 뷰의 컬럼은 어디서든지 사용가능하다.
    - SELECT T.TEAM_NAME 팀명, P.PLAYER_NAME 선수명, P.BACK_NO 백넘버 FROM (SELECT TEAM_ID, PLAYER_NAME, BACK_NO
      						 FROM PLAYER 
        						 WHERE POSITION = 'MF') P, TEAM T 
      WHERE P.TEAM_ID = T.TEAM_ID 
      ORDER BY 선수명;
  - 오라클
    - SELECT PLAYER_NAME 선수명, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
      FROM (SELECT PLAYER_NAME, POSITION, BACK_NO, HEIGHT 
      			 FROM PLAYER 
      			 WHERE HEIGHT IS NOT NULL 
      			 ORDER BY HEIGHT DESC) 
      WHERE ROWNUM <= 5
  - SQL
    - Server SELECT TOP(5) PLAYER_NAME AS 선수명, POSITION AS 포지션, BACK_NO AS 백넘버, HEIGHT AS 키 
      FROM PLAYER 
      WHERE HEIGHT IS NOT NULL 
      ORDER BY HEIGHT DESC

- ### HAVING 절에서 서브쿼리 사용하기

- 평균키가 삼성 블루윙즈팀의 평균키보다 작은 팀의 이름과 해당 팀의 평균키를 구하는 SQL문을 작성하면 다음과 같다.

- SELECT P.TEAM_ID 팀코드, T.TEAM_NAME 팀명, AVG(P.HEIGHT) 평균키 FROM PLAYER P, TEAM T 
  WHERE P.TEAM_ID = T.TEAM_ID 
  GROUP BY P.TEAM_ID, T.TEAM_NAME 
  HAVING AVG(P.HEIGHT) **< (SELECT AVG(HEIGHT) FROM PLAYER WHERE TEAM_ID ='K02')**



- ### UPDATE문의 SET 절에서 사용하기

- **UPDATE** TEAM A **SET** A.STADIUM_NAME = **(SELECT X.STADIUM_NAME FROM STADIUM X WHERE X.STADIUM_ID = A.STADIUM_ID);**



- ### INSERT 문에서 서브쿼리 이용하기

- INSERT INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID) VALUES(**(SELECT TO_CHAR(MAX(TO_NUMBER(PLAYER_ID))+1**) 
  FROM PLAYER), '홍길동', 'K06');



## 뷰

- 독립성 : 데이터구조가 변경되어도 뷰를 사용하는 응용프로그램은 변경하지 않아도 된다.
- 편리성 : SQL문을 단순하게 작성할 수 있다.
- 보안성: 숨기고 싶은 정보가 존재한다면 정보를 감출 수 있다.



- CREATE VIEW V_PLAYER_TEAM A**S SELECT** P.PLAYER_NAME, P.POSITION, P.BACK_NO, P.TEAM_ID, T.TEAM_NAME **FROM** PLAYER P, TEAM T **WHERE** P.TEAM_ID = T.TEAM_ID;



- CREATE VIEW V_PLAYER_TEAM_FILTER **AS** **SELECT** PLAYER_NAME, POSITION, BACK_NO, TEAM_NAME **FROM** V_PLAYER_TEAM **WHERE** POSITION **IN** ('GK', 'MF');



- # 그룹함수

- ### ROLLUP

- Grouping colums의 수가 N이면 N+1 level의 subtotal이 생성됨





- #### 일반적인 group by 절 사용

  

- SELECT DNAME, JOB, COUNT(*) "Total Empl", SUM(SAL) "Total Sal" 
  FROM EMP, DEPT 
  WHERE DEPT.DEPTNO = EMP.DEPTNO 
  GROUP BY DNAME, JOB;



- #### group by + order By 절 사용

  

- SELECT DNAME, JOB, COUNT(*) "Total Empl", SUM(SAL) "Total Sal" 
  FROM EMP, DEPT 
  WHERE DEPT.DEPTNO = EMP.DEPTNO 
  GROUP BY DNAME, JOB 
  ORDER BY DNAME, JOB;



- #### rollup 함수 사용



- SELECT DNAME, JOB, COUNT(*) "Total Empl", SUM(SAL) "Total Sal" 
  FROM EMP, DEPT 
  WHERE DEPT.DEPTNO = EMP.DEPTNO 
  GROUP BY ROLLUP (DNAME, JOB);



- #### rollup 함수 사용 + order by절 사용

  

-  SELECT DNAME, JOB, COUNT(*) "Total Empl", SUM(SAL) "Total Sal" FROM EMP, DEPT 
  WHERE DEPT.DEPTNO = EMP.DEPTNO 
  GROUP BY ROLLUP (DNAME, JOB) 
  ORDER BY DNAME, JOB ;



- #### grouping 함수 사용

- ROLLUP이나 CUBE에 의한 소계가 계산된 결과에는 GROUPING(EXPR) = 1 이 표시되고, - 그 외의 결과에는 GROUPING(EXPR) = 0 이 표시된다

- SELECT DNAME, GROUPING(DNAME), JOB, GROUPING(JOB), COUNT(*) "Total Empl", SUM(SAL) "Total Sal" 
  FROM EMP, DEPT 
  WHERE DEPT.DEPTNO = EMP.DEPTNO
   GROUP BY ROLLUP (DNAME, JOB);



#### grouping + case

- SELECT 
  	CASE GROUPING(DNAME) 
    		WHEN 1 
    				THEN 'All Departments' 
    		ELSE DNAME 
    				END AS DNAME, 
    	CASE GROUPING(JOB) 
    			WHEN 1 
    				THEN 'All Jobs' 
    			ELSE JOB 
    				END AS JOB, COUNT(*) "Total Empl", SUM(SAL) "Total Sal" 
  FROM EMP, DEPT 
  WHERE DEPT.DEPTNO = EMP.DEPTNO 
  GROUP BY ROLLUP (DNAME, JOB); 



SELECT DNAME, JOB, MGR, SUM(SAL) "Total Sal"
FROM EMP, DEPT 
WHERE DEPT.DEPTNO = EMP.DEPTNO 
GROUP BY ROLLUP (DNAME, (JOB, MGR));



## CUBE

SELECT 
	CASE 
		GROUPING(DNAME) 
				WHEN 1 
						THEN 'All Departments' 
				ELSE DNAME 
				END AS DNAME, 
	CASE 
		GROUPING(JOB) 
				WHEN 1 
					THEN 'All Jobs' 
				ELSE JOB END AS JOB, COUNT(*) "Total Empl", SUM(SAL) "Total Sal" FROM EMP, DEPT 
WHERE DEPT.DEPTNO = EMP.DEPTNO 
GROUP BY CUBE (DNAME, JOB) ;



## grouping sets 함수

-  GROUP BY SQL 문장을 여러 번 반복하지 않아도 원하는 결과를 쉽게 얻을 수 있게 되었다
- 계층 구조인 ROLLUP과는 달리 평등한 관계이므로 인수의 순서가 바뀌어도 결과는 같다
- GROUPING SETS 함수도 결과에 대한 정렬이 필요한 경우는 ORDER BY 절에 명시적으로 정렬 칼럼이 표시가 되어야 한다.



- SELECT DNAME, JOB, MGR, SUM(SAL) "Total Sal" 
  FROM EMP, DEPT 
  WHERE DEPT.DEPTNO = EMP.DEPTNO 
  GROUP BY GROUPING SETS ((DNAME, JOB, MGR), (DNAME, JOB), (JOB, MGR));



- # window 함수

- 행과 행간의 관계를 쉽게 정의하기 위해 만든 함수가 바로 WINDOW FUNCTION이다. 

-  WINDOW 함수는 기존에 사용하던 집계 함수도 있고, 새로이 WINDOW 함수 전용으로 만들어진 기능도 있다.

- 그리고 WINDOW 함수는 다른 함수와는 달리 중첩(NEST)해서 사용하지는 못하지만, 서브쿼리에서는 사용할 수 있다.

- SELECT WINDOW_FUNCTION (ARGUMENTS) OVER ( [PARTITION BY 칼럼] [ORDER BY 절] [WINDOWING 절] ) FROM 테이블 명;

- **ROWS** : 물리적인 단위로 행 집합을 지정
  **RANGE** : 논리적인 단위로 의해 행 집합을 지정
  **BETWEEN ~ AND** : 윈도우의 시작과 끝 위치를 지정
  **UNBOUNDED PRECEDING** : 윈도우 시작 위치가 첫 번째 로우임을 의미
  **UNBOUNDED FOLLOWING** : 윈도우 마지막 위치가 마지막 로우임을 의미
  **[ROW수] PRECEDING** : 윈도우 시작 위치가 ROW수만큼 이전이 시작 로우임을 의미
  **[ROW수] FOLLOWING** : 윈도우 마지막 위치가 ROW수만큼 다음이 마지막 로우임을 의미
  **CURRENT ROW** : 현재 로우까지를 의미

- ## RANK

  - SELECT JOB, ENAME, SAL, 
    	RANK( ) OVER (ORDER BY SAL DESC) ALL_RANK, 
      	RANK( ) OVER (PARTITION BY JOB ORDER BY SAL DESC) JOB_RANK 
    FROM EMP;
  - RANK 함수는 ORDER BY를 포함한 QUERY 문에서 특정 항목(칼럼)에 대한 순위를 구하는 함수이다.
  - 이때 특정 범위(PARTITION) 내에서 순위를 구할 수도 있고 전체 데이터에 대한 순위를 구할 수도 있다. 또한 동일한 값에 대해서는 동일한 순위를 부여하게 된다.
  - Partition by 로 나눔 -> order by로 정렬 동일한 값은 같은 우선순위를 매긴다.
  - 동일 우선순위 매긴후에는 그값뺀이후 부터 정렬

- ## DENSE RANK

- DENSERANK는 동일한우선순위가 여러번나와도 다음은 하나 증가시킨다.

- ## ROW_NUMBER

- 그냥 모든 우선순위를 다매긴다.

- ## SUM

- 파티션별 윈도우의 합을 구하여 준다.

- sql server는 over 절에 orderby 지원하지 않음

- ## MAX 

- 파티션별 윈도우의 최댓값을 보여준다.

- ## MIN

- 파티션별 최소값을 보여준다.

- ## COUNT

- order by sal range between 50 precending and 150 following 

- 앞뒤로 50 뒤로 150 만큼 큰것들 카운트한다.

- ## FIRST VALUE -SQL 지원 x

- min 으로 같은 결과를 얻을 수 있다.

- 파티션별로 가장 처음 나온 값을 구할수있다.

- ## LAST_VALUE-sql지원 x

- max 값으로 같은 결과를 얻을 수 있다.

- 파티션 별로 가장 마지막에 나온 값을 구할 수 있다.

- ## LAG 함수-sql 지원 x

- LAG(SAL)- 한명 앞선 사람의 급여를 가져온다.

- LAG(SAL,2,0) - 두명앞선 사람의 급여를 가져온다 나머진 null

- ## LEAD 함수-sql 지원 x

- LEAD(hiredate,1)

- 이후의 첫번째 행의 값을 가져올수있다.

- 3개의 argument 까지 사용할 수 있따.

- 두번째 argu는 몇번째 행을 가져올것이냐 , 세번째는 Null일경우 바꿔줄 값을 지정한다.

- 

- ## RATIO_TO_REPORT-sqlx

- ex) ratio_to_report((sal) over() ,2) 두번째자리

- ## PERCENT_RANK-sqlx

- Percent_rank() over(pratition by deptno order by sal desc)

- 윈도우별 행의 순서별 백분률

- ## CUME_DIST-sqlx

- Cume_dist() over(partion by deptno order by sal desc)

- 현재 행보다 작거나 같은 건수에 대한 누적 백분율을 구한다.

- 

- ## NTILE -sqlx

- NTLE(4) over(order by sal desc)

- 인자값으로 n등분한 결과를 구할 수있다.

- 

- # DCL

- 트렌잭션을 제어하기 위한 명령어

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_223.jpg)

- DB 접속방법

  - 오라클
    - 유저를 통해 데이터베이스에 접속하는 형태
    - 아이디와 비밀번호 방식으로 인스턴스에 접속
  - SQL SERVER
    - 로그인을 생성해햐함
    - 인스턴스 내에 존재하는 다수의 데이터베이스에 연결하기위하여 유저를 생성하고 로그인과 유저를 매핑해야한다.
      - 로그인의 두가지 방식
        - windows 에 로그인한 정보를 가지고 SQL SERVER에 접속하는 방 즉, window에서 사용자 ID를 확인한다.(kerberos방식보안프로토콜)
        - 혼합모드(SQL + window) 숫자 +문자 + 특수문자

  

- 일반적으로 시스템권한은 일일이 유저에게 부여되지 않는다.

  **오라클**

- Oracle CONN SCOTT/TIGER 연결되었다
  CREATE USER PJS IDENTIFIED BY KOREA7; 
  CREATE USER PJS IDENTIFIED BY KOREA7; 

  - 오류발생 SCOTT은 그러한 권한이 없다. 권한을 부여해야함

- GRANT CREATE USER TO SCOTT - create 권한을 부여
  
  - CREATE USER PJS IDENTIFIED BY KOREA7 성공



​	**SQL**

- Server CREATE LOGIN PJS WITH PASSWORD='KOREA7', DEFAULT_DATABASE=AdventureWorks ->최초로 접속시

- **데이터베이스로 이동**

- USE ADVENTUREWORKS; 
  GO CREATE USER PJS FOR LOGIN PJS WITH DEFAULT_SCHEMA = dbo;

- **생성된 PJS로 로그인**

- 오라클 CONN PJS/KOREA7; 

  - 오 라클 CREATE SESSION권한이 없음
  - GRANT CREATE SESSION TO PJS;

- **PJS 유저로 테이블 생성**

-  CREATE TABLE MENU ( MENU_SEQ INT NOT NULL, TITLE VARCHAR(10) );

  - 오류 : 테이블 생성권한이 없다.

  - **오라클**

    - CONN SYSTEM/MANAGER 
      GRANT CREATE TABLE TO PJS;
       CONN PJS/KOREA7

       CREATE TABLE MENU ( MENU_SEQ NUMBER NOT NULL, TITLE VARCHAR2(10) ); 생성 완료

  - SQL-SERVER

    - GRANT CREATE TABLE TO PJS; 
      GRANT Control ON SCHEMA::dbo TO PJS
      CREATE TABLE MENU ( MENU_SEQ INT NOT NULL, TITLE VARCHAR(10) ); 

### object 권한

- if PJS유저가 생성한 테이블을 SCOTT의 유저가 접속하면 어떻게될까?
  - SQL은 유저는 단지 스키마에 대한 권한만을 가진다.
  - 먼저 SCOTT 유저로 접속하여 PJS.menu 테이블을 조회한다. (객체가 소유한 유저이름을 붙여서 but sql은 스키마의 이름을 붙여야한다.)
- 오라클
  - CONN SCOTT/TIGER
  - SELECT * FROM PJS.MENU; **오류**
- SQL
  -  SELECT * FROM dbo.MENU; **오류**
- 해결
  - PJS로 접속하여 SCOTT에게 테이블 select 권한을 준다.
- GRANT SELECT ON MENU TO SCOTT; 

### ROLE 을 이용한 권한 부여

- 매번 해줄수 없기때문에 중개 역할을 하는 ROLE을 제공한다.
- 시스템 권한과 오브젝트 권한을 모두 부여할수있다.
- 유저에게 직접도 가능하고 , role에 포함하여 부여될수도 있다.



- [예제] JISUNG 유저에게 CREATE SESSION과 CREATE TABLE 권한을 가진 ROLE을 생성한 후 ROLE을 이용하여 다시 권한을 할당한다. 권한을 취소할 때는 REVOKE를 사용한다.
- 오라클
- REVOKE CREATE SESSION, CREATE TABLE FROM JISUNG; 
  - 에러 jinsung은 create session 권한을 가지고 있지 않다.
- SQL
  - REVOKE CREATE TABLE FROM PJS;
- [예제] 이제 LOGIN_TABLE이라는 ROLE을 만들고, 이 ROLE을 이용하여 JISUNG 유저에게 권한을 부여한다.
- Oracle CONN SYSTEM/MANAGER 연결되었다. 
  CREATE ROLE LOGIN_TABLE; 롤이 생성되었다. 
  GRANT CREATE SESSION, CREATE TABLE TO LOGIN_TABLE; 권한이 부여되었다. GRANT LOGIN_TABLE TO JISUNG; 권한이 부여되었다. 
  CONN JISUNG/KOREA7 연결되었다. 
  CREATE TABLE MENU2( MENU_SEQ NUMBER NOT NULL, TITLE VARCHAR2(10)); 테이블이 생성되었다.

![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_227.jpg)

- SQL에서는 ROLE을 생성하여 사용하기 보다는 기본적으로 제공되는 ROLE에 멤버로 참여하는 방식
- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_228.jpg)
- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_229.jpg)



# 절차형 SQL

- 프로시저 , 사용자 정의함수 , 트리거

- PL/SQL은 블록 구조로 되어있어 각 기능별로 모듈화 가능

- 오라클에는 PL/SQL이 내장되어잇다. 여러SQL을 블록으로 묶고 한번에 전부 서버로 보낸다.

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_231.jpg)

- DECLARE

  - Begin - end절에서 사용될 변수와 인수에 대한 정의 및 데이터를 선언한다.

- BEGIN - END

  - SQL과 여러가지 비교문, 제어문 을 이용하여 필요한 로직을 처리하는 실행부

- EXCEPTION

  - 에러가 발생했을 경우에 어떻게 처리할 것인지를 정의하는 부분

- ### PL/SQL 기본 문법

- CREATE [OR REPLACE] Procedure [Procedure_name] ( argument1 [mode] data_type1, argument2 [mode] date_type2, ... ... )
   IS [AS] ... ... 
  BEGIN ... ... 
  EXCEPTION ... ... 
  END; /

- DROP Procedure [Procedure_name];

- or replace 절은 기존의 프로시저를 무시하고 새로운 내용으로 덮어쓰기 하겠다.

- mode에는 세가지가 있다. 

  - IN : 운영체제에서 프로시저로 전달될 변수
  - OUT : 프로시저에서 처리된 결과를 운영체제로 전달
  - INOUT :둘다 실행한다.



- ### T -SQL

- SQL-server를 제어하기위해 ms에서 ANSI/ISO표준에 더한기능

- @@전역변수 / @ 지역변수

- 자료형 선언가능

- 연산자 가능

- 흐름제어 IF-ELSE , WHILE , CASE-THEN 가능

- 오라클은 OR REPLACE 가능하지만 SQL은 create /alter 구문으로 변경해야함

- with 옵션

  - recompile : 런타임에 컴파일 된다.
  - ENCRYPTIONCREATE PROCEDUR : 텍스트가 알아보기 어려운 형식으로 변환된다.
    - 카탈로그 뷰 어디에도 직접 표시되지않음으로 백업해두어야함
  - EXECUTE AS :보안 콘텍스트를 지정한다



- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_233.jpg)

- 오라클

  - CREATE OR REPLACE Procedure p_DEPT_
    insert -------------① ( v_DEPTNO in number, v_dname in varchar2, v_loc in varchar2, v_result out varchar2) IS cnt number := 0; 
    BEGIN 
    	SELECT COUNT(*) INTO CNT -------------② 
    	FROM DEPT WHERE DEPTNO = v_DEPTNO AND ROWNUM = 1; 
    			if 
    				cnt > 0 then -------------③ v_result := '이미 등록된 부서번호이다'; 
    			else 
    				INSERT INTO DEPT (DEPTNO, DNAME, LOC) -------------④ VALUES 				(v_DEPTNO, v_dname, v_loc); 
    				COMMIT; -------------⑤ v_result := '입력 완료!!'; 
    			end if; 
    				EXCEPTION -------------⑥ 
    					WHEN OTHERS 
    						THEN 
    					ROLLBACK; 
    						v_result := 'ERROR 발생'; 
    END; 

- SQL-SERVER

  - CREATE Procedure dbo.p_DEPT_
    		insert -------------① @v_DEPTNO int, @v_dname varchar(30), @v_loc 		
      		varchar(30), @v_result varchar(100) OUTPUT AS 
    DECLARE 
    		@cnt int SET 
    		@cnt = 0 
    		BEGIN 
    			SELECT @cnt=COUNT(*) -------------② 
    			FROM DEPT 
    			WHERE DEPTNO = @v_DEPTNO 
    				IF @cnt > 0 -------------③ 
    					BEGIN SET @v_result = '이미 등록된 부서번호이다' 
    						RETURN 
    						END 
    				ELSE 
    						BEGIN 
    							BEGIN TRAN 
    									INSERT INTO DEPT (DEPTNO, DNAME, LOC) -------------④ 									VALUES (@v_DEPTNO, @v_dname, @v_loc) 
    									IF @@ERROR<>0 
    											BEGIN ROLLBACK -------------⑥ 
    											SET @v_result = 'ERROR 발생' 
    											RETURN 
    											END 
    									ELSE 
    											BEGIN 
    											COMMIT -------------⑤ 
    									SET @v_result = '입력 완료!!' 
    									RETURN 
    END 
    END 
    END

  ## 사용자 정의 함수

  - SUM ,SUBSTR , NVL등의 함수는 벤더에서 미리 만들수있다.
  - RETURN이 반드시 있어야한다.



-  K-리그 8월 경기결과와 두 팀간의 점수차를 ABS 함수를 사용하여 절대값으로 출력한다.
  - SELECT SCHE_DATE 경기일자, HOMETEAM_ID || ' - ' || AWAYTEAM_ID 팀들, HOME_SCORE || ' - ' || AWAY_SCORE SCORE, ABS(HOME_SCORE - AWAY_SCORE) 점수차 
    FROM SCHEDULE 
    WHERE GUBUN = 'Y' AND SCHE_DATE BETWEEN '20120801' AND '20120831' ORDER BY SCHE_DATE;
- ABS함수를 만들어야한다면
  - CREATE OR REPLACE Function UTIL_ABS (v_input in number) ---------------- ① return NUMBER IS v_return number := 0; ---------------- ② BEGIN if v_input < 0 then ---------------- ③ v_return := v_input * -1; else v_return := v_input; end if; RETURN v_return; ---------------- ④ END; /



- ## 트리거

  - DML문이 수행되었을때 데이터베이스에서 자동적으로 동작하게 작성된 프로그램
  - 사용자가 직접호출하는것이 아니다.
    - CREATE OR REPLACE Trigger SUMMARY_SALES ---------------- ① 
      AFTER INSERT ON ORDER_LIST FOR EACH ROW 
      DECLARE ---------------- ② 
      	o_date ORDER_LIST.order_date%TYPE; o_prod 			
      	ORDER_LIST.product%TYPE; 
      	BEGIN 
      			o_date := :NEW.order_date; o_prod := :NEW.product; 
      			UPDATE SALES_PER_DATE ---------------- ③ 
      			SET qty = qty + :NEW.qty, amount = amount + :NEW.amount 		
      			WHERE sale_date = o_date AND product = o_prod; 
      					if SQL%NOTFOUND 
      								then ---------------- ④ 
      									INSERT INTO SALES_PER_DATE VALUES(o_date, 
      									o_prod, :NEW.qty, :NEW.amount); 
      					end if; 
      					END; 

- On EACH ROW : 각 row 마다 트리거 적용

- :NEW : 신규로 입력된 레코드의 정보를 가지고 있는 구조체

- :OLD : 수정, 삭제 되기 전에 레코드를 가지고 있는 구조체

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_238.jpg)

- 프로시저는 Begin-end절에 commit , rollback 같은 TCL 사용가능하다.

- 트리거는 begin-end 절에 TCL 사용 불가하다.



# 2-3장

## 옵티마이저

- 다양한 실행방법들 중에서 최적의 실행 방법을 결정하는 것이다.

- 관계형 데이터베이스는 전달할 뿐이다.

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_239.jpg)

- ### 규칙기반 옵티마이저

  - 규칙(우선순위를)가지고 실행계획 생성
  - 1순위 single row by rowid
    - 하나의 행을 엑세스 , 참조하지 않아도 엑세스 가능
  - 2 순위 single row by unique or primary key
    - 유일 인덱스를 통해서 접근
  - 3순위 composite index
    - A+B+C인덱스 우선순위
  - 4순위 Single column index
    - = 조건으로 검색하는 경우
  - 5순위 Bounded range search on indexed columns
    -  between등
  - 6순위 : Unbounded range search on indexed columns :
    - 한쪽 컬럼만 지정
  - 7순위
    - full table scan

- ### 비용기반 옵티마이저

  - 실행하는 비용이 가장 적은 실행계획을 선택한다.
  - ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_241.jpg)
  - 대안 계획 생성기 :
    -  동일한 결과를 생성하는 다양한 대안 계획을 생성하는 모듈이다.
    - 연산의 적용 순서 변경, 연산 방법 변경, 조인 순서 변경 등을 통해서 생성된다
  - 비용예측기
    -  비용 예측기는 대안 계획 생성기에 의해서 생성된 대안 계획의 비용을 예측하는 모듈이다
    - 집합의 크기 ,분포도 등등

- ### 실행계획

- 요구사항을 처리하기 위한 절차와 방법

  - 조인순서
  - 조인기법
  - 엑세스기법
    - 하나의 테이블을 엑세스할때 사용
  - 최적화정보
    - 비용을 나타낸 것
  - 연산

- ### SQL 자료 흐름도

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_243.jpg)

- 조인순서 TAB1 -> TAB2

- TAB1은 outer table , driving table이라고 한다.

- TAB2 는 inner table , lookup table

- I01_TAB2 방식을 이용하여 인덱스 스캔, 랜덤방식



# 인덱스

- 트리기반 인덱스

  - B 트리 인덱스

    - 브랜치 블록과 리프블록으로 구성된다.

    - ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_244.jpg)

    - 리프블록은 RID 로구성되어있다.

    - 인덱스의 데이터 값이 동일하면 식별자의 순서대로

    - 리프블록은 양방향 링크

    - = ,> ,between에 적합하다.

    - 작으면 왼쪽 포인터 크면 오른쪽포인터 사이값이면 중간 포인터

      

      

  - SQL server의 클러스터형 인덱스

    - 리프페이지가 곧 데이터 페이지이다.
    - 레코드 식별자가 리프 페이지에 없다.
    - 클러스터형 인덱스 (사전)
    - 리프 페이지의 모든 로우는 인덱스 컬럼순으로 물리적으로 정렬된다.
    - 로우는 한가지 순서로만 정렬될수있다.
    - 클러스터형 인덱스는 테이블당 한개만

- ## 전체 테이블 스캔과 인덱스 테이블 스캔

- 전체테이블은 존재하는 모든 데이터를 읽고 맞으면 찾음

- 전체테이블 조건

  - SQL 조건 만족하지 않을때
  - 사용가능 인덱스가 존재하지 않을때
  - 옵티마이저의 취사 선택
  - 병렬처리,힌트사용

- 인덱스 스캔

  - 트리기반 인덱스
  - 컬럼값을 기반으로 데이터를 추출한다.
  - 인덱스 유일 스캔
    - 단하나의 데이터로 추출하는 방식, 
    - 중복을 허락하지 않는다.
    - 단 1건
  - 인덱스 범위 스캔
    - 한건 이상의 데이터를 추출
  - 인덱스 역순 스캔
    - 최대값을 decending으로 빠르게 찾을 수있다.
  - 인덱스 전체 스캔 , 인덱스 고속 전체스캔, 인덱스 스킵 스캔

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_249.jpg)

- 인덱스 스캔은 다른 블록을 더 읽을 필요가 없다.



## 조인 기법

## NL join

 - FOR 선행 테이블 읽음 → 외부 테이블(Outer Table) FOR 후행 테이블 읽음 → 내부 테이블(Inner Table) (선행 테이블과 후행 테이블 조인)

 - 모든 행만큼

 - 선행 테이블의 조건을 만족하는 행의수가 많으면 그만큼한다.

 - 따라서 크기가 작은것을 선행테이블로 선택해야한다.

 - 추출버퍼는 모두 차거나 더이상 결과가 없으면 반환

 - 가능한 결과를 빨리 보여줘야 하는 온라인 프로그램에 적당함

 - ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_250.jpg)

   



## SORT MERGE JOIN

- NL join은 주로 랜덤 엑세스 방식으로 읽는다.

- 대용량 방식으로 읽어야할때 넓은 범위를 읽을때 사용된다.

- 정렬작업이 필요하면 hash join이 낫다.

- 이것은 비동등 조인에서도 사용이 가능하다.

- 조인 컬럼의 인덱스를 사용하지 않기때문에 조인 컬럼의 인덱스가 없어도 사용가능

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_251.jpg)

- ## Hash join

- 해시 기법을 이용하여 조인을 수행한다.

- 위의 두개의 문제와 부담을 줄이는 기법

- ![sql가이드](http://www.dbguide.net/publishing/img/knowledge/SQL_252.jpg)

- 조인 컬럼의 인덱스가 존재하지 않아도 사용할 수있다.

- = 로 수행하는 조인 , 즉 동등 조인에서만 사용한다.

- 해쉬값 알수 없다.

- 해쉬 테이블의 크기가 더커지면 임시 영역에 해쉬 테이블 저장

- 따라서 행의수가 적은 테이블을 선행테이블로 저장

- 선행테이블 build input 후행테이블을 

- 마무리