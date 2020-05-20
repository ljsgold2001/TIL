# Congestion Control

- **정의 : 너무 많은 송신자들이 너무 많은 데이터들을 네트워크가 감당할 수 없을 정도로 빠르게 보내는것**

  - Shot - term congestion : 충분한 버퍼공간이 마련되면 해결될 수 있다.(잠깐 우연히 발생하는 congestion)
  - Long - term congestion : sender 의 전송감소로 해결이 가능하다.

- **증상**

  - Lost packets : 버퍼가 라우터에서 overflow 되어 **패킷 손실** 발생
  - Long delays : 라우터 버퍼에서 큐잉딜레이로 인한 지연발생

  



## scenario 1 

<img width="495" alt="스크린샷 2019-11-26 오전 2 45 19" src="https://user-images.githubusercontent.com/48313074/69564684-ccc42700-0ff6-11ea-96ba-6703c7082485.png">

- two sender, two receiver
- 하나의 라우터 , 무한한 버퍼
- 출력 capacity : R
- 재전송 없다



<img width="661" alt="스크린샷 2019-11-26 오전 2 47 02" src="https://user-images.githubusercontent.com/48313074/69564830-101e9580-0ff7-11ea-9cac-469437338137.png">



- 이상황은 두개의 host가 만약 2/R의 데이터를 전송하게 되면 링크의 capacity가 R이기 때문에 무한히 지연되는 것을 기다려야한다.
- 따라서 라우터에서 무한대의 시간을 기다려야 하는 것이다.

## scenario2

<img width="630" alt="스크린샷 2019-11-26 오전 3 01 23" src="https://user-images.githubusercontent.com/48313074/69565895-35140800-0ff9-11ea-88d1-5e225af2d43b.png">

- 하나의 라우터 ,유한한 버퍼
  - 즉 , 송신측에서는 timeout된 패킷의 재전송이 이루어진다. 즉, 큐가 유한할경우 패킷의 손실이 발생
- 시간초과 패킷을 발신자의 재전송
  - application layer input = application layer output
  - Original data + retransmissited data >original data
  - 지연된 패킷의 재전송으로 크기가 더욱더 커진다.
- delay가 무한대로 늘어나진 않지만 loss가 생기기 시작한다.
- 더큰 data rate로 보내게된다. 따라서 retransmission이 점점 커진다.



## scenario



![image](https://user-images.githubusercontent.com/48313074/69566641-e7000400-0ffa-11ea-9769-222585e9a67b.png)

- 4개의 발신자
- 여러개의 홉 경로
- timeout/재전송



- 라우터를 두개 이상씩 건너는 상황(좀 더 실제적이다.)
- A에서 많은 데이터를 보내게되면 서로가 서로에게 영향을주고 결국 전부 망가지게 된다.
- λ''(in)가 증가함에따라 상위 큐에 도착하는 모든 패킷들이 drop되고 처리량이 0으로 가게된다.

![image](https://user-images.githubusercontent.com/48313074/69567484-d0f34300-0ffc-11ea-8dc5-89ace74363de.png)

- λ''(in)가 증가하면 (재전송 발생 확률 증가) 즉 ,패킷이 버려지는 상황이 많아지게 되며 버려지는 패킷지점까지 패킷을 전송하기위해 상위 라우터는 전송용량을 낭비하게 된다.



​	





















