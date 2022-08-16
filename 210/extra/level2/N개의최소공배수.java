// 20220816 :: gcd 재귀로 푸는 방법 알겠는데 왜 이 풀이가 안되는지 모르겠음..ㅜ.ㅜ

package extra.level2;

class Main {
    static int N, M;
    static int[] Group;

    public static void main(String[] args) throws Exception {
        int arr[] = { 2, 6, 4, 8, 1 };

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(arr));
    }
}

class Solution {
    public int solution(int[] arr) {
        int answer = 1;

        int maxDiv = 1;
        int i = 1;
        boolean isEnd = false, isDivPossible = false;
        while (!isEnd) {

            isDivPossible = true;
            for (int j = 0; j < arr.length; j++) {
                // System.out.println("====" + i + " " + arr[j]);
                if (i == arr[j]) {
                    isEnd = true;
                }

                if (arr[j] % i != 0) {
                    isDivPossible = false;
                    break;
                }
            }

            if (isDivPossible) {
                maxDiv = i;
                // System.out.println("div :" + maxDiv);
            }
            i++;
        }

        for (int j = 0; j < arr.length; j++) {
            answer *= (arr[j] / maxDiv);
        }
        // System.out.println("ans : " + answer + " " + maxDiv );
        answer *= maxDiv;


        return answer;
    }
}