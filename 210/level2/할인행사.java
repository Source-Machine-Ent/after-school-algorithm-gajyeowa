package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        String[] want = { "banana", "apple", "rice", "pork", "pot" };
        int[] number = { 3, 2, 2, 2, 1 };
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(want, number, discount));
    }
}

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wants = new HashMap<>();
        HashMap<String, Integer> discounts = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            discounts.put(discount[i], discounts.getOrDefault(discount[i], 0) + 1);
        }

        if (isSame(wants, discounts)) answer++;

        for (int i = 10; i < discount.length; i++) {
            discounts.put(discount[i], discounts.getOrDefault(discount[i], 0) + 1);
            discounts.put(discount[i-10], discounts.get(discount[i-10]) - 1);

            if (isSame(wants, discounts)) answer++;
        }

        return answer;
    }

    private boolean isSame(HashMap<String, Integer> first, HashMap<String, Integer> second) {
        for (String key : first.keySet()) {
            if ( !second.containsKey(key) || second.get(key) != first.get(key) ) {
                return false;
            }
        }
        return true;
    }
}