// 20120912 :: SFJ

package level3;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int jobs[][] = {{0, 3}, {1, 9}, {2, 6}};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(jobs));
    }
}


class Solution {
    public int solution(int[][] jobs) {
        int length = jobs.length;
		int answer = 0;
		int end = 0;
		int currJob = 0;
        int cnt = 0;

        // 2차원 배열 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);   // 2차원 배열 정렬 보기
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		// 모든 작업에 대해서
		while (cnt < length) {
			while (currJob < length && jobs[currJob][0] <= end) {
				pq.add(jobs[currJob++]);
			}

            if (pq.isEmpty()) {
                end = jobs[currJob][0];
            }

            else {
                int[] tmp = pq.poll();
                end += tmp[1];
				answer += tmp[1] + end - tmp[0];
				cnt++;
			}
		}

		return (int) answer / length;
	}
}

