package level3

import java.util.*

fun main() {
    println(Solution().solution(6, arrayOf(intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(3, 2), intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(5, 2))))
}


class Solution {

    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer : Int = 0
        val graph : Array<ArrayList<Int>> = Array(n + 1) { ArrayList<Int>() }
        val visited : IntArray = IntArray(n+1){0}
        val queue : Queue<Int> = LinkedList<Int>()

        edge.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])

        }

        queue.add(1)
        visited[1] = 1


        while (queue.isNotEmpty()){
            val x = queue.poll()

            for (i in graph[x]){
                if (visited[i] == 0){
                    visited[i] = visited[x] + 1
                    queue.add(i)
                }
            }

        }

        //가장 먼 노드의 depth
        visited.sortDescending()

        val depthMax = visited[0]
        answer = visited.count { it == depthMax }
        return answer
    }
}
