# Approches towards congestion control

----

###	1.end - end congestion control

- 네트워크로부터 명시적인 피드백이 없다.
- congestion을 end system이 관찰한 손실이나 지연으로 판단한다.
  - ex) TCP



### 2.network - assisted congestion control

- 라우터들은 end system 들에게 피드백을 제공한다.
  - 라우터들은 end system에게 다음과 같은 피드백을 전달한다.
    - congestion을 알려주는 single bit
    - 피드백은 발신자가 보낸 정확한 비율을 지정한다.



### AIMD(additive increase & multiplicative decrease)

----

- 접근방식 : 발신자는 손실이 발생할때때까지  사용가능한 대역폭을 조사하며  전송률 (transmission rate)를 증가시킨다 (window size)
  - additive increase : loss 가 감지될때 RTT마다 cwnd를 증가한다.(1mss)
    - MSS -최대 세그먼트 크기
  - multiplicative decrease : 손실후 cwnd를 반으로 자른다.
- 주요가정 : packet loss 및 결과적인 timeout은 라우터의 정체로 인한 것이다.

<img width="512" alt="스크린샷 2019-11-30 오전 3 04 00" src="https://user-images.githubusercontent.com/48313074/69884930-132ec400-131e-11ea-9063-61428aa4a2d7.png">



- 그래프 상에서 cwnd 값이 톱니 모양의 패턴을 가지게 된다. 값이 꺾일때마다 패킷의 손실이 발생한다.



### TCP - Slow Start ( exponential growth)

----

![image](https://user-images.githubusercontent.com/48313074/70141784-1a1d5400-16db-11ea-9c28-b3d6c8633e26.png)

- TCP 연결이 시작되면 congestion window(condo)의 초기값은 1mss이다.

- TCP연결이 시작되고 첫번째 손실이 발생하기 전까지는 exponential 하게 증가한다.

- 오류가 없는 ACK가 온다면 cwnd는 2배씩 증가한다.

- Linear additive increase는 새 TCP를 시작하는데 너무 오래걸린다.

- TCP Tahoe로부터 slow start 메커니즘이 추가되었다.

- 연결가능한 bandwidth가 송신률보다 훨씬 더 크다면 송신률은 cwnd와 비례하기 때문에 초기에는 느리지만 exponential하게 굉장히 빠르게 증가한다.

  

### TCP modified congestion control

---

- 만약에 손실이 발생하면 임계점을 생성한다 (임계점은 현재 cwnd의 1/2)
- 손실은 Timeout 으로 암시된다.
- cwnd는 exponentially 하게 증가하다가 임계점에 도달하고 그이후에는 linear 하게 증가한다.
- 손실은 3가지 duplicate ACK에 의해서 암시된다.
  - 3-duplicate-ACK란?
    - 원래는 Timeout으로만 packet loss를 congestion으로 인식하였었는데 그것은 너무 늦다. 이에 따라 한 패킷의 duplicate ACK가 3번온다면 이를 packet loss라고 생각하고 처한다.
  - TCP Tahoe
    - cwnd를 1MSS로 설정한다.
  - TCP Reno
    - Duplicate ACK는 네트워크가 어떠한 세그먼트들을 전달할수 있다는 것을 의미한다.
    - cwnd는 반으로 준뒤에 linear하게 증가한다.



### TCP Tahoe

----

-  slow start 가 개발되었다.

- 빠른 재전송 (3개의 중복된 ACK 상황에서)이 추가되었다.

- cwnd를 모든 packet loss에 대해서 1로 설정한다.

  - Timeout에 감지된 손실 : 전혀 전송되지 않은것으로 간주하여서 심각한 혼잡상황으로 받아들인다.

  - 3 duplicated ACK에 의한 손실 : 다른 세그먼트(페킷)은 잘 도착했으므로 일부세그먼트들은 전송해도 뒨다고 생각하여 조금 혼잡한 상황이라고 받아들인다.

    

    ![image](https://user-images.githubusercontent.com/48313074/70145683-04605c80-16e4-11ea-851e-859b89328db2.png)



![image](https://user-images.githubusercontent.com/48313074/70146189-0c6ccc00-16e5-11ea-8670-96bd4aaea620.png)

- 위의 그래프에서 언제 exponential한 증가에서 linear한 증가로 바귀는가?
  - Timeout이 되기전에 cwnd가 1/2로 줄었을때

### TCP Reno

----

- Cwnd를 반으로 줄인뒤에 linear하게 증가시킨다. Fast recovery라고 부른다.



### TCP Vegas

---

- RTT를 측정하여 congestion level을 추론한다.
- linear한 증감은 현재의 RTT에 기반한다.

----



