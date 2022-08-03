// 20220803

package level2;

import java.util.*;

class Main {
    static int N, M;
    static int[] Group;

    public static void main(String[] args) throws Exception {
        String s[] = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan", "Change uid4567 Ryatttt" };
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(s).length);
    }
}

class Solution {
    public String[] solution(String[] record) {
        List<Log> log = new ArrayList<>();

        HashMap<String,String> users = new HashMap<>();

        for (String records : record) {
            String[] currRecord = records.split(" ");

            if (currRecord[0].equals("Enter")) {
                log.add(new Log(currRecord[0], currRecord[1]));
                users.put(currRecord[1], currRecord[2]);
            } else if (currRecord[0].equals("Change")) {
                users.replace(currRecord[1], currRecord[2]);
            } else {
                log.add(new Log(currRecord[0], currRecord[1]));
            }
        }

        String[] answer = new String[log.size()];
        for (int i = 0; i < log.size(); i++) {
            if (log.get(i).state.equals("Enter")) {
                answer[i] = users.get(log.get(i).uid) + "님이 들어왔습니다.";
            } else {
                answer[i] = users.get(log.get(i).uid) + "님이 나갔습니다.";
            }
        }

        return answer;
    }

    class Log{
        String state;
        String uid;

        public Log(String state, String uid) {
            this.state = state;
            this.uid = uid;
        }
    }
}