# Transmission Rate Control with a window continued

- window size가 W 인 패킷의 개수를 조절한다.
- Transmission rate = window size * max Segment Size / Round trip time
- 만약 window size 가 매우 작으면 transmission rate << network capacity
- 만약 window size 가 매우 크면  transmission rate >> network capacity = congestion
  - 따라서 window 사이즈를 네트워크의 환경에 따라 적절히 선택해야한다.



## TCP Window Controls Summary

- **Flow control**
  - receiver의 overloading을 피한다.
  - receiver에 의해서 set된다.
  - Rwnd : receive window
- **Congestion control**
  - Network 의 overloading을 피한다.
  - Sender 에 의해서 set된다.
  - 가능한 Network capacity을 추론한다.
  - Cwnd : congetion window
- **Set W =  min(cwnd , rwnd)**



## Flow Control

- receivers는 advertise한다 free buffer space를  TCP header의 rwnd의 값 안에 포함시킴으로써
  - RcvBuffer의 size는 soket option에 의해 설정되며 일반적으로 4096byte이다.
  - 많은 os 는 RcvBuffer을 자동으로 맞춘다.
- sender는 unasked data를 receiver의 rwnd value값으로 제한한다.
- Receive buffer는 overflow하지 않음을 보장한다.



<img width="240" alt="스크린샷 2019-11-22 오후 10 27 47" src="https://user-images.githubusercontent.com/48313074/69429624-55349480-0d77-11ea-9a62-5bc7905f0562.png">



## Congestion control

- 송신자는 cwnd를 network congestion으로부터 계산한다.
  - 두가지방법이있다.
    - 네트워크로부터 현재 네트워크 상황을 전달받는다.
    - destination 으로부터 정보를 전달받아 현재 네트워크 상황을 유추한다.
- 일반적으로 혼잡을 인식하는 지표들
  - Losses(Tcp의 경우에서)
  - Delay
  - Mark
- cwnd를 계산하기위한 알고리즘
  - TCP Tahoe , TCP Reno, TCP vegas ,RED , REM.....



## TCP Sliding window

<img width="530" alt="스크린샷 2019-11-26 오전 1 36 25" src="https://user-images.githubusercontent.com/48313074/69559394-38a19200-0fed-11ea-8b57-8f9849c107d4.png">

- sliding window 는 flow control 과 congetion control 을 위한 것이다.
- Window 의 크기를 rwnd 와 cwnd 의 최솟값으로 설정한다.
- 송신자는 모든 윈도우의 데이터를 전송할 필요는 없다.
- window가 open 될때는 window size가 증가할때,window가 close될때는 ACK에 의해서하지만 축소되서는 안된다.
- TCP sliding window는 바이트단위이다.
- 응답을 기다리지않고 연속으로 패킷을 전달한다.
- 윈도우의 크기가 상황에 맞게 동적으로 변한다.



### Window Management in TCP

- 수신자는 송신자에게 두가지의 변수를 준다.
  - AckNo = 32bits
  - Window size = 16bits
    - 이말인 즉슨 나는 새로운 데이터를 받을 준비가 되어있다. sequence number가 AckNo , AckNo+1,,,,,,,,Ack+win-1인 것들의
- Closing 이란?
  - receiver는 데이터를 ack할수있다. window를 opening 하지 관여 x
- Opening or Shrinking 이란?
  - receiver는 window size 를 ack 하지않고도 변경시킬수 있다.

### TSO(TCP Large Segment Offloading)



<img width="407" alt="스크린샷 2019-11-26 오전 2 07 17" src="https://user-images.githubusercontent.com/48313074/69561915-8b7d4880-0ff1-11ea-9446-b4f3cfe3b49a.png">

- 내용의 크기가 컸을 경우 더작은 세그먼트로 쪼개는 과정을 거치는데  CPU가 아니라 NIC에 위임한다.

