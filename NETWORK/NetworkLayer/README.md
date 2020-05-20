# Network Layer

---



### Packetizing

---

- payload를 출발지에서 Network layer계층의 packet으로 encapsulate하고  도착지에서 Network layer로 부터 decapsulate 한다.
- payload를 출발지에서 도착지까지 변환하거나 사용하지 않고 전달한다.(예를들면 편지배달부는 편지를 배달할때 편지를 읽지 않는다.)



### Routing and Forwarding

----

- forwarding - 결정된 경로되로 ( 적절한 input에서 output으로) 페킷을 움직이는 것이다.
- routing - 패킷이 이동할 경로가 많기때문에 그 경로를 미리 지정해 두는 것이다.

![image](https://user-images.githubusercontent.com/48313074/70147467-9fa70100-16e7-11ea-942a-1060cc80688a.png)



- routing algorithm은 end에서 end까지의 경로를 정하는 것이다.
- Forwarding table은 output 를 결정한다.

### Connection setup

---

- 3개의 중요한 기능들 network 아키텍쳐에서
  - ATM , Frame , Relay , X.25
  - 데이터그램이 전송되기전에 두 호스트와 전달되는 라우터들 간에 virtual connection이 생성된다.
    - 이런것들이 과거에는 존재했다. 만약에 패킷 50개가 따닥따닥 붙어있으면 그렇게까지 도착할 수 있도록 해준다. Connection setup을 해주지않으면 그렇게 도착할 수가 없다.

### IP

-----



![image-20191205184252314](/Users/jisoolee/Library/Application Support/typora-user-images/image-20191205184252314.png)



- IP는 모래시계형 internet protocol architecture에서의 중간이다.
- multiple higher layer protocol
- multiple lower layer protocol
- Network layer에는 단한가지의 프로토콜만 존재한다.



### IP service

---

- IP의 delivery서비스는 minimal하다.(하는 일이 없는 것이 최대 장점이다.)
- IP는 unreliable , connectionless , Best effort를 제공한다.(datagram service라고도 부른다.)
  - Unreliable - IP는 손실된 패킷을 복구하려고 하지 않는다.
  - Connection less 
    - 각각의 패킷들(datagram)은 독립적으로 사용된다.
    - IP는 host간에 논리적인 순서로 전달될 수 있다는 것을 인식하지 못한다.
  - Best Effort
    - 이 말의 뜻은 어떠한 것도 보장해 주지 않는다는 것이다.
    - 즉 최선을 다해서 널럴한 네트워크 환경이라면 많은 트래픽을 보낸다는 뜻이고 널럴하지 않다면 딱 그만큼만 최선을 다해서 보낸다는 뜻이다.(결국에는 부정적인 말)
- 결과
  - 더 높은 레이어 프로토콜들이 loss나 duplicate packe에 대해서 처리해야한다.
  - 패킷들은 순서대로 전달되지 않을 수 있다.



- IP는 3가지 서비스를 제공한다.

  - 1:1 - Unicast

    - 하나의 트래픽을 발송하더라도 다수의 HOST에게 전달한다면 그 트래픽을 HOST의 수 만큼 복사하여 각 HOST에게 전달한다. 따라서 높은 신뢰성을 자랑하지만 트래픽의 수의 증가로 회선에 부담이 될 수 있다.

  - 1:all  - BroadCast

    - 하나의 트래픽이 다수의 HOST에게 전송할때 하나의 트래픽으로 전송한다. 따라서 회선에 부담을 주지는 않지만 받고 싶지 않는 HOST들도 모두다 트래픽을 전달 받게 된다.

  - 1: N - Muticast

    - 원하는 host에게만 트래픽을 전달한다. Uni + Broad

      

![image](https://user-images.githubusercontent.com/48313074/70226667-9162ee80-1794-11ea-82b2-408adfe4725f.png)

- IP multicast는 many-to-many 서비스를 제공하기도 한다.
- IP multicast는 다른프로토콜을 지원해야한다.(IGMP, multicast routing)
  - 하나를 복사해서 여러군대로 보내주는 것이다 예를 들면 NAVER CAST



### Field of the IP Header

---

![image](https://user-images.githubusercontent.com/48313074/70227997-ebfd4a00-1796-11ea-9c3b-a63aa8fa6600.png)



- Version(4bit) - ip protocol version number이다. 현재 버전은 4이고 그후에는 6이다.
- Header length(4bits) - IP header의 length 이다.(4byte의 배수이다.)
- DS/ECN(1byte)
  - 이 필드는 Type of Service ( TOS)라고부른다.
  - 이 필드의 역할은 재정의 되었다. 그러나 TOS의 해석과 "역방향으로 호환된다."
  - 사용자에게 제공하는 서비스의 품질에 관련된 내용을 다룬다.
    - DS ( Differentiated Service) 6bits	
      - 서비스의 level을 지정하는데 사용된다.(현재의 인터넷에는 사용되지 않음)
    - ECN(Explicit congestion Notification) 2 bits
      - TCP에서 사용되는 새로운 메커니즘
- TTL(time to live) 1byte
  - 페킷이 삭제되기 전에 가장 긴 경로를 지정한다.
  - TTL 필드의 역할
    - 라우팅 루프가 발생되엇을때 패킷으 드롭되는것을 확정짓는다.
      - sender의 값지정
      - 라우터는 value 값을 1씩 감소시킨다.
      - value값이 0에 도달하면 패킷을 드롭시킨다.
- Protocol(1byte)
  - 상위계층 프로토콜을 지정한다.
  - 상위계층의 demultiplexing에 사용된다.
- Header checksum(2byte)
  - 단순히 긴 16비트짜리 체크섬이다 페킷의 헤더에 의해 계산되는
- Options
  - 보안제한
  - Record Route : 패킷을 처리하는 각 라우터는 헤더에 IP주소를 추가시켜준다.
  - Timestamp : 라우터는 패킷을 처리하는 ip주소와 시간을 헤더에 추가한다.
  - loose source routing : 통과해야하는 라우터의 목록을 지정한다.
  - Strict source routing : 통과할수 있는 유일한 라우터를 지정한다.
- Padding
  - 패딩 바이트들은 헤더가 4바이트의 경계애서 끝나도록 추가된다.



### MTU

----

- IP페킷의 최대 크기는 65535이지만 데이터링크 프로토콜은 이것보다 훨씬 작다.
  - EX) Ethernet 프레임들은 최대 1500바이트의 payload를 가질 수 있다.	
    - 즉 Ethernet Frame 에 encapsulate된 IP패킷들은 1500바이트를 넘을 수 없다.
- Network 혹은 DataLink에서 하나의 프레임 혹은 페킷에 담겨 전송될 수 있는 최대 사이즈를 MTU라고 한다.
  - Ethernet  -1500
  - FDDI -4352
  - 802.3 - 1492
  - 802.5 - 4464
  - ATM AAL5 - 9180
  - PPP - negotiated



### IP Fragmentation, Reassembly

----

![image](https://user-images.githubusercontent.com/48313074/70313765-90e05b80-1859-11ea-938a-d9cd22d6e8d1.png)

-  네트워크들은 각각 다른 link type과 다른 MTU를 갖는다.
- 큰 IP 패킷은 net으로 분할된다
  - 하나의 패킷은 여러개의 패킷으로 분할된다.
  - 최종 목적지에서만 재조립된다.
  - IP의 헤더 비트들은 Fragment들을 식별하고 순서에 관련되어있다.
- Fragmetation은 sender혹은 시작되는 라우터에서 이루어진다.
- 동일한 패킷을 여러번 분할될 수 있다.
- 패킷의 재조립은 도착지에서 이루어진다.

![image](https://user-images.githubusercontent.com/48313074/70315607-49f46500-185d-11ea-9049-525d87dcef98.png)

- Identification - 페킷이 단편화될때 identification이 전부다 동일해 같다는것을 가르쳐준다.
- Flags 
  - DF ( don't fragment) - 패킷이 너무작으면 단편화되면 안되고 버려져야한다.
  - MF( more fragment) - 이 패킷은 단편화의 일부이고 추가적인 단편화된 패킷이 있다는 뜻이다.
- Fragment offset
  - 단편화 되기전 데이터의 시작으로부터의 차이
- Total length 
  - 헤더와 데이터의 길이를 합친 현재 fragment의 총 길이

