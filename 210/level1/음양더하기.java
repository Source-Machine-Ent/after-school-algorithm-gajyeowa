// 20220912

package level1;

class Main {
    public static void main(String[] args) throws Exception {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(absolutes, signs));
    }
}

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int length = absolutes.length;

        for (int i = 0; i < length; i++) {
            answer = signs[i] ? answer + absolutes[i] : answer - absolutes[i];
        }

        return answer;
    }
}