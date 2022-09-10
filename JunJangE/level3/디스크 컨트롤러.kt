package level3

import java.util.PriorityQueue

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        val pq : PriorityQueue<IntArray> = PriorityQueue<IntArray>(compareBy { it[0] }) // 작업의 소요시간 기준으로 정렬
        var now : Int = 0
        var start : Int = -1
        var n : Int = 0

        while (n < jobs.size){
            // 반복문을 통해 현재 작업이 요청되었고 현재 시간 이전에 끝날 수 있는 작업을 큐에 담는다.
            for ((i, j) in jobs){
                if (i in (start + 1)..now){
                    pq.add(intArrayOf(j, i))
                }
            }

            if (pq.size > 0){
                val cur = pq.poll()
                start = now
                now += cur[0]
                answer += now - cur[1] // 작업 요청시간부터 종료시간까지 계산
                n++
            } else{
                now++
            }


        }

        return answer / jobs.size
    }
}

fun main(){

  println(Solution1().solution(arrayOf(intArrayOf(0,3), intArrayOf(1,9), intArrayOf(2,6))))
}
