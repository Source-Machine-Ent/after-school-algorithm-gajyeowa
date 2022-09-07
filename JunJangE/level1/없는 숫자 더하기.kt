class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = -1
        
        answer = 45 - numbers.sum()
        return answer
    }
}
