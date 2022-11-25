package level2;

import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        int k = 6;
        int[] data = {1, 3, 2, 5, 4, 5, 2, 3};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(k, data));
    }
}

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> box = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            box.put(tangerine[i], box.getOrDefault(tangerine[i], 0) + 1);
        }

        ArrayList<Integer> sizes = new ArrayList<>(box.values());
        sizes.sort(((o1, o2) -> o2 - o1));

        int count = 0;
        for (int i = 0; i < sizes.size(); i++) {
            count += sizes.get(i);
            answer++;
            if(count >= k){
                return answer;
            }
        }

        return answer;
    }
}