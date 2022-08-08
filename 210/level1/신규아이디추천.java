// 20220808

package level1;

class Main {
    public static void main(String[] args) throws Exception {
        String new_id = "...!@BaT#*..y.abcdefghijklm";

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(new_id));
    }
}


class Solution {
    public String solution(String new_id) {
        String answer = new_id;

        answer = answer.toLowerCase();

        answer = answer.replaceAll("[^a-z0-9-_.]", "");

        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        answer = answer.length() < 1? answer : answer.substring(0, 1).equals(".") ? answer.substring(1) : answer;
        answer = answer.length() < 1? answer : answer.substring(answer.length()-1, answer.length()).equals(".") ? answer.substring(0, answer.length()-1) : answer;

        answer = answer.equals("") ? "a" : answer;

        answer = answer.length() >= 16 ? answer.substring(0, 15) : answer;
        answer = answer.length() != 15 ? answer
                : answer.substring(14, 15).equals(".") ? answer.substring(0, 14) : answer;

        answer = answer.length() == 1? answer + answer + answer : answer.length() == 2? answer + answer.substring(1, 2) : answer;

        return answer;
    }
}