// 20220810

package level2;

class Main {
    public static void main(String[] args) throws Exception {
        int m = 6;
        int n = 4;
        int s[][] = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 }, { 0, 0, 0, 3 } };
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(m,n,s)[0] + " " + sol.solution(m,n,s)[1]);
    }
}

class Solution {
    int[][] picture;
    boolean[][] visited;
    int m, n, currArea = 0;
    int[][] dxy = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };


    public int[] solution(int m0, int n0, int[][] picture0) {
        int[] answer = { 0, -1 };
        m = m0;
        n = n0;
        picture = picture0.clone();
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    answer[0]++;
                    dfs(i, j);
                }
                answer[1] = answer[1] > currArea ? answer[1] : currArea;
                currArea = 0;
            }
        }
        return answer;
    }

    void dfs(int i, int j) {
        if (visited[i][j])
            return;

        else {
            visited[i][j] = true;
            currArea++;
        }

        for (int k = 0; k < 4; k++) {
            int i0 = i + dxy[k][0];
            int j0 = j + dxy[k][1];

            if (i0 < 0 || i0 >= m || j0 < 0 || j0 >= n)
                continue;

            if (!visited[i0][j0] && picture[i][j] == picture[i0][j0]) {
                dfs(i0, j0);
            }
        }
    }
}