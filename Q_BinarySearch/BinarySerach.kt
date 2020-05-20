
fun binarySearch(arr:Array< Int> ,left : Int , right : Int, value : Int) : Int {

        //case1  중간을 찾았을때 한번에 찾는 값일경우
        //case2  중간을 기준삼았을때 기준보다 작았을경우에
        //case3  중간을 기준삼았을때 기준보다 컸을경우에
        //재귀이용

        var mid : Int = (left +right)/2

        if (arr[mid] == value){
            return mid
        }
        else if (arr[mid]>value){
            return  binarySearch(arr, left ,mid-1,value)
        }
        else
            return binarySearch(arr, mid+1 , right,value)

    }

fun main(args: Array<String>){
    var arr :Array<Int> = arrayOf(10,20,30,40,50,60,70,80,90,100)//이진탐색은 항상 정렬 되어 있어야한다.
    var n : Int = arr.size

    var findIndex : Int = binarySearch(arr,0,n-1,100)

    println("findIndex : $findIndex")


}