package level1;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] nums = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, {1,7,3} };

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(nums, commands));
    }
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            arrayList.add(i);
        }

        for (int i = 0; i < length; i++) {
            List<Integer> currArr = (List<Integer>) arrayList.clone();

            currArr = currArr.subList(commands[i][0]-1, commands[i][1]);
            Collections.sort(currArr);
            answer[i] = currArr.get(commands[i][2] - 1);
        }

        return answer;
    }
}
