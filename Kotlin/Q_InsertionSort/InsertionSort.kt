import java.util.*

fun selectionSort(arr:Array<Int>) : Unit{

    var n: Int = arr.size
    var temp: Int
    var minIndex : Int = 0
    for (i in 0 until n - 1) {

        minIndex = selectMin(arr, i + 1, n - 1)
        temp = arr[i]
        arr[i] = arr[minIndex]
        arr[minIndex] = temp
    }

}

fun selectMin(arr :Array<Int> , left : Int , right : Int) :Int{
    var minIndex = left

    for ( i in left..right){
        if (arr[minIndex]> arr[i]) {
            minIndex = i
        }

    }
    return minIndex
}


fun main(Args:Array<String>){
    var arr: Array<Int> = arrayOf(9, 8, 1, 3, 4, 2, 5, 6)

    selectionSort(arr)
    println(Arrays.toString(arr))
}