// 20220907

package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = {1, 1, 1, 1, 1, 1};
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(progresses, speeds)[0]);
    }
}

class Solution {
    public Integer[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;

        int[] leftDays = new int[length];
        for (int i = 0; i < length; i++) {
            leftDays[i] = (int) Math.ceil((double) (100 - progresses[i]) / (double) speeds[i]);
        }

        ArrayList<Integer> releases = new ArrayList<>();
        int frontLeftDay = leftDays[0];
        int cnt = 1;
        for (int i = 1; i < length; i++){
            if (frontLeftDay < leftDays[i]){
                releases.add(cnt);
                cnt = 1;
                frontLeftDay = leftDays[i];
            } else{
                cnt++;
            }
        }
        releases.add(cnt);
        
        Integer[] answer = releases.toArray(new Integer[releases.size()]);
        return answer;
    }
}