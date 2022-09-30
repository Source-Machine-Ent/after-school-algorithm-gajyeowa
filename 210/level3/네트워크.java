// 20220926

package level3;

class Main {
    public static void main(String[] args) throws Exception {
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        int n = 3;

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(n, computers));
    }
}

class Solution {
    boolean[] isConnected;
    int length;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        length = computers.length;
        isConnected = new boolean[length];

        for (int i = 0; i < length; i++) {
            if (!isConnected[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int i, int[][] computers) {
        isConnected[i] = true;

        for (int j = 0; j < length; j++) {
            if (computers[i][j] == 1 && !isConnected[j]) {
                dfs(j, computers);
            }
        }
    }
}
