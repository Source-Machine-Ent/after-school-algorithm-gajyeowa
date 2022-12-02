package level2;

import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        String s = ")()(";
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(s));
    }
}

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.add('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}