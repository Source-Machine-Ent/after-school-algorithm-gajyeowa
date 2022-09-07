package level1;

public class 없는숫자더하기 {
    public static void main(String[] args) {
        Solution86051 solution = new Solution86051();
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        int result = solution.solution(numbers);
        System.out.println(result);
    }
}

class Solution86051 {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int number : numbers){
            answer -= number;
        }
        return answer;
    }
}
