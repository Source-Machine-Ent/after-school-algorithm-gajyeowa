// 20220809
package extra.level2;

class Main {
    static int N, M;
    static int[] Group;

    public static void main(String[] args) throws Exception {
        int n = 5;
        int info[] = {2,1,1,1,0,0,0,0,0,0,0};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(n, info)[0] + sol.solution(n, info)[1] + sol.solution(n, info)[2]);
    }
}

class Solution {
    int maxGap = -1;
    int n = -1;
    int aInfo[] = new int[11];
    int rInfo[] = new int[11];

    public int[] solution(int n1, int[] info) {
        n = n1;
        aInfo = info.clone();

        int tmp[] = {0,0,0,0,0,0,0,0,0,0,0};
        int tmp2[] = {-1};
        dfs(0, 0, tmp);

        return maxGap == -1 ? tmp2 : rInfo;
    }

    public void dfs(int degree, int point, int[] currInfo) {
        if (degree != 0) currInfo[point]++;
        if (degree == n) {
            int aScore = 0;
            int rScore = 0;

            // 비교
            for (int i = 0; i < 11; i++) {
                if (currInfo[i] == 0 && aInfo[i] == 0)
                    continue;
                else if (currInfo[i] > aInfo[i]) {
                    rScore += (10 - i);
                }
                else {
                    aScore += (10 - i);
                }
            }

            // 최대값 갱신하기
            int currGap = rScore - aScore;
            if ( currGap > 0 &&currGap > maxGap) {
                maxGap = currGap;
                rInfo = currInfo.clone();
            } else if (currGap > 0 && currGap == maxGap) {
                for (int i = 10; i >= 0; i--) {
                    if (currInfo[i] > rInfo[i]) {
                        maxGap = currGap;
                        rInfo = currInfo.clone();
                    } else if (rInfo[i] > currInfo[i]) {
                        return;
                    }
                }
            }

            return;
        } else {
            for (int i = point; i < 11; i++) {

                dfs(degree + 1, i, currInfo.clone());
            }
        }
    }
}