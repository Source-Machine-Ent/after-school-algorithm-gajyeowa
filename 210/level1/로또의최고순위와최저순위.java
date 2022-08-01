// 20220801

package level1;

import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(lottos, win_nums)[0] + " " + sol.solution(lottos, win_nums)[1]);
    }
}


class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                answer[0]--;
            } else {
                int a = lottos[i];
                if (Arrays.stream(win_nums).anyMatch(j -> j == a)) {
                    answer[0]--;
                    answer[1]--;
                }
            }
        }
        answer[0] = answer[0] == 7 ? 6 : answer[0];
        answer[1] = answer[1] == 7 ? 6 : answer[1];

        return answer;
    }
}