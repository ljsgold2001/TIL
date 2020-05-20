## NULL SAFETY

<img width="800" alt="스크린샷 2019-10-06 오후 4 26 46" src="https://user-images.githubusercontent.com/48313074/66265727-2493ac80-e856-11e9-9dad-3208bc9e5846.png">

*여기서 reference란 포인터를 가리킨다.

### null이 저장될 수 있는 변수와 저장될 수 없는 변수를 구분해서 표현

```kotlin
var a : String = "abc"
a = null // 컴파일에

var b : String? = "abc"
b = null //컴파일 성공
```

### Null check - > safe call

```kotlin
var a = "abc"
if ( a != null && a.length > 0 )
    println("String length is ${a.length}") 
else
println("Empty string")
```



```kotlin
var b: String? = "abc"
println(b?.length) // b가 null이면 null을 출력
```

abc는 null이 될수 있다.

### Evis Operator(?:)

```java
if ( b != null )
    val l = b.length;
else
    val l = -1;
```

conver to

```kotlin
val l =  (b != null) ? b.length : -1
```

```kotlin
val l = if (b != null) b.length else -1
```

```kotlin
val l = b?.length ?: -1
```

if /else - > ? :

### Not-Null assertion operator(!!)

!! - > 프로퍼티나 변수에 붙게 되면 강제로 null이 아님을 선언해준다.

```kotlin
val b : String = "abc"
val l = b!!.length
```

결과값 = 3

### Not-Null pointer exception 을 강제로 발생 ->try/catch

```kotlin
val l = try{
    b!!.length
}catch(e : NullPointerException){
    0
}
```

### throw 문을 이용

```kotlin
val l = b.length ?: throw NullPointerException("b is null")
```

### Safe cast(as?)

코틀린에서는 특정 변수를 자신이 원하는 자료형으로 변환하기 위해서 as 연산자를 사용한다.

```kotlin
val aInt : Int? = b as? Int
```

### Collections of nullable types

```kotlin
val nullableList : List<Int?> = listOf(1,2,null,4)
```