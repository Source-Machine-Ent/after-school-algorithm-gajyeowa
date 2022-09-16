// 20220916

package level3;

class Main {
    static int N, M;
    static int[] Group;

    public static void main(String[] args) throws Exception {
        int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(triangle));
    }
}

class Solution {
    public int solution(int[][] triangle) {
        int h = triangle.length;
        int w = triangle[h - 1].length;

        int[][] dp = new int[h][w];

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < h; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                int left = j - 1 >= 0 ? dp[i - 1][j - 1] : -1;
                int right = j < triangle[i].length ? dp[i - 1][j] : -1;

                dp[i][j] = Math.max(left, right) + triangle[i][j];
            }
        }
        int max = -1;
        for (int i = 0; i < w; i++) {
            max = Math.max(dp[h - 1][i], max);
        }

        return max;
    }
}