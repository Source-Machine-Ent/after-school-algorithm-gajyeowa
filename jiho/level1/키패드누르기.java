package level1;

public class 키패드누르기 {
    public static void main(String[] args) {
        Solution67256 solution = new Solution67256();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = solution.solution(numbers, hand);
        System.out.println(result);
    }
}

class Solution67256 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int lh = 10, rh = 12;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            switch (numbers[i]){
                case 1: case 4: case 7:
                    sb.append("L");
                    lh = numbers[i];
                    break;
                case 3: case 6: case 9:
                    sb.append("R");
                    rh = numbers[i];
                    break;
                default:
                    int number = numbers[i] == 0 ? 11 : numbers[i];
                    String use = getHand(number, lh, rh, hand);
                    if(use.equals("L")){
                        lh = number;
                    } else if (use.equals("R")) {
                        rh = number;
                    }
                    sb.append(use);
                    break;
            }
        }
        answer = sb.toString();
        return answer;
    }

    private String getHand(int number, int lh, int rh, String hand) {
        int left = Math.abs((number - lh) / 3 + (number - lh) % 3);
        int right = Math.abs((number - rh) / 3 + (number - rh) % 3);
        String use = "";
        if(left == right){
            use = hand.equals("left") ? "L" : "R";
        } else if (left > right) {
            use = "R";
        } else if (left < right){
            use = "L";
        }
        return use;
    }
}
