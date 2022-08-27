// 220827
package extra.level1;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 } };
        int[] moves = {1,5,3,5,1,2,1,4};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(board, moves));
    }
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board.length;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < len; i++) {
                if (board[i][move-1] != 0) {
                    int num = board[i][move-1];
                    if (stack.empty() || stack.peek() != num)
                        stack.add(num);
                    else {
                        answer += 2;
                        stack.pop();
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}