package level1;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 5;
        int[] lost = { 2, 4 };
        int[] reserve = {1,3,5};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(n, lost, reserve));
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = 0;
                    reserve[j] = 0;
                    answer++;
                    break;
                }
            }
        }

        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    reserve[j] = 0;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}