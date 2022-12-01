package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] n = {1, 2, 1, 3, 1, 4, 1, 2};

        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(n));
    }
}

class Solution {
    public int solution(int[] topping) {
        int length = topping.length;

        Set<Integer> first = new HashSet<>();
        Map<Integer, Integer> second = new HashMap<>();

        first.add(topping[0]);
        for (int i = 1; i < length; i++) {
            int number = topping[i];
            second.put(number, second.getOrDefault(number, 0) + 1);
        }

        int answer = 0;
        for (int i = 1; i < length; i++) {
            int number = topping[i];

            first.add(number);

            int numberSize = second.get(number);
            if (numberSize == 1) {
                second.remove(number);
            } else {
                second.put(number, numberSize - 1);
            }

            if (first.size() == second.size()) {
                answer++;
            }
        }

        return answer;
    }
}