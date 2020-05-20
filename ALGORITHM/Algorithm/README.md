#  정렬1 : 버블정렬 (bubble sort)

-  두 이접한 데이터를 비교해서 앞에 있는 데이터가 크다면 자리를 바꾸는 정렬 알고리즘

<img src="https://upload.wikimedia.org/wikipedia/commons/c/c8/Bubble-sort-example-300px.gif" width=600/>

> 출처: https://en.wikipedia.org/wiki/Bubble_sort



- 알고리즘 구현

  - n개의 리스트가 있는경우 최대 n-1번의 로직을 적용한다.

  - 로직을 1번 적용할 때마다 가장 큰 숫자가 뒤에 1개씩 결정됨

  - 만약 데이터가 한번도 교환된 적이 없다면 이미 정렬된 상태이기 때문에 로직을 반복 적용할 필요가 없다.

    - For num in range(len(data_list))만큼 반복
    - swap 변수 지정
    - 두번째 반복문 작성 len(data_list) - index -1번만큼
    - 두번째 반복문안의 조건문 data_list[index] >data_list[index +1]
    - swap해줌
    - swap변수를 가지고 정렬되었는지 되지 않았는지 판단후 정렬되었으면 break 후 종료

    

- 알고리즘 분석

  - 반복문이 2개이기 때문에  O($n^2$)
  - 최악의 경우, n*(n-1)/2

  * 완전 정렬이 되어 있는 상태라면 최선은 O(n)



# 정렬2 : 선택정렬(selection sort)

- 선택정렬이란
  - 주어진 데이터중에서 최소값을 찾음
  - 해당 최솟값을 데이터의 맨앞에 위치한 값과 교체함
  - 맨앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복함

<img src="https://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif" width=100>

출처: https://en.wikipedia.org/wiki/Selection_sort



# 정렬3 : 삽입정렬(insertion sort)

- 삽입정렬이란?
  - 삽입정렬은 두번째 인덱스에서부터 시작한다.
  - 해당 인텍스 앞에있는 데이터부터 비교해서 큰값이 만날때까지 이동

<img src="https://upload.wikimedia.org/wikipedia/commons/9/9c/Insertion-sort-example.gif" />

> 출처: https://commons.wikimedia.org/wiki/File:Insertion-sort-example.gif



- 시간복잡도
  - O(n^2)



# 재귀 용법(recursive call , 재귀 호출)

- 재귀 용법
  - 함수 안에서 동일한 함수를 호출하는 형태
  - 여러 알고리즘 작성시 사용한다.



- 일반적인 형태
  - def function(입력):
        if 입력 > 일정값: # 입력이 일정 값 이상이면
            return function(입력 - 1) # 입력보다 작은 값
        else:
            return 일정값, 입력값, 또는 특정값 # 재귀 호출 
  - def function(입력):
        if 입력 <= 일정값:              # 입력이 일정 값보다 작으면
            return 일정값, 입력값, 또는 특정값              # 재귀 호출 종료
        function(입력보다 작은 값)
        return 결과값
- <img src="https://www.fun-coding.org/00_Images/recursivecall.png" />
- 파이썬은 최대 재귀호출의 횟수 1000회 이하



# 동적계획법(Dynamic Programming)과 분할 정복(Divide and Conquer)

- 동적계획법(DP)
  - 입력의 크기가 작은 부분 문제들을 해결하고 해당 문제의 해를 활용해서 보다 큰 크기의 부분 문제를 해결하고 결과적으로 전체의 문제를 해결하는 알고리즘이다.
  - Bottom -up 접근법으로 가장 최하위 답을 구하고 이를 저장하고 그 값을 이용해서 상위 문제를 해결해 나간다.
    - memoization(메모이제이션)
      - 메모이제이션이란 프로그램 실행시 이전에 계산한 값을 저장하여 다시 계산하지 않도록 하여 전체 실행 속도를 빠르게 하는 것이다.
      - 문제를 쪼갤때 부분 문제는 중복되며 재활용 되기 때문이다.
- Divde and Conquer
  - 문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 다시 합병하여 문제의 답을 얻는 알고리즘
  - Top-down 접근법으로 , 상위의 해답을 구하기위하여 아래로 내려가면서 하위의 답을 구하는 방식이다.(재귀함수)
  - 문제를 쪼갤때 부분문제는 서로 중복되지 않는다.
- 공통점
  - 문제를 쪼개서 가장 작은 단위로 분할한다.
- 차이점
  - 동적계획법
    - 부분 문제는 중복되고 상위 문제 해결에 재활용됨
    - 메모이 제이션 기법 사용
  - 분할 정복
    - 부분 문제는 서로 중복되지 않음
    - 메모이제이션 기법 사용하지 않음

# Quick sort

- 기준점을 정해서 기준점보다 작은 데이터는 왼쪽 큰 데이터는 오른쪽으로 모으는 함수를 작성함
- 각 왼쪽 오른쪽은 재귀용법을 사용해서 다시 동일함수를 호출하는 작업을 방법
- 함수는 왼쪽 기준점 오른쪽을 리턴함
  - 알고리즘 분석
    - 최악의경우 
      - 시간복잡도는 O(nlogn)
      - worst case
        - 처음 피벗이 최소 혹은 최대값일경우 O(n^2)
        - <img src="https://www.fun-coding.org/00_Images/quicksortworks.jpg" />





# Merge sort

- 재귀용법을 활용한 정렬 알고리즘

  - 리스트를 절반으로 잘라서 비슷한 크기의 두 부분의 리스트로 나눈다.

  - 각 부분 리스트를 재귀적으로 합병 정렬을 이용해서 정렬한다.

  - 두 부분 리스트를 하나의 정렬된 리스트로 합병한다.


<img src="https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif" width=500/>

출처: [위키피디아](https://ko.wikipedia.org/wiki/%ED%95%A9%EB%B3%91_%EC%A0%95%EB%A0%AC)





<img src="https://www.fun-coding.org/00_Images/mergesortcomplexity.png" />

- 시간복잡도
  - 루트를 0의 depth라고 했을때 각단계마다 각단계는 o(n)
  - 각 depth마다 2^depth만큼의 노드를 가지고 있다.
  - 2^depth * 2^depth /n = O(N)
- 단계는 항상 log2의 n 개가 만들어지기때문에 O(N) * O(logN)
- 즉 O(NlogN)



# 이진탐색

- 분할정복 알고리즘 (Divide and Conquer)
  - Divide : 문제를 하나 또는 둘 이상으로 나눈다.
  - Conquer: 나눠진 문제가 충분히 작고, 해결이 가능하다면 해결하고 아니라면 다시나눔
- 이진탐색
  - Divide : 리스트를 두개의 서브 리스트로 나눈다.
  - conquer
    - 검색할 숫자(search) >중간값이면 뒷부분의 서브리스트에서 검색
    - 검색할 숫자(search) < 중간값이면 앞부분의 서브리스트에서 검색 



- 시간복잡도
  - n개의 리스트를 매번 2로 나누어 1이 될때까지 비교연산을 k회 진행한다.
  - 점차 반씩 줄어 나가는 것이기 때문에 O(logN)



# 순차탐색

- 탐색은 여러 데이터 중에서 원하는 데이터를 찾아내는 것이다.
- 데이터가 담겨있는 리스트를 앞에서부터 하나씩 비교해서 원하는 데이터를 찾는 방법
- 시간복잡도
  - O(n)



# 그래프

- 그래프는 실제 세계의 현상이나 사물을 vertex(정점) 혹은 노드(node)와 간선(edge)로 표현하기 위해서 사용한다.

<img src="https://www.fun-coding.org/00_Images/graph.png" width=400>



- 노드 : 위치를 말함 , 정점(vertex)라고도 함

- 간선 : 위치 간의 관계를 표시한 선으로 노드를 연결한 선이라고 보면 됨

- 인접 정점(adjacent Vertex) : 간선으로 직접 연결된 정점(Node)

- 정점의 차수 : 무방향 그래프에서 하나의 정점에 인접한 정점의 수

- 진입 차수 : 방향그래프에서 외부에서 오는 간선의 수

- 진출 차수 : 방향 그래프에서 외부로 향하는 간선의 수

- 단순 경로 : 처음 정점과 끝 정점을 제외하고 중복된 정점이 없는 경로

- 사이클 : 단순 경로의 시작 정점과 종료 정점이 동일한 경우




### 그래프의 종류

- ####무방향 그래프

- <img src="https://www.fun-coding.org/00_Images/undirectedgraph.png" width=300>

  - 방향이 없는 그래프
  - 간선을 통해 노드는 양방향으로 갈 수 있음
  - 보통 노드 A,B가 연결 되어 있을 경우 (A,B) 혹은 (B,A)로 표기

- ####방향그래프

- <img src="https://www.fun-coding.org/00_Images/directedgraph.png" width=300>

  - 간선에 방향이 있는 그래프 
  - 보통 노드 A,B가 A->B로 가는 간선으로 연결되어 있을 경우 <A,B>로 표시한다.

- ####가중치그래프(weighted Graph or Network)

  - <img src="https://www.fun-coding.org/00_Images/weightedgraph.png" width=300>
  - 간선에 비용 또는 가중치가 할당된 그래프

- ####연결그래프 혹은 비연결 그래프

- <img src="https://www.fun-coding.org/00_Images/disconnectedgraph.png" width=300>

  - 연결그래프
    - 무방향 그래프에 있는 모든 노드에 대해 항상 경로가 존재하는 경우
  - 비연결그래프
    - 무방향 그래프에서 특정 노드에 대해 경로가 존재하지 않는 경우

- #### 사이클과 비순환그래프 (Cycle or Acyclic Graph)

- <img src="https://www.fun-coding.org/00_Images/acyclicgraph.png" width=300>

  - 사이클
    - 단순 경로의 시작노드와 종료 노드가 동일한 경우
  - 비순환그래프(Acyclic)
    - 사이클이 없는 그래프 (위의 그래프는 비순환 그래프이다)

- #### 완전그래프(Complete Graph)

- <img src="https://www.fun-coding.org/00_Images/completegraph.png" width=300>

  - 그래프의 모든 노드가 서로 연결되어 있는 그래프




# DFS 와 BFS

- BFS : 정점들과 같은 레벨에 있는 노드들을 먼저 탐색하는 방식
- DFS: 정점의 자식들을 먼저 탐색하는 방식



<img src="https://www.fun-coding.org/00_Images/BFSDFS.png" width=700>



- BFS 방식: A - B - C - D - G - H - I - E - F - J 
- DFS 방식: A - B - D - E - F - C - G - H - I - J 



- BFS 와 DFS의 차이
  - BFS는 두개의 큐를 활용하는데 반해 DFS는 스택과 큐를 활용한다.



- 시간복잡도
  - 노드 수 : V
  - 간선 수 : E
    - 시간복잡도 = O(V+E)



#	Greedy 알고리즘

-  그리디 알고리즘이란?
  - 탐욕알고리즘이라고 불리운다.
  - 최적의 해에 가가운 값을 구하기위해서 사용된다.
  - 여러경우 중 하나를 결정해야 할 때마다 매순간 최적이라고 생각되는 경우를 선택하는 방식으로 진행하여 최종적인 값을 구하는 방식이다.
- EX1) - 동전문제
  - 지불해야하는 값이 4720원일때 1원 50원 100원 500원 동전으로 동전의 수가 가장 적게 지불하는 방법은?
    - 가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현 가능하다.
    - 탐욕 알고리즘으로 매순간 최적인 경우를 선택해야한다.
- EX2) - 부분 배낭 문제
  - 무게 재한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
  - 각 물건은 무게(W) 와 가지(v)로 표현될수 있음
  - 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음 그래서 Fraction knapsack problem으로 불리운다.
- 그리디 알고리즘의 한계
  - 그리디 알고리즘은 근사치 추정에 활용한다.
  - 반드시 최적의 해를 구할 수 잇는 것은 아니다.
  - 최적의 해에 가까운 값을 구하는 방법 중에 하나이다.

<img src="https://www.fun-coding.org/00_Images/greedy.png" width=300>

- 그리디 알고리즘을 적용했을 경우 답이 달라진다.



# 최단경로 알고리즘

- 최단경로문제란?
  - 최단 경로 문제란 두 노드를 잇는 가장 짧은 경로를 찾는 문제이다.
  - Weighted Graph에서 Edge의 가중치의 합이 최소가 되도록 하는 경로를 찾는 것이 목적이다.
- 최단경로 문제의 종류
  - 단일출발 단일도착
    - 그래프 내에서의 특정 노드에서 출발하여 특정 노드에 도착하는 가장 짧은 경로를 찾는 문제이다.
  - 단일출발 최단경로문제
    - 그래프 내의 특정 노드와 그래프 내의 모든 노드 각각의 짧은 경로를 찾는 문제이다.
  - 전체 쌍의 최단 경로
    - 그래프 내의 모든 노드 쌍에 대한 최단 경로를 찾는 문제
- **다익스트라 알고리즘**
  - 하나의 정점에서 모든 정점간의 각각 짧은 거리를 구하는 문제다.
- 로직
  - 첫 정점을 기준으로 연결되어 있는 정점들을 추가해 가며 최단 거리를 갱신하는 기법
  - 다익스트라 알고리즘은 너비우선탐색(BFS)와 유사하다.
    - 첫 정점부터 각 노드 간의 거리를 저장하는 배열을 만들고 첫 정점의 인접 노드 간의 거리부터 먼저 계산하면서 첫 정점부터 해당 노드간의 가장 짧은 거리를 해당 배열에 업데이트한다.
  - 우선순위 큐를 활용하여 다익스트라 알고리즘을 구현한다.
    - 우선순위 큐는 MinHeap 방식을 활용해서 현재 가장 짧은 거리를 가진 노드정보를 먼저 꺼내게된다.
  - 1. 첫 정점을 기준으로 배열을 선언하여 첫 정점에서 각 정점까지의 거리를 저장
       1. 초기에는 첫 정점의 거리는 0 나머지는 무한대(inf)로 저장한다.
       2. 우선순위 큐에만 먼저 넣음
    2. 우선순위 큐에서 노드를 꺼낸다.
       1. 처음에는 첫 정점만 저장되있음으로 첫 정점이 꺼내진다.
       2. 첫 정점에 인접한 노드들 각각에 대해 첫 정점에서 각 노드로 가는 거리와 현재 배열에 저장되어 있는 첫 정점에서 각 정점까지 거리를 비교하낟.
       3. 배열에 저장되어 잇는 거리보다 첫 정점에서 해당 노드로 가는 거리가 더 짧을 경우 배열에 해당 노드의 거리를 업데이트한다.
       4. 배열에 해당 노드의 거리가 업데이트 된 경우 , 우선순위 큐에 넣는다.
    3. 2번의 과정을 우선순위 큐에서 꺼낼 노드가 없을때까지 반복한다.



<img src="https://www.fun-coding.org/00_Images/dijkstra.png" width=300>

- <img src="https://www.fun-coding.org/00_Images/dijkstra_initial.png">
- <img src="https://www.fun-coding.org/00_Images/dijkstra_1st.png">
- <img src="https://www.fun-coding.org/00_Images/dijkstra_2nd.png">
- <img src="https://www.fun-coding.org/00_Images/dijkstra_3rd.png">
- <img src="https://www.fun-coding.org/00_Images/dijkstra_3-2th.png">
- <img src="https://www.fun-coding.org/00_Images/dijkstra_4th.png">
- <img src="https://www.fun-coding.org/00_Images/dijkstra_5th.png">



- 다익스트라 알고리즘 시간복잡도
  - 다익스트라 알고리즘은 크게 두가지 경우를 가짐
    - 1.각노드의 인접한 간선들을 모두 검사하는 과정 - 각 노드는 최대 한번씩 방문함으로 O(E)
    - 2.우선순위 큐에 노드/거리 정보를 넣고 삭제 pop하는 과정 - worst case는 모든 간선이 검사되고 최단거리가 업데이트된다 O(E) 또 우선순위 큐를 유지하는 경우의수는 O(logE)
      - 따라서 O(E) + O(ElogE) = O(ElogE)
- 힙의 시간 복잡도
  - Depth(트리의 높이) =h 라고 한다면  최악의 경우 root 에서 leaf까지 비교해야 함으로 H =log2n 에 가까움으로 시간복잡도는 O(logn)이다.



# 최소신장트리의 이해

- 신장 트리란?
  - Spanning Tree 또는 신장트리라고 불리운다.(Spanning Tree)
  - 원래의 그래프의 모든 노드가 연결되어 있으면서 트리의 속성을 만족하는 그래프
  - 신장트리의 조건
    - 본래의 그래프의 모든 노드를 포함해야함
    - 모든 노드가 서로 연결되어있어야한다.
    - 트리의 속성을 만족시켜야한다.(사이클이 존재하지않음)
-   <img src="https://www.fun-coding.org/00_Images/spanningtree.png">
- 최소 신장트리
  - Minimum Spanning Tree ,MST라고 불리움
  - Spanning Tree중에서 간선의 가중치 합이 최소인 Spanning Tree 를 지칭함

<img src="https://www.fun-coding.org/00_Images/mst.png" width=600>



- 크루스칼 알고리즘(Kruskal's algorithm)
  - 모든 정점을 독립적인 집합으로 만든다.
  - 모든 간선을 비용을 기준으로 정렬하고, 비용이 작은 간선부터 양 끝의 두 정점을 비교한다.
  - 두 정점의 최상위 정점을 확인하고 서로 다를 경우 두 정점을 연결한다.
    - 탐욕알고리즘을 기초로하고있다.

<img src="https://www.fun-coding.org/00_Images/kruscal_internal1.png" width=650>

<img src="https://www.fun-coding.org/00_Images/kruscal_internal2.png" width=800>



- Union Find 알고리즘

  - Disjoint set을 표현할 때 사용하는 알고리즘으로 트리 구조를 활용하는 알고리즘
  - 노드들 중에 연결된 노드를 찾거나 , 노드들을 서로 연결할때 사용한다.

- 1.초기화

  - n개의 원소가 개별 집합으로 이뤄지도록 초기화
  - <img src="https://www.fun-coding.org/00_Images/initial_findunion.png" width=400>

- 2.Union

  - 두 개별 집합을 하나의 집합으로 합친다. 두 트리를 하나의 트리로 만듬
  - <img src="https://www.fun-coding.org/00_Images/union_findunion.png" width=600>

- 3.Find

  - 여러 노드가 존재할때 두 개의 노드를 선택해서 , 현재 두 노드가 서로 같은 그래프에 속하는지 판별하기 위해, 각 그룹의 최상단 원소를 확인
  - <img src="https://www.fun-coding.org/00_Images/find_findunion.png" width=500>

- Union-Find 알고리즘의 고려할점

  - Union 순서에 따라서 최악의 경우 링크드 리스트 같은 형태가 될 수 있다.
  - 이 때는 Find/Union시 계산량이 O(N)이 될 수 있으므로 해당 문제를 해결하기위하여 Union by Rank / path -compression기법을 사용한다.
  - <img src="https://www.fun-coding.org/00_Images/worst_findunion.png" width=200>

- Union-by-rank기법

  - 각 트리에 대해 높이(rank)를 기억해 두고 Union시에 두 트리의 높이(rank)가 다르면 높이가 작은 트리를 높이가 큰 트리에 붙인다. 

    <img src="https://www.fun-coding.org/00_Images/unionbyrank_findunion.png" width=700>

  - 높이가 h-1인 두개의 트리를 합칠때에는 한 쪽의 트리 높이를 1 증가시켜 주고 다른쪽의 트리를 해당 트리에 붙인다.

  <img src="https://www.fun-coding.org/00_Images/unionbyranksame_findunion.png" width=700>

- Union by rank 기법을 사용하면 union/find 연산의 시간복잡도는 O(n)이 아닌 O(logn)으로 낮출수 있다.





- path compression
  - find를 실행한 노드에서 거쳐간 노드를 루트에 다이렉트로 연결하는 기법
  - find 를 실행한 노드는 이후부터는 루트노드를 한번에 알 수 있다.

<center><img src="https://www.fun-coding.org/00_Images/pathcompression_findunion.png" width=400></center>



# Prim algorithm



- 대표적인 최소 신장 트리 알고리즘중 하나
- 프림알고리즘이란?
  - 시작 정점을 선택하고 정점에 인접한 간선중 최소 간선으로 연결된 정점을 선택하고 해당 정점에서 다시 최소 간선으로 연결된 정점을 선택하는 방식으로 최소 신장트리를 확장해 나가는 방식이다.
- Kruskal VS Prim
  - 둘다 그리디 알고리즘을 기초로하고있다.
  - Kruskal알고리즘은 가중치가 가장작은 간선부터 선택하여 MST를 구한다.
  - Prim 알고리즘은 특정 정점에서 시작해서 해당 정점에 연결된 가장 작은 가중치를 선택하고 연결된 정점들에 연결된 간선 중에서 가장 가중치가 작은 간선을 택한다.

<img src="https://www.fun-coding.org/00_Images/prim1.png" width=800>

<img src="https://www.fun-coding.org/00_Images/prim2.png" width=800>

<img src="https://www.fun-coding.org/00_Images/prim3.png" width=800>

-  heapq 라이브러리를 활용해서 우선순위 큐사용한다.



- 시간복잡도
  - 최악의 경우 while 구문에서 모든 간선에 대해 반복하고 최소 힙 구조를 사용하므로 O(ElogE)시간복잡도를 가진다.
  - 개선된 프림알고리즘 O(ElogV)



# 백트래킹기법

- 백트래킹 또는 퇴걱검색(backtrack)으로 부름
- 제약 조건 만족 문제 에서 해를 찾기 위한 전략
  - 해를 찾기위해서 후보군의 제약조건을 점진적으로 체크하다가 해당 후보군이 제약 조건을 만족 할 수 없다고 판단 되는 즉시 backtrack(다시는 이 후보군을 체크하지 않을것으로 표기)하고 다음 후보군으로 넘어가며 최적의 해를 찾는 방법이다.
- 실제 구현시 고려할 수 있는 모든 경우의수(후보군)을 상태공간트리를 통해 표현
  - 각 후보군을 DFS방식으로 확인
  - 상태 공간 트리를 탐색하면서 제약이 맞지 않으면 해의 후보가 될만한 곳으로 바로 넘어가서 탬색한다.
    - Promising : 해당 루트가 조건에 맞는지를 검사한다.
    - Pruning :조건에 맞지 않으면 포기하고 다른 루트로 돌아서서 탐색의 시간을 절약한다
- 즉 결론 백 트래킹은 트리 구조를 기반으로 DFS를 통해서 깊이탐색을 하다가 각 루트에 대해 조건이 부합하는지 체크(promising) 만약 해당 트리에서 조건에 맞지 않는 노드는 DFS로 깊이 탐색을 하지않고 가지를 친다.(pruning)



- 상태 공간트리
  - 문제 해결 과정의 중간 상태 노드를 각각의 노드로 나타낸다.

<img src="https://www.fun-coding.org/00_Images/statespacetree.png" width=300>



