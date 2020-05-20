# ARQ (Stop-and-Wait)

<img width="557" alt="스크린샷 2019-11-06 오후 1 38 17" src="https://user-images.githubusercontent.com/48313074/68268754-c9461b80-009a-11ea-9953-2faede4fb261.png">

-receiver와 sender가 하나의 link로 연결된 상황이다.

-전송하고나서 stop 후에 ack가 올때까지 wait하는 상황이다.

### 프레임이 사라지거나 손상된다면?

-  receiver는 ACK를 보내지 않는다.
- 그렇게되면 Sender는 프레임을 다시한번 보낸다.
- sender는 일정시간 이상동안 ack를 받지 못하면(timer) 받지 못한것을 오류라고 판단하고 재전송을 요청한다.

### ACK가 사라진다면?

- 프레임을 다시보낸다
  - 하지만 receiver의 입장에서는 해당 프레임이 다시 보내진 것이라는 것을 어떻게알까?
  - A: identifier를 data frame과 Ack에 넣어서 안다.
  - 위의 답변에대해서 id를 몇개를 이용해야하는것인가 만약에 20개의 패킷이라면 20개의 id를 사용해야하는가?
  - A: 아니다. 2개의 id만 있으면 된다.

A시점 : Frame 전송이 시작된 시점

B시점 : Frame 전송이 끝난 시점

A~B : transmission delay

A~A' : pronation delay



<img width="496" alt="스크린샷 2019-11-06 오후 1 47 10" src="https://user-images.githubusercontent.com/48313074/68269137-f21ae080-009b-11ea-9ad2-e08458e6ab99.png">

- 0번을 받았다 =1번을 받을 준비가 되어있다.
- sender와 receiver는 전송을위해 메모리 공간을 확보하고있다.
  - 하나 받고 ack 보내고 하나받고 ack보내는 방식은 효율적이지 않다. 한번에 여러개를 보내자 -pipelining(파이프라이닝 방식)

###Go-back-N ARQ

<img width="485" alt="스크린샷 2019-11-06 오후 2 03 21" src="https://user-images.githubusercontent.com/48313074/68269724-360ee500-009e-11ea-8861-2c9dc1996cad.png">



- 전송 효율을 높히기 위해서는 송신자의 응답을 기다리는 동안 여러개의 프레임을 보내서 채널의 사용량을 높힌다.
- Sf와 Sn의 거리가 멀어질수록 Ack를 받기를 기다리는 상황이다.
- Go-back-N프로토콜은 누적 응답이기 때문에 Ack응답 번호에 의해 sliding window가 한번에 이동할수있다.
  - ex) 프레임을 0,1,2를 전송한후에 Ack3이 온경우에 0,1은 프레임이 잘 전송 된것으로 판단한다. 따라서 sliding window가 3칸 이동해서 프레임 3이 첫번째 sliding window 가 된다. 
  - ex)if frame2 가 가다가 손상되었을때는? A : 2가 고장나도 3은 계속 보낸다. 3을 보내도 receiver는 ack를 보내지 않는다. 포인터가 하나 밖에 없기 때문에 Rn은 계속해서 2번에 머무른다. 언제까지? ->2번이 올때까지 결국에는 timer에 의한 time out으로 인해서 다시 1번부터 재전송을 하게된다. 

<img width="499" alt="스크린샷 2019-11-06 오후 2 20 24" src="https://user-images.githubusercontent.com/48313074/68270441-9737b800-00a0-11ea-8532-1bcbc2cf806b.png">

- ack없이 한번에 보낼수있는 frame의 최대개수는 2^m-1개이다.

<img width="490" alt="스크린샷 2019-11-06 오후 2 21 31" src="https://user-images.githubusercontent.com/48313074/68270488-bdf5ee80-00a0-11ea-980d-31cad1abc993.png">

- 한개의 여유공간 없이 보낸다면 최악의 상황에 모든 ack가 깨진다면 재전송인지 아닌지 알 수 없게 된다
- sender의 window 크기 + receiver의 window의 크기 <= 시퀀스 번호 공간의 크기

### TCP Error control

-  TCP error control은 go back -n을 기반으로하고있다.
- nack을 사용하는 것과 ack를 못받은 것 부터 전부 다 재전송한다는 것은 go-back-n과 비슷하다. 하지만 Tcp는 2번이 깨지고 3번이 들어왔을때 3번을 저장하지만 go-back-N은 저장하고있지 않다.
- ack가 cumulative하다는 것은 동일하다는 뜻이다.
- Tcp는 0,1,2,3처럼 단순한 sequence number가 아니라 긴 바이트수의 sequence number를 가지고 있다. 
- send window size를 조절할수있다.
- 