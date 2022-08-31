package level2

class Solution {
    fun solution(numbers: IntArray): String {
        val answer = numbers.sortedByDescending { it.toString().repeat(3).take(4) }.joinToString("")
        return if (answer.startsWith("0")){
            "0"
        } else {
            answer
        }

    }
}

fun main(){
    println(Solution().solution(intArrayOf(6, 10, 2)))

}
