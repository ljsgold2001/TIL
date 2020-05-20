fun drawStar(num : Int): Unit{

    var j : Int = if(num%2==0) num/2 else num/2+1 // 높이
    var m : Int = if(num%2==0) 2*j else 2*j-1 //찍어야하는 별의개수
    var k : Int
    var l : Int

    println("height is $j")
    for ( i in 1..j){ // j = 높이이기때문에 높이만큼 반복한다.
        //공백찍기
        if(num %2 ==0) {
            for (k in 1..m / 2 - i) {
                print("  ")
            }
        }
        else{
            for(k in 1..m/2 -i +1){
                print("  ")
            }
        }

        //별찍기
        if(num%2 ==0){
            for ( k in 1..2*i){
                print("* ")
            }
        }
        else{
            for( k in 1 until 2*i){
                print("* ")
            }
        }


        println(" ")

    }

}
fun main(args: Array<String>){
    val num : Int = 15
    drawStar(num)
}

//  0 0 * *     1           0 0 *      1
//  0 * * * *   2           0 * * *    2
//  * * * * * * 3           * * * * *  3
// 밑에있는 별의 개수가 짝수이면  num %2 ==0 이면 높이는 num/2 찍어야하는 별의개수 2*num
// 밑에있는 별의 개수가 홀수이면  num %2 !=0 이면 높이는 num/2 +1 찍어야하는 별의개수 2*num -1
// 높이만큼 반복하면되겠다.
// 짝수일경우에 1 -> 공백 2번 별 2번 2-> 공백 1번 별 4번 3-> 공백 0번 별 6번
// 홀수일경우에 1 -> 공백 2번 별 1번 2-> 공백 1번 별 3번 3-> 공백 0번 별 5번
// 짝수일때 찍어야하는 공백의 개수 + 반복 횟수번째 = 찍어야하는별의개수/2 즉 찍어야하는 공백의 개수 = 찍어야하는별의개수/2-반복횟수번째

