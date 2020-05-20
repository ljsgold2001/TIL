fun isPrime(num: Int) : Boolean{
    for( i in 2 until num){
        if(num % i ==0)
            return false
    }
    return true
}


fun main (args: Array<String>){
    val num : Int = 15

    if(isPrime(num))
        println("$num is prime")
    else
        println("$num is not prime")
}