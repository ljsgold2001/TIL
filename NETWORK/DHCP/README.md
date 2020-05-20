# IP address configuragtionp(DHCP)

----

- Q : Host는 어떻게 IP주소를 가져오는 것인가?
- 
-  Manual : 시스템 관리자가 파일안에 하드 코딩한다.

- window : control-panel ->network ->configuration->tcp/ip->properties
- UNIX : /etc/rc.config
- Dynamic
- DHCP : Dynamic Host configuration Protocol
- plug and play



###IP주소의 동적할당이 좋은 이유들

----



- IP 주소는 주문이 들어와야 할당한다.
- 수동 IP 구성 방지
- laptop의 이동성 지원한다.



## DHCP

- 1993년부터

- BOOTP의 확장버전(bootstrap protocol)

  - UDP 메세지로부터 전송된다(UDP port 67  그리고 68)
  - 한정된 broadcast 주소를 사용한다.(255.255.255.255)
  - IP주소를 할당 

- 목적 

  - host가 네트워크에 가입할때 네트워크 서버에서 IP를 동적으로 가져오게한다.
    - 사용중인 주소에서 임대를 갱신할 수 있다.
    - 주소를 재사용할 수 있다.
    - 연결되어있는동안 주소를 유지할 수 있다.
    - 네트워크에 참여하려는 모바일 사용자 지원이 가능하다.

  



### 2Type of Broadcast address

----

- loca broadcast(limited broadcast)
  - 주소는 255.255.255.255이다.
    - 해당 주소로 전송된 트래픽들은 같은 로컬 네트워크에 있는 모든 호스트들에게 전송된다.
    - 라우팅이 가능한 주소가 아니기 때문에 라우터는 라우트하지 않는다.
- directed broadcast address
  - 특정 서브넷의 모든 host들에게 전송한다.
    - 예를 들어 10 .0.0.0/8에대한 브로드캐스트 주소는 10.255.255.255이다.
    - 이 주소는 라우트할수있는 주소이다 따라서 라우터가 라우터를 구성한 경우 최종 목적지의 게이트웨이 까지 전달한다.

### DHCP srver client scenario

----

![image](https://user-images.githubusercontent.com/48313074/70320564-65b13880-1868-11ea-8508-f8e9244ae055.png)



- DHCP discover 	
  - host가 boradcast 메세지를 보낸다.
- DHCP offer
  - DHCP server가 대답한다.
- DHCP request
  - host가 IP address 를 요구한다.
- DHCP ack
  - DHCP server가 주소를 보낸다.



### DHCP message format

---

![image](https://user-images.githubusercontent.com/48313074/70320791-f38d2380-1868-11ea-87eb-5b38b01c1b8c.png)

- Opcode 
  - 1 -request
  - 2-reply
- Hardware Type
  - 1- for ethernet
- Hardware address length
  - 6- for ethernet
- Hop count
  - 패킷이 이동할 수 있는 최대홉수
- Transcation ID
  - 이 필드는 client에 의해서 채워지고 자신이보낸 패킷에 대한 request, reply인지 구별하는데 사용된다.
- seconds
  - Client ip 주소를 취득/갱신 한 후로부터의 시간



### DHCP Message type

---

- 메세지 타입은 옵션으로서 전송된다.
  - 1 - DHCP discover
  - 2 - DHCP offer
  - 3 - DHCP request
  - 4 - DHCP decline
  - 5 - DHCP ack
  - 6 - DHCP nak
  - 7- DHCP release
  - 8- DHCP inform
- 다른 DHCP 정보는 옵션으로서 전송된다
- 임대갱신(임대 기간의 50%가 만료되었을때)
  - 만약에 DHCP가 DHCP Nack을 보낸다면 주소가 release 된다.



### DHCP : more than IP address

---

- DHCP 는 application 레이어 프로그램이다.
- 서버-클라이언트 페러다임을 사용한다.
- 실제로는 Network 레이어에서 실제로는 TCP/IP 를 도와준다.
- DHCP 는 서브넷에 할당된 IP주소 이상을 반환할 수 있다.
  - client의 첫번째 홉의 라우터 주소
  - ip address의 이름과 DNS 서버
  - 네트워크 마스크
    - 네트워크부분과 호스트 부분의 주소 표시



































