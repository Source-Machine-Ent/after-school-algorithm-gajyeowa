package com.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;



public class Solution_오픈채팅방 {
    public static void main(String[] args) {
        String[] input = {"Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};
        Solution_오픈채팅방 s = new Solution_오픈채팅방();

        System.out.println(Arrays.toString(s.solution(input)));
    }

        public String[] solution(String[] record) {
            HashMap<String, String> users = new HashMap<>();
            ArrayList<String> answer = new ArrayList<>();

            for(String s: record){
                String[] words = s.split(" ");
                if(!words[0].equals("Leave"))
                    users.put(words[1], words[2]);
            }

            for(String s: record){
                String[] words = s.split(" ");
                String user = words[1];
                String nickname = users.get(user);
                if(words[0].equals("Enter")){
                    String text = nickname + "님이 들어왔습니다.";
                    answer.add(text);
                }
                else if (words[0].equals("Leave")){
                    String text = nickname + "님이 나갔습니다.";
                    answer.add(text);
                }
                else
                    continue;
            }

            return answer.toArray(new String[0]);
        }

}
