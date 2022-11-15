package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        String p = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(p)[0] + " " + sol.solution(p)[1] + " " + sol.solution(p)[2]);
    }
}


class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();

        s = s.substring(1, s.length() - 1);
        String[] setsStr = s.replace("},{", "},,{").split(",,");
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();

        for (int i = 0; i < setsStr.length; i++) {
            String str = setsStr[i];
            str = str.substring(1, str.length() - 1);
            String[] elements = str.split(",");

            sets.add(new ArrayList<>());
            for (int j = 0; j < elements.length; j++) {
                sets.get(i).add(Integer.parseInt(elements[j]));
            }
        }

        Collections.sort(sets, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return Integer.compare(o1.size(), o2.size());
            }
        });

        for (int i = 0; i < sets.size(); i++) {
            for (int j = 0; j < sets.get(i).size(); j++) {
                if (!answer.contains(sets.get(i).get(j)))
                    answer.add(sets.get(i).get(j));
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
