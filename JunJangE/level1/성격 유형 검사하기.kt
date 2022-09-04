package level1

class Solution {
    private val choiceMap = mutableMapOf<String, Int>("R" to 0, "T" to 0, "C" to 0, "F" to 0, "J" to 0, "M" to 0, "A" to 0, "N" to 0)

    // Pair를 통해 객체를 두개 생성
    private var pairList : MutableList<Pair<String, String>> = mutableListOf()

    // 점수 부여
    private fun getScore(choiceIdx: Int): Int {
        return when(choiceIdx) {
            1 -> 3
            2 -> 2
            3 -> 1
            5 -> 1
            6 -> 2
            7 -> 3
            else -> 0
        }
    }

    // pairList 초기 값 : 각 성격 유형
    private fun initPairList() {
        pairList.add(Pair("R", "T"))
        pairList.add(Pair("C", "F"))
        pairList.add(Pair("J", "M"))
        pairList.add(Pair("A", "N"))
    }

    // 점수 계산
    private fun calculateScore(survey: Array<String>, choices: IntArray) {
        choices.forEachIndexed{ i, v ->
            var selectedText = "" // 현재 성격 유형
            val selectedScore = getScore(v) // 현재 성격 유형 점수

            if(v < 5) {
                selectedText = survey[i].substring(0, 1)
            } else {
                selectedText = survey[i].substring(1, 2)
            }

            // 현재 성격 유형의 점수 계산
            choiceMap[selectedText] = choiceMap[selectedText]!! + selectedScore
        }
    }

    // 점수 비교
    private fun compairValues() {
        // 두 개의 유형을 비교 후 점수가 낮은 것을 삭제
        pairList.forEachIndexed { i, e ->
            if(choiceMap[e.first]!! >= choiceMap[e.second]!!) {
                choiceMap.remove(e.second)
            } else {
                choiceMap.remove(e.first)
            }
        }
    }

    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""

        initPairList()

        calculateScore(survey, choices)

        compairValues()

        choiceMap.entries.map{
            answer += it.key
        }

        return answer
    }
}

fun main(){
    println(Solution1().solution(arrayOf("AN", "CF", "MJ", "RT", "NA"), intArrayOf(5, 3, 2, 7, 5)))
}
