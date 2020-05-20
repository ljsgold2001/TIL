# TCP round trip time , timeout



- Q : how to set TCP timeout vale?(tcp timeout을 설정하는 방법은 무엇인가?)
- A : round trip time(RTT)보다 길게 설정한다.



-tcp 의 timeout이 너무 짧다면 ? : premature 한 timeout이 설정되게 되고 불필요한 재전송이 많아진다.

-tcp의 timeout이 너무 길다면 ? : 세그먼트 손실에대한 리엑션이 너무 느리다.



-RTT를 츨정하는 방법은?

- sampleRTT : 세그먼트를 송신하고 ACK를 받기까지 걸린 시간 (재전송은 무시한다.)
- sampleRTT는 매우 다양하기때문에 EstimateRTT를 따른다.



-Q : Timeout 기간은 상대적으로 길다. Segment가 손실된다면 Timeout이 매우 길어질 수 있다. TCP는 NAK를 사용하지 않는다. 어떻게 이 문제를 해결할 수 있을까?

- A : Duplicate ACK를 사용한다.

<img width="523" alt="스크린샷 2019-11-22 오후 9 16 28" src="https://user-images.githubusercontent.com/48313074/69425021-68dafd80-0d6d-11ea-874f-33f2e348283d.png">

- 발신자가 이미 받은 ACK를 다시 받는 경우
- 만약 Tcp receiver가 예상되는 sequence number보다 큰 수를 받는다면 ACK를 받은 마지막 데이터의 바이트에 해당되게 다시전송한다.

# TCP ACK Generation

- 다음 세그먼트가 존재한다면 매번 ACK를 보낼 필요는 없다.
- Ack delay 를 일부러 준다.
- 순서가 바뀐다면 ACK 재전송을 통해 원래 순서를 받을 수 있다.



<img width="537" alt="스크린샷 2019-11-22 오후 9 32 50" src="https://user-images.githubusercontent.com/48313074/69426081-a771b780-0d6f-11ea-921b-672f4b5391bd.png">

-  **Event -** 예상된 sequence number가 순차적으로 전달된다 모든 예상된 sequence number의 데이터들로부터는 이미 모두 ack를 전달 받았다.

  - **TCP Receiver Action** - 지연된 ACK, 올바른 segment의 도착을 위해서 500msec를 기다린다.만약 다음 순서에 맞는 ACK가 도착하지 않는다면 ACK를 보낸다.

- **Event** - 예상된 sequence number가 순차적으로 전달된다. ACK 전송을기다리는 순서에 맞는 세그먼트가 있다.

  - **TCP Receiver Action** - 2개의 순서가 맞는 세그먼트들을 ACK 하기위해서 누적된 ACK 를 보낸다.

- **Event** - 수신된 segment가 격차를 완벽하게 혹은 부분적으로 받는다.

  - **TCP Receiver Action** - 즉시 ACK를 보낸다.세그먼트의 격차가 최솟값에서 출발

- **Event** - 예상된 sequence number보다 높은 순서에 어긋난 sequence number가 들어온다.

  - **TCP Receiver Action** - 즉시 duplicate ACK를 보낸다. 바로 다음에 와야했던 sequence number로(두값의 차이의 최솟값)

    

  

  



