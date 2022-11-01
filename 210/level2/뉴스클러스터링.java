package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        String str1 = "FRANCE";
        String str2 = "french";
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(str1, str2));
    }
}

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> elements1 = new ArrayList<>();
        List<String> elements2 = new ArrayList<>();

        int unionCnt = 0;
        int interCnt = 0;

        for (int i = 0; i < str1.length() - 1; i++) {
            String currStr = str1.substring(i, i + 2);
            if (currStr.matches("[A-Z]*"))
                elements1.add(currStr);
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String currStr = str2.substring(i, i + 2);
            if (currStr.matches("[A-Z]*"))
                elements2.add(currStr);
        }

        Collections.sort(elements1);
        Collections.sort(elements2);

        for (String s : elements1) {
            if (elements2.remove(s))
                interCnt++;
            unionCnt++;
        }

        unionCnt += elements2.size();
        if (unionCnt == 0 && interCnt == 0) return 65536;
        else if (unionCnt == 0 || interCnt == 0) return 0;

        return (int) ((double) interCnt * 65536.0 / (double) unionCnt);
    }
}