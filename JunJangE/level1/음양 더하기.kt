class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0

        absolutes.forEachIndexed { index, i ->

            if (signs[index]){
                answer += i
            }else{
                answer -= i
            }
        }
        return answer
    }
}
