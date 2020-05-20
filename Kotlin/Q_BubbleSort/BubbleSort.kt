import java.util.*

fun bubbleSort(arr:Array<Int>): Unit {
    val n :Int = arr.size
    var temp :Int
    var i : Int = 0
    var j : Int

    while(i<n-1){//배열의 사이즈보다 1작을때까지
        j = n-2//마지막인자의 하나전부터 ps 싱크소트와 버블소트를 구분해야한다.
        while(j>=i){//i는 첫번째 인덱스를 가리키고있으며 j는 끝에서 i가있는 곳까지 쭉훑어야되기 때문에
            if(arr[j]>arr[j+1]){//마지막 인덱스 전과 마지막인덱스 비교시작 j>=i일때까지 내려간다.
                temp = arr[j] // Swap함수
                arr[j] = arr[j+1]
                arr[j+1] = temp
            }
            j-- //i를 만날때까지 내려간다.
        }
    i++//첫번째자리가 정해지면 i를 1증가시켜서 같은작업반복
    }

}
fun main(args: Array<String>){
    var arr : Array<Int> = arrayOf(9,8,1,4,5,2,3,6,7)
    println(Arrays.toString(arr))
    bubbleSort(arr)
    println(Arrays.toString(arr)) //println 의 인자로는 String밖에 올수없기때문에 import.java.util에서 배열을 스트링으로 바꾸어서 출력해야함
}