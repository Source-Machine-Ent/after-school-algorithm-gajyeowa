package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(orders, course));
    }
}

class Solution {
    HashMap<String, Integer> combis = new HashMap<>();

    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Best[] bests = new Best[course.length];

        for (int i = 0; i < course.length; i++) {
            bests[i] = new Best();
        }

        for (String str : orders) {
            boolean[] visited = new boolean[str.length()];
            dfs(str.toCharArray(), visited, 0);
        }

        Set<String> set = combis.keySet();
        for (String str : set) {
            for (int i = 0; i < course.length; i++) {
                if (course[i] == str.length()) {
                    if (combis.get(str) < 2)
                        break;
                    if (combis.get(str) > bests[i].count) {
                        bests[i].combis.clear();
                        bests[i].combis.add(str);
                        bests[i].count = combis.get(str);
                    } else if (combis.get(str) == bests[i].count) {
                        bests[i].combis.add(str);
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < course.length; i++) {
            for (String string : bests[i].combis) {
                answer.add(string);
            }
        }
        
        Collections.sort(answer);

        return answer;
    }

    public void dfs(char[] currOrders, boolean[] visited, int idx) {
        if (idx == currOrders.length) {
            String combi = "";
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    combi += currOrders[i];
                }
            }

            if (combi.length() < 2)
                return;

            if (combis.containsKey(combi)) {
                combis.replace(combi, combis.get(combi) + 1);

            } else {
                combis.put(combi, 1);
            }
            return;
        }

        visited[idx] = true;
        dfs(currOrders, visited, idx + 1);
        visited[idx] = false;
        dfs(currOrders, visited, idx + 1);
    }
    
    class Best {
        ArrayList<String> combis = new ArrayList<>();
        int count = 0;
    }
}