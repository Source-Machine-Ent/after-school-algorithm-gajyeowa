//https://school.programmers.co.kr/learn/courses/30/lessons/42888

package level1;

import java.util.*;

class 오픈채팅방 {
    public String[] solution(String[] record) {
        // 내용(뒷부분) 저장
        List<String> chat = new ArrayList<>();
        // 최신 닉네임(앞부분) 저장
        HashMap<String, String> nickNameMap = new HashMap<>();

        for(int i = 0; i<record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String cmd = st.nextToken();
            String id = st.nextToken();
            String nickName = "";

            if(cmd.equals("Enter") || cmd.equals("Change")){
                nickName = st.nextToken();
            }

            switch (cmd){
                case "Enter" :
                    nickNameMap.put(id, nickName);
                    chat.add(id + "님이 들어왔습니다.");
                    break;
                case "Leave" :
                    chat.add(id + "님이 나갔습니다.");
                    break;
                case "Change" :
                    nickNameMap.put(id, nickName);
                    break;
            }
        }

        String[] answer = new String[chat.size()];
        int i = 0;

        for(String str : chat){
            int index = str.indexOf("님");
            String id = str.substring(0,index);

            answer[i++] = str.replace(id, nickNameMap.get(id));
        }

        return answer;
    }
}

