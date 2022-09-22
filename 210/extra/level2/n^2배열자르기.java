// 20220922

package extra.level2;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 4;
        long left = 7;
        long right = 14;

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(n, left, right));
    }
}

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];
        int currIdx = 0;
        for(long i = left; i<=right;i++){
            answer[currIdx++] = Math.max((int)(i/n+1) , (int)(i%n+1));
        }
        return answer;
    }
}
