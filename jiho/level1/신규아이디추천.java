//https://school.programmers.co.kr/learn/courses/30/lessons/72410
//신규 아이디 추천

package level1;

public class 신규아이디추천 {
    public static void main(String[] args) {
//        String s = "...!@BaT#*..y.abcdefghijklm";
        String s = "z-+.^.";
        String result = solution(s);
        System.out.println(result);
    }

    public static String solution(String new_id) {
        //1단계
        String s = new_id.toLowerCase();

        //2단계
        String sl = "~!@#$%^&*()=+[{]}:?,<>/";
        for(char c : sl.toCharArray()){
            s = s.replace(Character.toString(c),"");
        }

        //3단계
        String s2 = "", before = "";
        for(int i = 0; i<s.length(); i++){
            String now = Character.toString(s.charAt(i));
            if(now.equals(".")){
                s2 += before.equals(".") ? "" : now;
            } else{
                s2 += now;
            }
            before = now;
        }
        s = s2;

        //4단계
        String[] arr = s.split("");

        arr[0] = arr[0].equals(".") ? "" : arr[0];
        arr[arr.length-1] = arr[arr.length-1].equals(".") ? "" : arr[arr.length-1];

        s = String.join("",arr);

        //5단계
        if(s.equals("") || s == null){
            s = "a";
        }

        //6단계
        if(s.length() > 15){
            s = s.substring(0,15);
        }
        arr = s.split("");
        arr[arr.length-1] = arr[arr.length-1].equals(".") ? "" : arr[arr.length-1];
        s = String.join("", arr);

        //7단계
        if(s.length() < 3){
            while(s.length() < 3){
                s += s.charAt(s.length()-1);
            }
        }

        return s;
    }
}
