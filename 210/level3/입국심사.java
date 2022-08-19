package level3;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 6;
        int[] times = { 7, 10 };

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(n, times));
    }
}

// 어림 없는 풀이 ㅜ.ㅜ
// class Solution {
//     public long solution(int n, int[] times) {
//         long answer = 0;
//         int length = times.length;
//         List<Task> tasks = new ArrayList<>();

//         for (int i = 0; i < length; i++) {
//             tasks.add(new Task(times[i], 0));
//         }

//         for (int i = 0; i < 6; i++) {
//             Collections.sort(tasks, Comparator.comparing(Task::getNextTime));
//             tasks.set(0, new Task(tasks.get(0).time, tasks.get(0).currTime + tasks.get(0).time));
//         }

//         Collections.sort(tasks, Comparator.comparing(Task::getCurrTime).reversed());

//         return tasks.get(0).currTime;
//     }

//     class Task {
//         int time;
//         int currTime;

//         public Task(int time, int currTime) {
//             this.time = time;
//             this.currTime = currTime;
//         }

//         int getTime() {
//             return time;
//         }

//         int getCurrTime() {
//             return currTime;
//         }

//         int getNextTime() {
//             return currTime + time;
//         }
//     }
// }


// 이진탐색임을 알고 풀이
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int length = times.length;
        Arrays.sort(times);

        long left = 0;
        long right = (long) times[length - 1] * n;

        while (left <= right) {
            long sum = 0;
            long mid = (left + right) / 2;

            for (int i = 0; i < length; i++) {
                sum += mid / times[i];
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}