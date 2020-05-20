# TCP_handshake



### 2-way handshake

<img width="700" alt="스크린샷 2019-10-14 오전 2 29 09" src="https://user-images.githubusercontent.com/48313074/66719425-74f8a480-ee2a-11e9-86ab-2d90f7284565.png">

- 서버가 대답을 했지만 딜레이가 너무 크다. 즉 , time out 이 됬는 대답이 오지 않았다.

<img width="644" alt="스크린샷 2019-10-14 오전 2 35 16" src="https://user-images.githubusercontent.com/48313074/66719471-49c28500-ee2b-11e9-9ecf-f124722efe0c.png">

- First -  Request의 응답에 서버는 데이터와 응답을 보냈으나 클라이언트는 받지 못했다고 생각해서 다시 request를 보냈고 모든 걸 전송했다고 생각하는 서버는 connection을 끊게 되는데 클라이언트가 보낸 retransmit_req_conn을 새로운 request라고 생각해서 새로운 버퍼를 만들고 낭비 하게 된다.

### 3-way handshake

<img width="646" alt="스크린샷 2019-10-14 오전 2 43 45" src="https://user-images.githubusercontent.com/48313074/66719561-77f49480-ee2c-11e9-8cff-3970cf792b29.png">

클라이언트 -> 서버 :x

서버 -> 클라이언트 : y

### TCP 장치들 사이에 논리적인 접속(연결)을 성립(establish)하기 위하여 Three-way-handshake를 사용하게 된다.

- TCP 3-way Handshake는 TCP/IP프로 토콜을 이용해서 통신을 하는 응용프로그램이 data를 전송하기 전에 먼저 정확한 전송을 보장하기 위해 상대방 컴퓨터와 사전에 세션을 수립하는 과정을 의미합니다.
- 1차 : Client -> Server : (TCP) SYN ->send SYNbit =1, seq =x
- 2차 : Server ->Client :(TCP) SYN + ACK ->send SYNbit =1,Seq =y ,Ackbit=1,ACKnum = x+1
- 3차 : Client ->Server (TCP) ACK ->send ACKbit =1, ACKnum = y+1

### TCP 의 3 -way handshaking의 역할

- 양쪽 모두 데이터를 전송할 준비가 됬다는 것을 보장함
- 실제로 데이터 전달이 시작하기전에 한쪽이 다른 쪽이 준비된 것을 알게한다.

1차 - > 클라이언트 = SYN_SENT상태

2차 -> 서버 = SYN_RECEIVED

3차 -> 서버 =ESTABLISHED

p.s push flag- 이 플래그가 포함되어 있으면 데이터를 곧바로 읽어간다.

<img width="800" alt="스크린샷 2019-10-14 오전 3 13 24" src="https://user-images.githubusercontent.com/48313074/66719894-9bb9d980-ee30-11e9-9a7c-f6881e7d3947.png">



- FIN flag를 SET하면 그즉시 서버는 ACK를 보낸다. 하지만 아직 서버는 더 보낼 데이터가 남아있다. 서버가 FIN flag를 보내줘야 끝나게 되는데 FIN flag를 보내면 그즉시 클라이언트는 ACK를 보낸다. 그리고 나서 timed wait가 발생하는데 default값은 30초이다. 혹시 더 보낼 데이터가 있는지 기다리고 나서야 완전하게 끝이 나게된다.