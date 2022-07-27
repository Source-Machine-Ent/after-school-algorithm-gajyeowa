// 20220727

package level2;

import java.io.*;
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
    public int solution(String s) {
        int answer = -1;

        int size = s.length();

        for (int i = 1; i < size; i++) {
            String result = "";
            String currTarget = s.substring(0, i);
            int currCnt = 1;

            int j = i;
            for (j = i; j + i < size+1; j += i) {
                if (currTarget.equals(s.substring(j, j + i))) {
                        currCnt++;
                    } else {
                        result = currCnt == 1 ? result + currTarget : result + currCnt + currTarget;
                        currCnt = 1;
                        currTarget = s.substring(j, j + i);
                    }
            }
            result = currCnt == 1 ? result + currTarget : result + currCnt + currTarget;
            if (j != size)
                result = result + s.substring(j, size);
            answer = answer == -1 ? result.length() : answer < result.length() ? answer : result.length();
        }

        return answer;
    }
}