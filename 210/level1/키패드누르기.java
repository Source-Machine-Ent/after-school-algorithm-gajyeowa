// 20220822
package level1;

class Main {
    public static void main(String[] args) throws Exception {
        int numbers[] = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(numbers, hand));
    }
}


class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int currLeftNum = 10;
        int currRightNum = 12;
        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer += "L";
                currLeftNum = i;
            }

            else if (i == 3 || i == 6 || i == 9) {
                answer += "R";
                currRightNum = i;
            }

            else {
                int currInput = i == 0 ? 11 : i;

                int leftDis = currLeftNum % 3 == 1 ? Math.abs((currInput / 3) - (currLeftNum / 3)) + 1 : Math.abs((currInput / 3) - (currLeftNum / 3));
                int rightDis = currRightNum % 3 == 0 ? Math.abs(((currInput-1) / 3) - ((currRightNum - 1) / 3)) + 1 : Math.abs(((currInput-1) / 3) - ((currRightNum - 1) / 3));

                if (leftDis == rightDis) {
                    answer = hand.equals("left") ? answer + "L" : answer + "R";
                    currLeftNum = hand.equals("left") ? currInput : currLeftNum;
                    currRightNum = hand.equals("left") ? currRightNum : currInput;
                }

                else {
                    answer = leftDis < rightDis ? answer + "L" : answer + "R";
                    currLeftNum = leftDis < rightDis ? currInput : currLeftNum;
                    currRightNum = leftDis < rightDis ? currRightNum : currInput;
                }
            }
        }
        return answer;
    }
}