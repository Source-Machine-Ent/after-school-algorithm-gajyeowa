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
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        HashSet<Integer> setA = getAllNums(arrayA);
        HashSet<Integer> setB = getAllNums(arrayB);
        
        // 겹치는 부분을 빼기
        int dup = 0;
        for (Integer i : setA) {
            if (setB.contains(i)) dup++;
        }
        System.out.println(setA.size() + " " + setB.size() + " " + (2 * dup));
        
        return setA.size() + setB.size() - (2 * dup);
    }
    
    private HashSet<Integer> getAllNums(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 2; j < arr[i]; j++) {
                if (arr[i] % j == 0) {
                    set.add(j);
                }
            }
        }
        
        return set;
    }
}
