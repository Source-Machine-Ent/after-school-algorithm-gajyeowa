package level2;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        
        for (Integer i : priorities) {
            pq.add(i);
        }
        
        while(!pq.isEmpty()) {
            for (int i = 0; i < priorities.length ; i++) {
                if (priorities[i] == pq.peek()) {
                    answer++;
                    pq.poll();
                    if (i == location) return answer;
                }
            }
        }
        
        
        return answer;
    }
}
