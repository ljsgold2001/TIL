typealias Number = Int

fun main(args: Array<String>){
    val a: Number =10
    val c:Char = 'k'
    val s1= "HelloWrold!!\n"
    val s2= "Hello world"
    val s3 :String = "helloworld"
    val a1 :Int =10
    val b1: Int =20
    val ex: Int = 5%1
    var a2 : Array<Int> = arrayOf(5,4,3,2,1)
    var b2 = Array(5,{i ->5-i})
    println("a+b = ${a1+b1}")
    println(a)
    println(c)
    println(s1)
    println(s2)
    println(s3)
    println(a2[0])
    println(b2[2])
    println(a2[0])
    a2.get(0)
    println(a2[0])
    a2.set(0,10)
    println(a2[0])
    a2.iterator()
    println(ex)
}

