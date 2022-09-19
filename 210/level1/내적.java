// 20220919

package level1;

class Main {
    public static void main(String[] args) throws Exception {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(a, b));
    }
}

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int length = a.length;

        for (int i = 0; i < length; i++) {
            answer += a[i]*b[i];
        }

        return answer;
    }
}