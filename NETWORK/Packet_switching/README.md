### Packet switching(store-and-forward)

<img width="619" alt="스크린샷 2019-10-19 오후 2 43 01" src="https://user-images.githubusercontent.com/48313074/67138486-c7005680-f27e-11e9-97e5-4ef22f2b03d5.png">

페킷을 다 저장해야 송신한다는 뜻이다.

If) L=1, R =10이면 transmission delay = 0.1

위의 그림에서는 end to end delay는 2번의 R이 존재하기때문에 2*L/R이다(propagation delay가 없다고 가정했을때이다.)



### packet switching(queuing delay,loss)

<img width="637" alt="스크린샷 2019-10-19 오후 2 45 46" src="https://user-images.githubusercontent.com/48313074/67138507-3413ec00-f27f-11e9-98ad-57b44e168921.png">

- A와B로부터 다 도착했다고 하더라도 그뒤의 Link에서 아직 송신중이면 Queue에서 기다려야하는 delay가 Queuing delay이다.
- Queue의 크기는 한정적이기 때문에 다차면 손실될 수밖에 없다.
- 메모리 버퍼가 가득차면 기다려야한다.

### Delay components in a node

#### <img width="640" alt="스크린샷 2019-10-19 오후 2 51 07" src="https://user-images.githubusercontent.com/48313074/67138542-e8157700-f27f-11e9-994f-ac3efcca2054.png">

- processing delay : nodal processing ->페킷헤더를 체크해서 오류를 검사하고 보낼 위치를 정하는 것이다.
- Propagation daly : 비트가 실제로 링크를 타고 전파되는 딜레이다.

### Queuing delay and Loss

<img width="591" alt="스크린샷 2019-10-19 오후 2 55 35" src="https://user-images.githubusercontent.com/48313074/67138571-86a1d800-f280-11e9-92b3-e3887baf1ad3.png">

- 페킷의 도착률이 capacity를 초과하면 페킷은 큐에있거나 기다려야한다.
- 라우터안의 공간이 남는 버퍼가 없다면 도착한 패킷이 손실 될 수도 있다.

### Queuing delay

<img width="273" alt="스크린샷 2019-10-19 오후 3 00 19" src="https://user-images.githubusercontent.com/48313074/67138613-2eb7a100-f281-11e9-9a31-4dd1e94facaf.png">

- R : Link bandwidth(bps)
- L : packet length(bits)
- a : average packet arrival rate

a *L/R ~0 : queuing delay small

a *L/R  =1 : queuing delay large

a *L/R > 1 : 처리할수있는 양의 작업보다 많이 도착했다는 뜻이다.



### Throughput

- sender와 receiver사이에 전송할수있는 비트의 양
  - Instantaneous throughput : 순간적인 비율
  - averageous throughput: 평균적인 비율
- 처리량은 링크의 속도 , 정책에 따라 달라진다.
- Bottleneck (병목현상) -average throughput을 결정한다.

<img width="273" alt="스크린샷 2019-10-19 오후 3 05 00" src="https://user-images.githubusercontent.com/48313074/67138673-e9e03a00-f281-11e9-8be9-7997e8219be0.png">

Throughput - min(Rc,Rs,R/10) 실제로는 병목현상이 일어날수있다.



### throughput과 bandwidth의 차이는 무엇인가.

- ex) bandwidth가 크다는 것은 차선이 많다는 뜻이다.
- ex)throughput이 크다는 것은 큰 bandwidth에서 한번에 처리할수있는 패킷의 양이 많다는 것이다.



