package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 2;
        int k = 4;
        int[] enemy = {3, 3, 3, 3};
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(n, k, enemy));
    }
}

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int my = n;
        int card = k;
        for (int i = 0; i < enemy.length; i++) {
            my -= enemy[i];
            pq.add(enemy[i]);

            if (my < 0) {
                if (card > 0 && !pq.isEmpty()) {
                    my += pq.poll();
                    card--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}
