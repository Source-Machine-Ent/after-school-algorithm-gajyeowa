// 20220819 :: 20분 컷인줄 알았는데... Queue의 자료형을 LinkedList이 아닌 PriorityQueue를 아무 생각 없이 쓴게 삽질 원인ㅜㅜ

package level3;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 11;
        int[][] edge = { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 }, { 3, 5 }, { 3, 6 }, { 4, 8 }, { 4, 9 }, { 5, 9 },
                { 5, 10 }, { 6, 10 }, { 6, 11 } };

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(n, edge));
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int maxDis = -1, answer = 0, edgeCnt = edge.length;
        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer>[] edges = new ArrayList[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            distance[i] = 50000;
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edgeCnt; i++) {
            edges[edge[i][0]].add(edge[i][1]);
            edges[edge[i][1]].add(edge[i][0]);
        }

        visited[1] = true;
        distance[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int currNum = q.poll();
            visited[currNum] = true;
            for (int i = 0; i < edges[currNum].size(); i++) {
                if (!visited[edges[currNum].get(i)]) {
                    distance[edges[currNum].get(i)] = Math.min(distance[edges[currNum].get(i)], distance[currNum] + 1);
                    maxDis = Math.max(maxDis, distance[edges[currNum].get(i)]);
                    q.add(edges[currNum].get(i));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDis) answer++;
        }

        return answer;
    }
}