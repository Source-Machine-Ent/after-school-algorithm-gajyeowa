package level2;

import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        String p = "(()())()";
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(p));
    }
}

class Solution {
    public String solution(String p) {
        String answer = findCorrect(p);
        return answer;
    }

    public static String findCorrect(String p){
        if(p.length() == 0){ return "";}

        String u = "";
        String v = "";
        int pivot = 0;

        for(int i=0; i<p.length(); i++){
            if (p.charAt(i) == '(') {
                pivot++;
            } else {
                pivot--;
            }
            u += p.charAt(i);
            if (pivot == 0){
                v = p.substring(i+1);
                break;
            }
        }

        if(isCorrect(u)){
            return u += findCorrect(v);
        }

        else{
            String tmp = "(";
            tmp += findCorrect(v);
            tmp += ")";
            u = u.substring(1, u.length()-1);

            for(int i=0; i<u.length(); i++){
                if (u.charAt(i) == '(') tmp += ')';
                else tmp += '(';
            }
            return tmp;
        }
    }

    public static boolean isCorrect(String str){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if (str.charAt(i) == '(') {
                st.push('(');
            }

            else {
                if (st.isEmpty() || st.peek() == ')') return false;
                else st.pop();
            }
        }

        return true;
    }
}