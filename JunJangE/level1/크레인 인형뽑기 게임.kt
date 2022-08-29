import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val pickUp = Stack<Int>()
        for (move in moves){
            for (i in board.indices){
                if (board[i][move-1] != 0){

                    if (pickUp.isNotEmpty() && pickUp.peek() == board[i][move-1]){
                            pickUp.pop()
                            answer += 2


                    }else{
                        pickUp.push(board[i][move-1])

                    }

                    board[i][move-1] = 0

                    break

                }

            }
        }
        return answer
    }
}
