package level1;

import java.util.*;

class Solution_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        LinkedHashMap<String, ArrayList<String>> log = new LinkedHashMap<String, ArrayList<String>>();
        Map<String, Integer> cnt = new HashMap<String, Integer>();

        System.out.println(Arrays.toString(id_list));

        for (String s : id_list) {
            log.put(s, new ArrayList<>());
            cnt.put(s, 0);
        }

        String[] setReport = Arrays
                .stream(report)
                .distinct()
                .toArray(String[]::new);


        for (String s : setReport) {
            String[] reportArr = s.split(" ");

            log.get(reportArr[0]).add(reportArr[1]);
            cnt.put(reportArr[1], cnt.get(reportArr[1]) + 1);
        }

        int idx = 0;

        for(String user : log.keySet()){
            for(String c : cnt.keySet()){
                if(cnt.get(c) >= k && log.get(user).contains(c))
                    answer[idx] ++;
            }
            idx ++;
        }

        return answer;
    }
}