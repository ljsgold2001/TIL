# TCP

### TCP란?

- 전송계층 ( transport layer) 에서 사용하는 프로토콜
- 안정적인 데이터 전송 메커니즘
  - Checksum - 헤더및 데이터의 에러확인을 위해서 사용되는 16비트
  - Timer - 패킷/(혹은 페킷의 ACK)가 채널 내에서 손실 되었기 때문에 패킷을 타임아웃/재전송
  - Sequence Number - 발신자에서 수신자로 흐르는 데이터 번호의 순차적인 번호매김
  - Acknowledgement - 송신자에게 패킷 또는 페킷의 세트가 올바르게 수신되었다고 알려주는 것
  - Pipelining - 중지 및 대기 작동 모드에서 발신자 활용도를 향상 시킵니다.
    - 파이프라인 이란 ? TCP 가 데이터를 손실없이 안정되게 전송 시키기 위한 기법중에 하나, 보통 CPU가 명령을 수행하기 위해서는 fetch - decode -execute 의 과정을 통하는데 첫번째 커맨드를 fetch 할때 메모리로부터 응답을 기다리는 동안 두번째 커맨드의 fetch 를 시작시키는 것이다.



### TCP OVERVIEW

- Point- to - point  - one sender, one receiver
- Reliable, in-order byte stream(error control) -데이터 변형 ,분실 방지 ( checksum을 이용해서)
- flow controlled - sender will not overflow receiver
- congestion controlled - 네트워크의 패킷의 수가 증가하지 않도록 방지하는 것이다. , 정보의 소통량이 증가하게 되면 패킷을 조금만 전송하여 혼잡 붕괴 현상을 막는다.
- full duplex data - 동일한 연결에서 양방향 데이터 흐름
- connection-oriented -핸드쉐이킹 (제어 메세지 교환 )은 데이터 교환 전에 발신자, 수신자 상태를 체크한다./ 일단 커넥션을 주고 받는다. 서버가 클라이언트에게도 보내고 클라이언트도 서버에게 보낸다.



### Terminologies

- Flow Control : 데이터 처리속도를 조절하여 수신자의 버퍼 오버플로우를 방지한다.수신자가 윈도우 값을 통해서 수신자를 결정할수 있다.
- Congestion Control : 네트워크의 패킷의 수가 증가하지 않도록 방지하는 것이다. , 정보의 소통량이 증가하게 되면 패킷을 조금만 전송하여 혼잡 붕괴 현상을 막는다.
- Error Control : 데이터 변형 , 손실 , 오류를 방지 (check sum을 통해서)/오류를 복구하거나 대응한다.

### 각각의 control의 메커니즘은 다르지만 실행을 할때는 combined된다.

### error control 과 flow control 은 layer 2 인 Data Link에서 해주기도 한다.



### Data link control

- Data link control = flow control + error control
- ARQ (automatic repeat request)을 기반으로 데이터 재전송이 이루어진다.
- ARQ는 주로 Error control을 목적으로 사용되고 Flow control은 ACK에 대한 미응답으로 인해 달성될수있다.
- NACK(Negetive ACK)
- Piggybacking - ACK들과 NACK들의 data frame은 동시에 컨트롤을 위해 사용된다.



<img width="800" alt="스크린샷 2019-10-13 오후 3 44 39" src="https://user-images.githubusercontent.com/48313074/66711955-709f9d80-edd0-11e9-8193-4460c8df4853.png">

- 바이트 단위로 전송될때 버퍼 한칸에 한 바이트씩 차게 된다.
- 분홍색 한바이트가 세그먼트에 축적이되어서 다 차게 되었을 경우에 전송한다.
- 파란색 바이트들은 이미 전송된 바이트들로 아직 지워지지 않는다.
  - why? - timer가 끝날때 까지 ack가 전송되지 않으면 재전송 해주어야 하기때문이다.
  - then? - ack가 전송되면 파란색 바이트들은 지워지게 된다.
- 데이터를 넣고 header를 옮기게 된다.(어플리케이션이 읽어감 read out)
- if 1번 2번 데이터는 왔지만 3번데이터가 안왔는데 4번데이터가 왔을 경우?
  - -적당한 공간을 비워두고 계속해서 받는다 (그러려면 세그먼트들의 길이를 전부다 알아야한다.)



<img width="800" alt="스크린샷 2019-10-13 오후 3 49 56" src="https://user-images.githubusercontent.com/48313074/66712009-2f5bbd80-edd1-11e9-98a6-f2137570d5b8.png">

- TCP헤더의 길이는 가변적이다. 왜냐하면 파란색 부분이 가변적이기 때문이다.(option이 다양할 수있다. 만약 바이트 단위로 깔끔하게 떨어지지 않는다면 padding을 붙여서 깔끔하게 만들어준다.)

- Sequence Numbers = 세그먼트 데이터에서 첫 번째 바이트의 바이트 스트림 "숫자

  - SYN =1 이면 초기 시퀀스의 번호가 된다. ACK번호는 이 값에 1더한값
  - SYN=0 이면 현재 세션의 이 세그먼트 데이터의 최초 바이트 값의 누적 시퀀스 번호

  

<img width="800" alt="스크린샷 2019-10-13 오후 3 56 54" src="https://user-images.githubusercontent.com/48313074/66712066-1c95b880-edd2-11e9-90aa-896a0aa415ac.png">

- 이렇게 Sequence number을 바이트 단위로 사용하는 이유는 크기를 알아야 하기 때문이다. 
- Ex)missing 된 세그먼트의 크기를 알아야 하기 때문이다.



- acknowledgement -다음 바이트의 seq# , 누적 ACK
  - acknowledgement가 의미하는 것은 ? 다음 번으로 들어오게 될 것으로 기대되는 sequence number 이다. if 만약 2001까지 sequence number가 이상없이 들어왔다면 다음번에는 3001번의 sequence number가 들어올 것이다.
  - 이유? 3001번까지 잘받았다면 3001번까지 들어온 것은 모두다 잘 받았다는 뜻이다. cumulative ACK

### Q : how receiver handles out-of-order segments

####A :  TCP의 spec 은 말하지 않는다. implementer에 달려 있다. 그러나 일반적으로 TCP는 세그먼트를 재정렬하고 순서가 지정된 메시지를 프로세스에 전달합니다



### TCP Numbering System

<img width="800" alt="스크린샷 2019-10-13 오후 4 02 40" src="https://user-images.githubusercontent.com/48313074/66712124-e9075e00-edd2-11e9-92ad-2908b4923a73.png">

If random 번호를 2351->3351->4351이라면 ack = 5351

why? 여러가지 커넥션이 있을 수 있기 때문에 구분자 역할을 하기 위해서이다.