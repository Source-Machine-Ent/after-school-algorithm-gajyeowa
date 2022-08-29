// 20220824 : 운 좋게 패턴 보임

package level2;

class Main {
    public static void main(String[] args) throws Exception {
        int w = 8;
        int h = 12;
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(w, h));
    }
}

class Solution {
    public long solution(int w, int h) {
        long answer = 1;

        int maxDiv = 1;
        int i = 1;
        while(i <= w && i <= h) {
            if(w % i == 0 && h % i == 0) maxDiv = i;
            i++;
        }

        answer = (long) w * (long) h - (w + h);
        answer += maxDiv;

        return answer;
    }
}