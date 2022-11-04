// 20220829
package extra.level1;

class Main {
    public static void main(String[] args) throws Exception {
        int[][] size = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(size));
    }
}

class Solution {
    public int solution(int[][] sizes) {
        int small = 0;
        int big = 0;

        for (int[] size : sizes) {
            small = Math.max(small, Math.min(size[0], size[1]));
            big = Math.max(big, Math.max(size[0], size[1]));
        }

        return small * big;
    }
}