// 20220725
package level1;

import java.util.*;

class Solution {
    static List<HashSet<Integer>> reports = new ArrayList<>();

    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Integer> ids = new HashMap<>();
        for (int i = 0; i < id_list.length; i++)
            ids.put(id_list[i], i);

        reports.clear();
        for (int i = 0; i < id_list.length; i++)
            reports.add(new HashSet<Integer>());

        StringTokenizer st;
        String userId, reportedId;
        for (String str : report) {
            st = new StringTokenizer(str);
            userId = st.nextToken();
            reportedId = st.nextToken();

            reports.get(ids.get(reportedId)).add(ids.get(userId));
        }

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            if (reports.get(i).size() >= k) {
                for (int r : reports.get(i))
                    answer[r]++;
            }
        }

        return answer;
    }

}