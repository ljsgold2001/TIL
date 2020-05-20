## 전송계층 주소

전송 계층의 역할은 사용자 데이터를 상대 호스트의 상대 프로세스 까지 전달해 주는 것이다.

여기서 프로세스(process)라는 것은 실행되고 있는 사용자의 프로그램의 instance(실재)를 말한다. 하나의 프로그램이라도 여러 개 실행 될 수있다.

Web서버의 프로세스는 클라이언트의 프로세스와 데이터를 주고 받으며 이러한 데이터 교환의 책임을 전송계층이 지게 된다.

<img width="800" alt="스크린샷 2019-10-09 오전 3 39 37 1" src="https://user-images.githubusercontent.com/48313074/66423365-8155b980-ea46-11e9-85dc-646897bc33c6.png">

전송계층은 하위계층인 네트워크 서비스를 통해서 호스트까지 데이터 전달을 완료 했으므로 남은 일은 식별자를 통해 프로세스를 명시해 주는 일만 책임지면 된다.

따라서 전송계층의 식별자는 주소라고 할 것 까지는 없다. 이 식별자를 port 번호 라고 한다.

<img width="800" alt="스크린샷 2019-10-09 오전 3 50 25" src="https://user-images.githubusercontent.com/48313074/66424114-f2e23780-ea47-11e9-9548-cd96708ac67f.png">

port번호는 16bit로 이루어져 있다. 따라서 2^16 = 65536개의 port번호가 있다.

0-1023 = well -known port이다(잘 알려진 특정 application의 server에 할당)

ex) HTTP server = 80번 포트

1024 - 49151 = registered port이다.(IANA가 관리 ,기관에서 요청하는 경우 정해진 절차에 따라 할당해 주고 이를 알린다.) registered port번호는 일반 클라이언트가 자유롭게 자신의 포트번호로 이용할 수 없다.

59151 - 65535 = ephemeral port이다. (제한 없이 client가 마음대로 사용할 수 있는 port번호의 범위)

<img width="800" alt="스크린샷 2019-10-09 오전 3 55 46" src="https://user-images.githubusercontent.com/48313074/66424487-afd49400-ea48-11e9-91e4-0b03560b5f1e.png">

