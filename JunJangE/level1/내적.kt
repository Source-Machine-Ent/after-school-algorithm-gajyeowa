class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        var answer: Int = 0
        
        answer = a.zip(b){
            i, j -> i * j
        }.sum()
        
        return answer
    }
}
