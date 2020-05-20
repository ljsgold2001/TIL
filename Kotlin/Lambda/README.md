# Lambda

### 함수를 {매개변수 ->함수내용}의 형태로 정의 하는 방법

```kotlin
fun main (args: Array<String>) {
    
    val instantFunc = {
        number: Int ->println("Hello summer")
    }
    instantFunc(33)
    instantFunc.invoke(33)
}
```

#### 함수 내용에서 마지막 문장이 return이면 return을 생략할 수 있음

```kotlin
fun sum(a :Int , b :Int) : Int {
    return a+b
}
```

convert to

```kotlin
fun sum ={ a : Int , b : Int -> a+b }
```

### 익명함수(anonymous function)



### 함수참조

함수 타입의 변수는 이미 선언된 함수나 객체의 member 함수를 가리킬수있다.

```kotlin
fun plus (a : Int , b : Int ) = println("a+b = ${a+b}")

object Object {
    fun minus( a : Int , b : Int ) = println("a-b = ${a-b}")
}
class Class{
    fun average (a : Int, b : Int ) = println("In class , average = ${(a+b)/2}")

}


fun main (args : Array<String>){
    var instantFunc : (Int, Int) ->Unit

    instantFunc =::plus
    instantFunc(30,20)

    instantFunc =Object::minus
    instantFunc(50,20)

    instantFunc = Class()::average
    instantFunc(50,20)

}
```

### 고차함수

장식을 담당하는 함수를 만들고 연산을 수행하는 함수를 인자로 전달

```kotlin
fun decorate (task: ()->Unit){
    println("===============start===============")
    task()
    println("===============end=================")
}

fun main(args:Array<String>){
    decorate {
        var a : Int = 10
        var b : Int = 30
        println("$a + $b = ${a+b}")
    }
}
```

### Collection과 lambda

예) 이름과 나이로 정의된 class에서 가장 나이가 많은 사람을 찾는 문제

###### data class란?

데이터 클래스란 클래스가 data를 보유 하면서 아무것도 하지 않는 클래스를 말한다.

일반클래스와 데이터 클래스를 비교하자면 데이터 클래스는 입력한 정보가 나오지만 일반 클래스는 주소값이 나온다. 따라서 데이터를 다뤄야 할때는 데이터 클래스가 유용하다.



```kotlin
data class Person(val name: String, val age: Int)



fun findOldest(people :List<Person>){
    var maxAge = 0
    var theOldest: Person? =null

    for (person in people){
        if(person.age>maxAge){
            maxAge = person.age
            theOldest = person


        }
    }

}


fun main(args:Array<String>){
    val people = listOf(Person("김상명",25),Person("이지수",26))
    findOldest(people)

    println(people.maxBy { it.age })
    println(people.maxBy { p: Person -> p.age })
}
```



### Filter

lamda 식의 일종으로 collection의 원소를 filtering

예) 배열에서 짝수만 뽑아서 저장

```kotlin
fun main(args:Array<String>){
    val list = listOf(1,2,3,4,5,6,7,8,9)
    val elist = list.filter{it %2 ==0}

    println(elist)

}
```

결과값 : 2,4,6,8

Identifier it=람다식에서 인수가 한개인경우 아예 생략하고 인수를 it으로 접근할수있다.

