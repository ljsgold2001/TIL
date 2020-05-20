# ICMP



- Internet Control Message Protocol(ICMP)
  - 인터넷 메세지 제어 프로토콜
- IP는 신뢰할수 없고 연걸없는 전달을 한다.
  - 네트워크 자원을 효과적으로 사용해야 한다.
- 오류보고 혹은 수정 메커니즘은 없다.
  - 에러 리포팅이 필요하다 그리고 수정 방법이 필요하다.
- 쿼리 관리가 없다.
  - 네트워크 관리자는 호스트 혹은 라우터에 대한 정보가 필요하다.

----

- 만약에 라우터가 패킷을 버린다면?
- TTL이 만기된다면?
- 호스트가 모든 패킷을 받지 못한다면?

---

### Position of ICMP in the network layer

![image](https://user-images.githubusercontent.com/48313074/70377516-a38d8a00-1958-11ea-926f-5090af857dda.png)

- TCP/IP에 추가된 특수목적을 지닌 메세지 메커니즘
- ICMP 메세지의 도착지는 ICMP 소프트웨어 모듈이다.
- ICMP는 네트워크 layer이다. 그러나 메세지는 IP packet으로 encapsulate된다.
  - 네트워크 layer로써 IP프로토콜과 같이 사용된다.



### ICMP message type

![image](https://user-images.githubusercontent.com/48313074/70377742-6d053e80-195b-11ea-95f8-838eb989ed7b.png)

- ICMP message
  - Error reporting
  - Query
- ICMP destination unreachable message (code =2 or 3)은 오직 host에의해서만 생성된다.
  - 나머지의 모든것들은 전부다 라우터에 의해서 생성된다.
    - 하지만 라우터는 페킷전달에의한 모든 문제들을 감지할 수 없다.



### contents of data field for error message

---

![image](https://user-images.githubusercontent.com/48313074/70377920-85765880-195d-11ea-824d-e8b9f085cede.png)



- ICMP 에러메세지의 내부
  - 8바이트의 Transport layer의 헤더들이 포함되어있다.
- port number(TCP or UDP) 와 sequence number(TCP) 에 대한 정보를 생성한다.
- 받은 datagram을 ICMP 패킷이 ICMP 헤더를 붙이고 IP 헤더를 붙여서 IP datagram을 보낸다.



### ICMP message format

---

![image](https://user-images.githubusercontent.com/48313074/70377964-26fdaa00-195e-11ea-9f9b-b7dcac17c2d3.png)

- ICMP 공통 헤더

![image](https://user-images.githubusercontent.com/48313074/70377977-56141b80-195e-11ea-8c38-ec6f8d46367e.png)



### echo - request & echo -reply

---

- 진단을 하는 목적으로 설계되었다.
  - host 혹은 라우터들은 echo -request 를 보낼 수 있다.
  - 수신자들은 echo-reply로서 대답을 받을 수 있다.
- Echo-request/reply는 네트워크 관리자로부터 사용되고 특정한 host들에게 접근할 수 있는지에 여부를 테스트한다.
  - 발신자가 어떠한 것이든 세팅할 수 있다.
- EX) ping program



![image-20191208020421486](/Users/jisoolee/Library/Application Support/typora-user-images/image-20191208020421486.png)



### source- quench(type =4 , code = 0)

---

- IP는 flow control 메커니즘을 가지고 있지 않다.
  - 송신자는 라우터 혹은 도착지가 congestion한 상황인지 아닌지 모른다.
- source quench message는 도착지에 congestion으로 인해서 데이터그램이 사라졌는지에대한 여부를 알려준다.
  - 손실된 페킷에 대한 정보를 가르쳐준다.
  - 경로를 따라 congestion을 가르쳐준다.
- 발신자는 congestion이 완료될때 까지 속도를 낮추어야 한다.
- 각각의 datagram으로 congestion에 의해서 삭제되었다는 정보를 보내주어야 한다.
  - 1:1 congestion
  - 1:Many congestion
    - congested 한 라우터는 어떠한 source가 datagram을 빨리보내는지 알 수 없다.



### Redirection with ICMP

---

- 이 메세지는 라우터가 송신 시스템에서 특정의 목적지 까지 가는데 더 짧은 경로를 알리고자 할 때 사용된다.
  - host는 작은 routing system 으로부터 업데이트되고 증가하는 것으로 시작한다.
- 라우터에서 동일한 로컬 네트워크의 호스트로 redirection message가 전송된다.

![image](https://user-images.githubusercontent.com/48313074/70378168-c459dd80-1960-11ea-9f71-2120b382b73b.png)

### Ping and ICMP

---

- Ping 프로그램은 Echo -reply/request 기능을 사용하여 host에 도달할 수 있는 가능성을 test한다.
  - 식별자 : process ID
    - 만약 많은 핑 프로그램이 실행중이라면
  - sequence number 
    - 각 에코 요청에 대한 증가
  - RTT
    - received _reply_time
    - requested_time
      - ICMP 데이터 페킷에 저장된다.



















