# 계층간 주소 연결

### DNS와 ARP

Ex)인터넷을 통해서 무엇이든 서비스를 받고자 할때 (특정 웹페이지 를 보고자 할때) , 사용자는 (www.naver.com)을 기억하고 있다가 적어야 한다.

이러한 형태의 web주소를 URL(universal Resource Locator)이라고 한다.

### Host name(호스트 이름)

인터넷에 연결된 호스트(컴퓨터)에 읽기 쉬운 방식으로 붙힌 이름 ex) "ens.smu.ac.kr" 모든 호스트가 이름을 가지는 것은 아니라 FTP or Email등 응용프로그램의 서버 역할을 수행하는 호스트가 이름을 가지게 된다.

Ex) "ens.smu.ac.kr" 이라는 호스트 이름은 smu.ac.kr이라고 명명된 "도메인"에 속한 호스트이다.

Ex2) smu.ac.kr이라는 도메인을 대표하는 호스트도 존재하는데 이런 경우 smu.ac.kr은 도메인 이름이기도 하면서 호스트 이름이 된다.

ens.smu.ac.kr이라는 호스트도 자체적으로 도메인을 형성한다. 

#### 따라서 많은 경우 인터넷에서 사용하는 호스트 이름은 도메인이름 (domain name)이라고도 한다

사용자가 직접 서버 호스트의 이름을 명시하지 않지만 응용프로그램이 이 역할을 대신해준다. Ex) 온라인 게임의 경우 서버의 명칭이나 주소는 사용자가 알지 못하고 해당 응용프로그램이 내장하고 잇다.

### 응용 계층에서 필요한 주소 (URL이나 Host Name)는 사용자나 프로그램이 제공한다. 그렇다면 이렇게 제공된 정보를 네트워크 계층과 전송 계층에서는 어떻게 활용할까?

-서비스의 종류에 따라 서버의 port번호는 미리 정해져 있어서 큰 어려움은 없다.

-하지만 IP주소를 알아내는 것은 다른문제이다. 주어진 URL을 바탕으로 해당 resource가 제공되는 서버의 IP 주소를 알려주는 시스템이 필요하다. 이 시스템을 DNS라고 한다.

-URL이나 호스트 이름은 사용자의 컴퓨터가 먼저 운영체제가 관리하는 hosts 라는 파일에서 IP주소를 검색하여 사용한다. 해당 hosts 파일에 존재하지 않는 URL이나 호스트 이름은 DNS 를 통해 IP주소로 변환된다.

## DNS란?

기본적으로 IP주소와 URL/host name의 mapping table을 유지/관리/제공 해주는 시스템이다.

<img width="800" alt="스크린샷 2019-10-09 오전 5 44 05" src="https://user-images.githubusercontent.com/48313074/66431874-d5b56500-ea57-11e9-991c-165ba6d8cce4.png">

### Domain Name Space

역트리 형태의 128level 의 계층적인 구조

-"Domain" 은 Domain name space의 subtree

-subtree는 하나의 최상위 레벨 노드와 여기서 부터 파생된 모든 하위노드들만 포함한다.

-이 subtree 혹은 domain 은 domain에서 가장 상위 level entity로 대표되고 명명된다.





<img width="800" alt="스크린샷 2019-10-09 오전 5 55 30" src="https://user-images.githubusercontent.com/48313074/66432597-6b052900-ea59-11e9-9322-01b4f15f815a.png">

-root level은 label이 없지만 root를 제외한 모든 level에는 고유의 이름 (label)이 잇으며 Domain name은 subtree의 최상위 노드의 label부터 시작해서 root까지 모든 노드의 label을 포함하는 이름으로 결정되며 label은 점으로 구분된다.

Ex) kr/ac.kr/smu.ac.kr/ens.smu/ac.kr.은 모두 subtree를 나타내며 따라서 domain의 이름이다.

##### TLD

Root level바로 아래 노드에서 시작 되는 domain을 TLD(Top level domain)이라고 한다.

1.gTLD = com , org ..

2.ccTLD = kr , jp



