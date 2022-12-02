package level2;

import java.util.*;

class Main {
    static int N, M;
    static int[] Group;

    public static void main(String[] args) throws Exception {
        String s = "ababcdcdababcdcd";
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(s));
    }
}

class Solution {
    public long solution(String expression) {
        long answer = 0;
        LinkedList<String> list = new LinkedList<>();
        ArrayList<Long> resultList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }

        String[][] arr = {{"+", "-", "*"}, {"+", "*", "-"}, {"-", "+", "*"}, {"-", "*", "+"}, {"*", "+", "-"}, {"*", "-", "+"}};

        for (int j = 0; j < arr.length; j++) {
            LinkedList<String> listTemp = new LinkedList<>(list);
            for (int k = 0; k < arr[k].length; k++) {
                for (int i = 0; i < listTemp.size(); i++) {
                    if (listTemp.get(i).equals(arr[j][k])) {
                        String midString = getCurrentMiddle(listTemp.get(i - 1), listTemp.get(i), listTemp.get(i + 1));
                        listTemp.set(i - 1, midString);
                        listTemp.remove(i);
                        listTemp.remove(i);
                        i--;
                    }
                }
            }
            
            resultList.add(Math.abs(Long.parseLong(listTemp.get(0))));
        }
        
        answer = Collections.max(resultList);
        return answer;
    }

    static String getCurrentMiddle(String s1, String s2, String s3) {
        long temp = 0;
        if (s2.equals("+")) {
            temp += Long.parseLong(s1) + Long.parseLong(s3);
        } else if (s2.equals("-")) {
            temp += Long.parseLong(s1) - Long.parseLong(s3);
        } else {
            temp += Long.parseLong(s1) * Long.parseLong(s3);
        }
        return String.valueOf(temp);
    }
}