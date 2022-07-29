package level3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Main {
    static int N, M;
    static int[] Group;

    public static void main(String[] args) throws Exception {
        String lines[] = {"2016-09-15 01:00:04.002 2.0s",
"2016-09-15 01:00:07.000 2s"};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(lines));
    }
}

class Solution {
    public int solution(String[] lines) throws Exception {
        int answer = 0;
        int lineCnt = lines.length;

        LocalDateTime startTimes[] = new LocalDateTime[lineCnt];
        LocalDateTime endTimes[] = new LocalDateTime[lineCnt];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        for (int i = 0; i < lineCnt; i++) {
            LocalDateTime end = LocalDateTime.parse(lines[i].substring(0, 23), formatter);
            Double lastTaskTime = Double.parseDouble(lines[i].substring(24, lines[i].length() - 1));
            LocalDateTime start = end.plusNanos((long) (lastTaskTime * 1000000000) + 1);

            endTimes[lineCnt - i - 1] = end;
            startTimes[lineCnt - i - 1] = start;
        }

        for (int i = 0; i < lineCnt; i++) {
            int cnt = 1;
            if (answer >= lineCnt - i)
                break;
            for (int j = i + 1; j < lineCnt; j++) {
                if (startTimes[j].isAfter(endTimes[j].plusSeconds(1)))
                    cnt++;
            }
            answer = answer > cnt ? answer : cnt;
        }
        return answer;
    }
}