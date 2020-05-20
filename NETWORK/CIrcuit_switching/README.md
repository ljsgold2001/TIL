### Network-core의 두가지 기능적 핵심

- Routing : 출발지부터 목적지 까지를 routing algorithm을 사용해서 설정한다.
- forwarding : 그 출발지에서부터 목적지 까지 이동시키는 것이다.(포워딩 테이블)



###Alternative core : circuit switching

<img width="311" alt="스크린샷 2019-10-19 오후 3 13 04" src="https://user-images.githubusercontent.com/48313074/67138753-f749f400-f282-11e9-9e92-d682a8656f22.png">



- End-end사이에 call을 통해서 호출한다.
- 리소스를 공유하지 않는다.
- 하나의 회선을 할당 받기때문에 회선을 공유하지 않는다.
- 데이터전송을 하지 않을 시에도 쓰지 않는다.
- 성능이 매우 일정하다.
- 주로 traditional 한 실시간 전화 시스템에서 많이 사용된다.

### circit switching FDM vs TDM



##FDM

- <img width="454" alt="스크린샷 2019-10-19 오후 3 17 50" src="https://user-images.githubusercontent.com/48313074/67138782-a8508e80-f283-11e9-902b-41992f2083e0.png">
- 하나의 bandwidth를 frequency(주파수)별로 분할한다. 즉 대역폭이 전송할 신호 대역폭보다 무조건 커야한다.

## TDM

<img width="457" alt="스크린샷 2019-10-19 오후 3 19 28" src="https://user-images.githubusercontent.com/48313074/67138804-db931d80-f283-11e9-881b-fbdb4d239dd1.png">

-다수의 채널이 하나의 frame의 시간을 분할해서 사용한다.

- 차이점 : FDM은 계속해서 한 bandwidth의 일부를 사용한다. 하지만 TDM은 bandwidth의 전체를 시간별로 분할해서 사용한다.



### packetswitching VS circuitswitching

- 패킷 스위칭은 대기 시간이 네트워크의 상황에 따라서 다르지만 서킷 스위칭은 항상 일정하여 순서가 일정하다.

- 오류 발생시에 패킷스위칭은 우회하면 되지만 서킷스위칭은 아예 실패하낟.

- 패킷 스위칭은 queuing delay, propagation delay둘다 있지만 서킷 스위칭은 처음에 회선을 설정하는 setup만 하는 시간을 제외하면 propagation delay밖에 존재하지 않다.

- 서킷 스위칭을 인원을 제한한다.

  