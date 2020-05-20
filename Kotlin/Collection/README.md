# collection

###-콜렉션이란?

다양한 리스트 기반의 자료구조를 제공한다.

mutable과 immutable을 구분해서 선언해야한다 ( ex var 과 val의 차이)

​	val/immutable - 값을 변경할수 없다.

​	var/mutable - 값을 변경할수 있다.

1.List/MutableList

2.Set/MutableSet

3.Map/MutableMap

<img width="800" alt="스크린샷 2019-10-05 오후 4 15 20" src="https://user-images.githubusercontent.com/48313074/66251476-6b68a000-e78b-11e9-8341-31605f63a31b.png">



### 콜렉션의 예

```kotlin
fun main (args: Array<String>) {
    val list: Collection<Int> = listOf(10,20,30)
    val set : Collection<Int> = setOf(1,2,3,1,2,2)
    val map : Map<String, String> = mapOf("apple" to "사과","banana" to "바나나" )

    println(list)
    println(set)
    println(map)


}
```



### collection의 멤버

1.Iterable<E> - iterator의 멤버를 collection에 추가

2.size - Int

3.isEmpty(element E): Boolean

4.contains(element E) : Boolean

5.containsAll(elements : Collection<E>): Boolean

```kotlin
println(list.size)
println(list.isEmpty())
println(list.contains(10))
```



### List

- 순서를 가지고 객체를 관리하는 collection
- 배열과 유사함
- List는 크기를 정하지 않고 생성하여 관리하는 객체를 계속 추가할수있음
- 생성할때 관리할 객체를 정해야함
- 생성 이후에는 추가, 삭제 등의 수정작업은 불가능하다.
- 많이 사용하는 함수
    		1. Get : list가 관리하는 객체를 반환한다.
    		2. indexOf : 지정된 객체의 인덱스 번호를 반환한다.
    		3. subList : list의 일부분을 복제하여 새로운 List를 생성한다
    		4. First/last : 첫번째/마지막 원소를 리턴한다.
    		5. filter : {수식// it%2 ==0}: 수식을 만족하는 원소만 걸러낸다.



### MutableList

- List를 상속받음

- 관리하는 객체들의 수정이 가능하다.

- 많이 사용하는 함수

  ​	1.add : 객체를 추가한다.

  ​	2.removeAt : 객체를 제거한다.

  ​	3.set: 객체를 설정한다.

  ​	4.clear :관리하는 모든 객체를 제거한다.

### Set

- 중복되지 않게 관리하는 collection

- 자체적으로 객체를 가져오지는 못하며 Iterator 라는 collection을 이용해야함

- 많이 사용하는 함수들

  ​	1.Setof, mutableSetof : 셋을 생성한다.

  ​	2.iterator: iterator 로 만들어 반환

  ​	3.add : 객체를 추가

  ​	4.remove: 객체를 제거

### Map

- 이름을 통해 객체를 관리하는 collection

- 많이 사용하는 함수들

  ​	1.mapOf,mutableMapOf : Map을 생성한다.

  ​	2.put : map에 객체를 추가한다.

  ​	3.get : map에서 객체를 가져온다.

  ​	4.set: map에 기존 객체를 덮어씌운다.

  ​	5.remove : map에서 객체를 제거한다

  