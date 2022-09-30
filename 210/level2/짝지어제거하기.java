// 20220930

package level2;

import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        String s = "cdcd";
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(s));
    }
}

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}