package level1



fun main() {
    println(Solution().solution("one4seveneight"))
    
}

class Solution {

    fun solution(s: String): Int {
        val map = hashMapOf<String, String>("zero" to "0", "one" to "1", "two" to "2",  "three" to "3", "four" to "4", "five" to "5", "six" to "6",
                "seven" to "7", "eight" to "8", "nine" to "9")

        var answer: String = s

        for ((key, value) in map){
            answer = answer.replace(key, value)

        }
        return answer.toInt()
    }
}
