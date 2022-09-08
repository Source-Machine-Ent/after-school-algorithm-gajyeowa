class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val progressesCopy = progresses.toMutableList()
        val speedsCopy = speeds.toMutableList()
        while (progressesCopy.size != 0){
            speedsCopy.forEachIndexed { idx, e ->
                progressesCopy[idx] += e
            }

            var cnt = 0
            while (progressesCopy[0] >= 100){
                progressesCopy.removeAt(0)
                speedsCopy.removeAt(0)
                cnt++

                if (progressesCopy.size == 0){
                    break
                }

            }
            if (cnt > 0){
                answer.add(cnt)
            }

        }
        return answer.toIntArray()
    }
}
