// 20220826 : 구현 몇 번을 도전해도 정답처리가 안되어서 블로그 참고..ㅜㅜ
package level3;

import java.util.*;

class Main {
    static int N, M;
    static int[] Group;

    public static void main(String[] args) throws Exception {
        String sentence = "HaEaLaLaObWORLDb";

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(sentence));
    }
}

class Solution {
    public String solution(String sentence) {
        String answer = "";
        LinkedHashMap<Character, ArrayList<Integer>> smallCharList = new LinkedHashMap<>();
        int stringIdx = 0;
        int startChar, endChar;
        int lastStartChar = -1, lastEndChar = -1;
        int startWord = 0, endWord = 0;
        int lastStartWord= -1, lastEndWord = -1;
        int cnt, dis;
        int rule = 0;

        try {
            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);

                if (c >= 'a' && c <= 'z') {
                    if (!smallCharList.containsKey(c)) {
                        smallCharList.put(c, new ArrayList<Integer>());
                    }
                    smallCharList.get(c).add(i);
                }
            }

            ArrayList<Integer> tmp;
            for(char c : smallCharList.keySet()){
                tmp = smallCharList.get(c);
                cnt = tmp.size();
                startChar = tmp.get(0);
                endChar = tmp.get(cnt-1);

                if(cnt == 1 || cnt >= 3){
                    for(int i=1; i<cnt; i++){
                        if(tmp.get(i) - tmp.get(i-1) != 2) return "invalid";
                    }
                    rule = 1;
                }

                else if (cnt == 2){
                    dis = endChar - startChar;
                    if(dis == 2 && (endChar < lastEndChar && startChar > lastStartChar)){
                        rule = 1;
                    }
                    else if(dis >= 2){
                        rule = 2;
                    }
                    else  return "invalid";
                }

                if(rule == 1){
                    startWord = startChar -1;
                    endWord = endChar+1;

                    if(lastStartWord < startWord && lastEndWord > endWord){
                        if(startChar - lastStartChar  == 2 && lastEndChar - endChar == 2){
                            continue;
                        }
                        else return "invalid";
                    }
                }

                else if (rule == 2){
                    startWord = startChar;
                    endWord = endChar;
                    if(lastStartWord < startWord && lastEndWord > endWord) return "invalid";
                }

                if(lastEndWord >= startWord) return  "invalid";

                if (stringIdx < startWord) {
                    answer += sentence.substring(stringIdx, startWord).replaceAll("[a-z]", "");
                    answer += " ";
                }

                answer += sentence.substring(startWord, endWord+1).replaceAll("[a-z]","");
                answer += " ";
                lastStartWord = startWord;
                lastEndWord = endWord;
                lastStartChar = startChar;
                lastEndChar = endChar;
                stringIdx = endWord+1;
            }

            if (stringIdx < sentence.length()) {
                answer += sentence.substring(stringIdx, sentence.length()).replaceAll("[a-z]","");
            }
        }
        catch (Exception e){
            return "invalid";
        }
        return answer;
    }
}