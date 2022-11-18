package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        String[][] r = {{"a", "1", "4"},  {"2", "1", "5"}, {"a", "2", "4"}};
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(r));
    }
}

class Solution {
    public int solution(String[][] relation) {
        int rowCnt = relation.length;
        int colCnt = relation[0].length;

        // 모든 부분 집합
        boolean[] visited = new boolean[colCnt];
        List<String> subset = new ArrayList<>();
        dfs(visited, subset, 0);
        Collections.sort(subset, (String s1, String s2) -> s1.length() - s2.length());

        // 해시 세트에 현재 부분집합이 포함된 게 없으면 조회 시작
        HashSet<String> set = new HashSet<>();
        for(String currSet:subset) {
            boolean hasSubset = false;
            for (String str : set) {
                String tmp = currSet.replaceAll("[" + str + "]", "");
                if (currSet.length() - tmp.length() == str.length()) {
                    hasSubset = true;
                }
            }

            if(hasSubset) continue;

            // 해당 부분 집합으로 중복되는 게 없으면 세트에 넣기
            List<String> rows = new ArrayList<>();
            for (String[] row: relation) {
                String element = "";
                for (char c:currSet.toCharArray()) {
                    int index = c - '0';
                    element += String.valueOf(row[index]);
                }
                if (!rows.contains(element)) rows.add(element);
            }
            if(rows.size() == rowCnt) {
                set.add(currSet);
            }
        }

        return set.size();
    }

    void dfs(boolean[] visited, List<String> subset, int idx) {
        if (idx == visited.length) {
            String subsetStr = "";
            for(int i = 0;i<visited.length;i++) {
                if (visited[i]) subsetStr += String.valueOf(i);
            }
            if (!subsetStr.equals(""))subset.add(subsetStr);
            return;
        }
        visited[idx] = true;
        dfs(visited, subset, idx+1);
        visited[idx] = false;
        dfs(visited, subset, idx+1);
    }
}