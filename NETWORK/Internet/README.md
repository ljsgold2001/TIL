### 인터넷이란 무엇인가?

- 수백만대의 컴퓨터들이 연결된 것이다.
  - Host = End system(모든 네트워크에 접속하는 단말장치)
  - 통신링크 -섬유, 구리선, 무선위성/ 전송률은 bandwidth
- 패킷스위칭이란 ? -그전의 인터넷과 이후의 인터넷을 나누는것
- 네트워크들의 네트워크
- 프로토콜을 이용해서 메세지를 주고받는다.
- 인터넷표준은 RFC/IETF
- 응용프로그램들에 서비스를 제공해주는 인프라
- 앱에 프로그래밍 인터페이스 제공



### 프로토콜이란?

<img width="447" alt="스크린샷 2019-10-19 오후 1 35 54" src="https://user-images.githubusercontent.com/48313074/67138143-44759800-f27a-11e9-93be-dccfde634c90.png">



- 네트워크 엔티티들 사이에 메세지를 전송할때의 format이나 order 그리고 메세지 송수신간에 조치를 취해주는 것을 말한다.



### 네트워크 구조

<img width="303" alt="스크린샷 2019-10-19 오후 2 13 51" src="https://user-images.githubusercontent.com/48313074/67138191-b0f09700-f27a-11e9-9e27-a97a883a4feb.png">

- Network edge -> ex) notebook,pc,mobile ,host: Client&Server
- Access Networks (physical media) - wired/wireless communication Link
- Network Core -> 라우터들을 연결한다 네트워크의 네트워크

### Q how to connect end system to edge router

A- 1.주거용 엑세스망(residential) 2.기관용 엑세스망(instituitional) 3.모바일(mobile)엑세스망을 통해서 연결한다.

### FTTH(fiber to the home)

<img width="601" alt="스크린샷 2019-10-19 오후 2 15 44" src="https://user-images.githubusercontent.com/48313074/67138220-0462e500-f27b-11e9-94e0-1477c01fa95a.png">

ONT - optical network terminator

OLT - optical line terminator

CO(central office)의 OLT로부터 optical fiber을 타고 집까지 광섬유가 들어오는데 optical splitter을 통해서 각각의 집의 ONT로 들어가게된다.

### wireless access networks 에는 wireless LAN과 wide-area-wireless access가 있는데 이 둘의 차이는?

### HOST

<img width="327" alt="스크린샷 2019-10-19 오후 2 25 17" src="https://user-images.githubusercontent.com/48313074/67138326-5821fe00-f27c-11e9-84b4-62e9039c5edb.png">

- Host의 전송기능
  1. application 으로부터 message를 받는다.
  2. 길이가 L비트로 알려진 더작은 chunk로 분할한다.
  3. 전송속도 R로 엑세스 네트워크에 전송한다.
  4. transmission delay - >링크에까지 올리는데 걸리는 시간 L/R
- Link capacity = link bandwidth



### The Network Core

- 상호작용이 있는 라우터들끼리의 그물망

- 패킷스위칭 ->application layer에서 메세지를 페킷으로 나누고 그 패킷들은 fully capacity상태로 전송된다.

### Internet sturcture

<img width="497" alt="스크린샷 2019-10-19 오후 2 31 48" src="https://user-images.githubusercontent.com/48313074/67138383-31b09280-f27d-11e9-9af9-85a4ac8bcb63.png">

1. Tier 1( ISP)  ex) AT&T - national과 international coverage

2. IXP - ISP들 끼리를 연결시켜준다 

3. Content provider network ex)google 데이터 센터와 인터넷을 연결시켜주고 종종 ISP를 우회하는 개인 네트워크

   



