// 20220920

package extra.level2;

class Main {
    public static void main(String[] args) throws Exception {
        int k = 80;
        int[][] dungeons = {{100,20},{50,40},{30,10}};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(k, dungeons));
    }
}

class Solution {
    int answer = 0;
    int length = -1;
    boolean[] visited;
    int[][] d;

    public int solution(int k, int[][] dungeons) {
        length = dungeons.length;
        visited = new boolean[length];
        d = dungeons;

        dfs(0, 80);

        return answer;
    }

    public void dfs(int depth, int currK) {
        if (answer < depth)
            answer = depth;

        for (int i = 0; i < length; i++) {
            if (!visited[i] && currK >= d[i][0]) {
                visited[i] = true;
                dfs(depth + 1, currK - d[i][1]);
                visited[i] = false;
            }
        }
    }
}
