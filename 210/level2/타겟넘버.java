// 20220921

package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(numbers, target));
    }
}

class Solution {
    int length;
    int[] ops;
    int[] numbers0;
    int answer = 0, target0 = 0;

    public int solution(int[] numbers, int target) {
        length = numbers.length;
        ops = new int[length];
        Arrays.fill(ops, 1);
        numbers0 = numbers;
        target0 = target;

        dfs(-1);

        return answer;
    }

    public void dfs(int idx) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += numbers0[i] * ops[i];
        }
        if (sum == target0) {
            answer++;
        }

        for (int i = idx+1; i < length; i++) {
            if (ops[i] == 1) {
                ops[i] = -1;
                dfs(i);
                ops[i] = 1;
            }
        }
    }
}