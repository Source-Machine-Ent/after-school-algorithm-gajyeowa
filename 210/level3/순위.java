// 20221007 플로이드-워셜 알고리즘 : 다시 풀어보기

package level3;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 5;
        int[][] nums = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(n, nums));
    }
}

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n][n];

        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]][results[i][1]] = 1;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if (graph[j][i] == 1 && graph[i][k] == 1)
                        graph[j][k] = 1;
                }
            }
        }
        
        int gameCnt = 0;
        for (int i = 1; i <= n; i++) {
            gameCnt = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1 || graph[j][i] == 1)
                    gameCnt++;
            }
            if (gameCnt == n - 1)
                answer++;
        }
        
        return answer;
    }
}