package extra.level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(queue1, queue2));
    }
}

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int length = queue1.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        for(int i = 0; i < length; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);

            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }

        int cnt = 0;
        while (sum1 != sum2) {
            if(cnt > length * 3) return -1;
            cnt++;

            int currNum = -1;
            if(sum1 > sum2) {
                currNum = q1.poll();
                q2.offer(currNum);

                sum1 -= currNum;
                sum2 += currNum;
                q2.offer(currNum);
            } else {
                currNum = q2.poll();
                q1.offer(currNum);

                sum1 += currNum;
                sum2 -= currNum;
            }
        }
        return cnt;
    }
}