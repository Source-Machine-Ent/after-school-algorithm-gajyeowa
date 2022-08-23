// 20220823 :: 단순 contains를 사용하면 효율성 채점에서 빵점을 받으니 더 효율적인 탐색을 고민하는데 오래걸렸다ㅜㅜ
package extra.level1;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        String[] participant = { "leo", "kiki", "eden" };
        String[] completion = {"eden", "kiki"};
        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(participant, completion));
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int len = completion.length;
        for(int i=0;i<len;i++)
            if(!participant[i].equals(completion[i]))
                return participant[i];

        return "";
    }
}