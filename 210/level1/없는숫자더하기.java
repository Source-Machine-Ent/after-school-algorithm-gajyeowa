// 20220905

package level1;

import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        int[] numbers = {1,2,3,4,6,7,8,0};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(numbers));
    }
}

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        int len = numbers.length;

        Arrays.sort(numbers);
        int j = 0;
        for (int i = 0; i < 10; i++) {
            if (j < len && i == numbers[j]) {
                System.out.println(i + " " + numbers[j] + " : " + len + " " + (i <= len) + (i == numbers[j]));
                answer -= numbers[j];
                j++;
            }
        }


        return answer;
    }
}