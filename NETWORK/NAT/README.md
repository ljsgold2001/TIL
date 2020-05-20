# NAT(Network Address Translation)

---

![image](https://user-images.githubusercontent.com/48313074/70323820-32bf7280-1871-11ea-8e7d-985f48418cba.png)

- 로컬네트워크를 떠난 모든 패킷들은 138.76.29.7이라는 NAT IP address 를 가진다. 그리고 모두 다른  시작 포트넘버를 가진다.



- 이 네트워크안에서의 시작과 도착 주소를가진 모든 패킷들은 10.0.0/24라는 주소를 가진다.



### NAT implemetation

---

-  Mddify outgoing packet

  - Source IP address , port 로부터 나가는 모든 패킷들을 수정한다.(NAT IP address , new port 로)

  

- Remember( in NAT translation table )

  - Source IP address , port는 NAT IP address 와 new port와 NAT translation table 에서 pair 로써 쌍을 이루고 기억한다.

- Modify imcoming packets

  - 도착 필드에 도착하는 (NAT IP address ,new port)를 도착하는 source IP /port에 일치시켜서 NAT table에 저장한다.

![image](https://user-images.githubusercontent.com/48313074/70324640-600d2000-1873-11ea-979e-1b34bd825d51.png)

- NAT translation table 수행 과정
  - Host 10.0.0.1은 128.119.40.186에게 페킷을 보낸다.
  - NAT routersms 10.0.0.1로 부터 받은것을 138.76.29.7로 바뀐다.
    - 10.0.0.1이 나가려면 138.76.29.7로 바뀌어야한다는 것이 NAT translation table에 기록되어있다.
  - 목적지인 128.119.40.186 으로 전송된다.
  - 전송에대한 답변을 138.76.29.7로 128.119.40.186이 다시 전송한다.
  - 도착한 138.76.29.7은 다시 10.0.0.1로바뀌고 목적지로 전송된다.

### NAT

---

- 16비트 port number 필드
  - 하나의 공용 IP주소를 가지고 60000개가 넘는 연결이 가능해진다.
- NAT의 논란의 여지 
  - 라우터는 layer 3 까지만 처리해야한다.
  - 네트워크 계층의 end -end 시스템 위반
  - 주소부족 문제는 IPv6로 해결되야한다.