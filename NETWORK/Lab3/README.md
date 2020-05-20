# MAC 주소

-데이터 링크 계층

​	->LLC ( logical Link Control) -상위

​	->MAC (medium Access Control) - 하위

ARP packet 에도 MAC address 와 IP address두개의 다른 주소가 존재한다.

hardware type : data link 계층에서 사용하는 프로토콜을 의미하며 여기서는 		      ethernet이다.

protocol type : Network 계층에서 사용하는 프로토콜을 의미하며 여기서는

IPv4이다.

## MAC address 

Data link 계층과 physical 계층에서 사용하는 주소 따라서 "물리적 주소" 혹은 "물리주소", "하드웨어 주소 ''라고 불린다. 여기서 MAC은 좁은 의미의 MAC sublayer가 아닌 2계층 전체를 의미한다.

구체적인 소유자 : 노드(PC, server,프린터 등)의 인터페이스다. 즉 컴퓨터에 여러 개의 인터페이스가 있다면 컴퓨터에 여러 개의 물리주소가 존재한다.

가장흔한 형태 : NIC(network interace card) - 48bit 6byte

Ex) 06: 01: 02: 01 :2C: 4B  -6bytes  = 12 hex digits = 48bits

왼쪽의 3bytes는 prefix라고 불리는 NIC 제조회사 고유의 번호이다. 이를 OUI(organization unique Identifier)라고 한다.

하나의 회사가 여러개의 OUI를 가지고 있기도 하다.

오른쪽 3bytes는 특정 NIC에 제조사가 할당하는 식별번호다. 

제조사는 NIC를 제조할때 PROM이나 firmware에 MAC주소를 저장하여 이를 쉽게 바꾸지 못하게한다. 모든 NIC는 이렇게해서 고유의 MAC주소를 할당받는다.

#### LSB

48 bit 주소 중 첫번째 Byte 의 Least significant Bit(LSB)

1 : Multicast address : 목적지가 여러개 라는 것을 말하는 주소

0: Unicast address 목적지가 하나인 것을 말하는 주소

Ex) BroadCast address : Multicast address의 특수한 경우로 모든 노드가 목적지임을 나타내는 주소이다. 따라서 모든 bit 가 1이다.

Heximal notation = FF:FF:FF:FF:FF:FF

이렇게 구분해줄수 있는 이유 : 해당 bit가 가장 먼저 전송되는  bit이기 때문이다.



## IP address

network 계층에서 사용하는 주소 따라서 네트워크 주소와 동의어이다.

mac주소 혹은 물리주소의 구체적인 소유자는 노드 의 인터페이스다.

인터페이스를 이루는 가장 흔한 형태는 메인보드 주변장치로 연결되는 	Network Interface Card(NIC)이다.

물리주소는 주로 (이더넷과 무선LAN에서) 48bits, 6bytes로 이루어진다.

8bits단위로 구분해서 16진수로 표시한다. 각 8bits 사이는 콜론(:)으로 구분하는데 이런것을 hexadecimal notation 이라고 한다.

<img width="800" alt="스크린샷 2019-10-09 오전 3 17 52" src="https://user-images.githubusercontent.com/48313074/66421768-6fbee280-ea43-11e9-9679-a17f5d864648.png">



4 = 0100,	7 = 111   0100 / 0111

2= 0010,	0 = 0000  0010/0000

<- 11100010 00000100

