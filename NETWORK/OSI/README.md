### OSI 모델

<img width="638" alt="스크린샷 2019-10-19 오후 3 30 53" src="https://user-images.githubusercontent.com/48313074/67138951-793b1c80-f285-11e9-93f6-5ddab0d32082.png">

- Layer 7 : 실제 응용프로그램의 데이터의 의미를 해석해준다.(HTTP,FTP,SMTP)
- Layer 6 : 응용 프로그램이 데이터의 의미를 해석할수있게 암호화해주고 설명해준다.
- Layer 5 : 데이터 교환의 구분 및 동기화 , 복구
- Layer 4 : 전송을 보장하고 데이터를 보장한다.flow control,error control, connection control ( TCP/UDP) process : 현재 실행중이 프로세스
- Layer 3: 2홉이상의 통신을 전담한다 . logical addressing and routing (IP)
- Layer2 : 1홉의 통신을 전담하고 비트를 프레임 안에 넣는다.(ethernet,wifi,wi LAN)
- Layer 1: electrical specification으로 바꿔서 비트형식으로 매체를 통해전달

-메세지 전달형식 : message - segment - packet - frame - bit stream

<img width="621" alt="스크린샷 2019-10-19 오후 3 38 21" src="https://user-images.githubusercontent.com/48313074/67139043-7db40500-f286-11e9-818a-3ff192db8e15.png">

encapsulation과 decapsulation을 통해서 자신의 데이터를 감싸거나 감싸지것을 해독

- data link layer = physical addressing
- network layer = logical addressing
- transport layer = port addressing(service point addressing)

### summary

<img width="615" alt="스크린샷 2019-10-19 오후 3 43 47" src="https://user-images.githubusercontent.com/48313074/67139118-44c86000-f287-11e9-9bda-b8fd23327329.png">



