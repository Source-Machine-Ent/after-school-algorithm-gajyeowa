// 20220831

package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(scoville, K));
    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int length = scoville.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < length; i++) {
            pq.offer(scoville[i]);
        }

        while (!pq.isEmpty()) {
            int currNum = pq.poll();

            if (currNum < K && pq.isEmpty()) {
                return -1;
            }
            
            else if (currNum < K) {
                int tmpNum = pq.poll();
                int sum = currNum + tmpNum * 2;
                pq.offer(sum);
                answer++;
            }
        }
        return answer;
    }
}