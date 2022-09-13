// 20220913
package extra.level2;

import java.time.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] Group;

    public static void main(String[] args) throws Exception {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        Solution sol = new Solution();
        System.out
                .println("result : " + sol.solution(fees, records)[0] + " " + sol.solution(fees, records)[1] );
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, LocalTime> carIns = new HashMap<String, LocalTime>();
        HashMap<String, Integer> carTimes = new HashMap<String, Integer>();

        for (String s : records) {
            String[] strs = s.split(" ");

            // 이미 들어온 차라면
            if (strs[2].equals("OUT")) {
                String[] timeStrs = strs[0].split(":");

                Duration duration = Duration.between(carIns.get(strs[1]), LocalTime.of(Integer.parseInt(timeStrs[0]), Integer.parseInt(timeStrs[1]), 00));
                int minutes = (int) duration.getSeconds() / 60;

                if (carTimes.containsKey(strs[1])) {
                    carTimes.replace(strs[1], carTimes.get(strs[1]) + minutes);
                } else {
                    carTimes.put(strs[1], minutes);
                }
                carIns.remove(strs[1]);
            }

            else {
                String[] timeStrs = strs[0].split(":");
                carIns.put(strs[1], LocalTime.of(Integer.parseInt(timeStrs[0]), Integer.parseInt(timeStrs[1]), 00));
            }
        }

        for (String key : carIns.keySet()) {
            Duration duration = Duration.between(carIns.get(key), LocalTime.of(23, 59, 00));
            int minutes = (int) duration.getSeconds() / 60;

            if (carTimes.containsKey(key)) {
                carTimes.replace(key, carTimes.get(key) + minutes);
            } else {
                carTimes.put(key, minutes);
            }
        }

        Object[] mapkey = carTimes.keySet().toArray();
		Arrays.sort(mapkey);

        int[] answer = new int[mapkey.length];
        int i = 0;
        for (Object key : mapkey) {
            int minutes = carTimes.get(key);
            int currFee = fees[1];

            if (minutes > fees[0]) {
                currFee += Math.ceil((double) (minutes - fees[0]) / (double) fees[2]) * fees[3];
            }

            answer[i] = currFee;
            i++;
        }

        return answer;
    }
}