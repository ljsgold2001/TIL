# **Wireshark 화면을 capture 하여 packet list window , packet list detail, packet byte window 를 명시한다.**



### **packet list window**



<img width="882" alt="Question1-1" src="https://user-images.githubusercontent.com/48313074/65772569-70b76080-e175-11e9-99a8-617986fc7949.png">



#### **패킷이란**

### 페킷이란 데이터의 묶음 단위로 한번에 전송할 데이터의 크기를 나타낸다

#### **캡쳐본의 리스트중 하나의 항목을 패킷이라고 한다**.

1. no - capture된 순서를 뜻함
2. 2.time - capture된 시간
3. 3.source/destination - packet의 출발지와 목적지
4. 4.protocol -packet이 포함하는 주요 프로토콜
5. 5.Length - byte단위의 길이
6. 6.info - packet이 내포하고있는 주요정보



### **packet details window**

### <img width="882" alt="Question1-2" src="https://user-images.githubusercontent.com/48313074/65773014-6cd80e00-e176-11e9-80cf-292a99cea2a7.png">



#### Packet list window에서 선택된 packet의 자세한 사항을 알려준다

#### packet의 일련번호 - 3509

#### 선택된 packet의 protocol과 protocol fields를 보여준다.



### **packet bytes window**

<img width="882" alt="Question1-3" src="https://user-images.githubusercontent.com/48313074/65773380-2c2cc480-e177-11e9-97ea-3e7ddf6e7012.png">

### 1.packet bytes window  -details window 에서 선택된 부분에 해당되는 Hexadecimal data를 보여준다.

### 2. 각각의 data 에는 data offset, 16진수 byte, 16 ASCII BYTE가 포함된다.





