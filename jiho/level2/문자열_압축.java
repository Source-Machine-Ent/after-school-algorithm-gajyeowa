//https://school.programmers.co.kr/learn/courses/30/lessons/60057

package level2;

class 문자열_압축 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for(int i = 1; i <= s.length() / 2 + 1; i++){
            // 비교 기준 문자열
            String subStr = s.substring(0,i);
            // 반복되는 수(초기값 : 1)
            int num = 1;
            // 압축 결과 문자열 저장
            StringBuilder sb = new StringBuilder();

            for(int j = i; j <= s.length(); j += i){
                // 비교될 문자열
                String compared = s.substring( j, Math.min(j+i, s.length()));

                if (subStr.equals(compared)){
                    num++;
                } else {
                    sb.append( (num == 1 ? "" : num) + subStr);
                    subStr = compared;
                    num = 1;
                }
            }

            // 나머지 문자열 붙이기
            sb.append(subStr);
            // 결과 문자열 길이(최소값)
            answer = Math.min(answer, sb.toString().length());
        }

        return answer;
    }
}
