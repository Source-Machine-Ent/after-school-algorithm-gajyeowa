//https://school.programmers.co.kr/learn/courses/30/lessons/81301

package level1;

public class 숫자문자열과영단어 {
    class Solution {
        public int solution(String s) {
            char[] arr = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++){
                if(Character.isDigit(arr[i])){
                    sb.append(arr[i]);
                } else{
                    for(int j = i; j < arr.length; j++){
                        String a = check(s.substring(i, j+1));
                        if(a != null){
                            sb.append(a);
                            i = j;
                        }
                    }
                }
            }
            int answer = Integer.parseInt(String.valueOf(sb));
            return answer;
        }

        public String check(String s){
            switch (s){
                case "zero" : return "0";
                case "one": return "1";
                case "two": return "2";
                case "three": return "3";
                case "four": return "4";
                case "five": return "5";
                case "six": return "6";
                case "seven": return "7";
                case "eight": return "8";
                case "nine": return "9";
            }
            return null;
        }
    }
}


