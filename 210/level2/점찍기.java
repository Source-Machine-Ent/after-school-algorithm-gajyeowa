package level2;

class Main {
    public static void main(String[] args) throws Exception {
        int k = 2;
        int d = 4;
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(k, d));
    }
}

class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        // for (long i = 0; i <= d; i += k) {
        //     for (long j = 0; j <= d; j += k) {
        //         if (Math.sqrt(i * i + j * j) <= d) {
        //             answer++;
        //         } else {
        //             break;
        //         }
        //     }
        // }

        // 시간 복잡도 줄이기
        for (long i = d; i >= 0; i -= k) {
            for (long j = d; j >= 0; j -= k) {
                if (Math.sqrt(i * i + j * j) <= d) {
                    if (i == j)
                        answer++;
                    else
                        answer += 2;
                }

                if (j <= i) {
                    break;
                }
            }
        }

        return answer;
    }
}