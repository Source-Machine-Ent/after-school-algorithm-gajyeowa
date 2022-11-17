package level2;

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String, List<Integer>> infos = new HashMap<>();
        
        for(int j = 0;j<info.length;j++) {
            String str = info[j];
            String[] strs = str.split(" ");
            String currInfo = "";
            for(int i = 0;i<4;i++) {
                currInfo += strs[i].substring(0,1);
            }
            
            if (!infos.containsKey(currInfo)) {
                infos.put(currInfo, new ArrayList<>(Arrays.asList(Integer.parseInt(strs[4]))));
            } else {
                infos.get(currInfo).add(Integer.parseInt(strs[4]));
            }
        }
        
        for (int i = 0;i<query.length;i++) {
            String currQuery = query[i];
            currQuery = currQuery.replace(" and ", " ");
            String[] strs = currQuery.split(" ");
            String regax = "";
            Integer score = Integer.parseInt(strs[4]);
            for(int j = 0; j<4;j++) {
                if (strs[j].equals("-")) regax += "[a-z]";
                else regax += strs[j].substring(0,1);
            }
            
            Set<String> keys = infos.keySet();
            Integer count = 0;
            for(String s : keys) {
                if(s.matches(regax)) {
                    count += (int) infos.get(s).stream().filter(w->w >= score).count();
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}
