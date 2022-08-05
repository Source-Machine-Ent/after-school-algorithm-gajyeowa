//https://school.programmers.co.kr/learn/courses/30/lessons/42895

package level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {
    public void addToSet(Set<Integer> set, Set<Integer> a, Set<Integer> b) {
        for(int A : a){
            for(int B : b){
                set.add(A + B);
                set.add(A - B);
                set.add(A * B);
                if(B != 0){
                    set.add(A / B);
                }
            }
        }
    }

    public int solution(int N, int number) {
        // N과 number가 같으면 1 반환
        if(N == number){
            return 1;
        }

        List<Set<Integer>> list = new ArrayList<>();

        // 첫번째 Set은 N을 1개 사용하는 경우의 Set
        // ~~~ 여덟번째 Set은 N을 8개 사용하는 경우의 Set
        for(int i = 0; i < 9; i++){
            list.add(new HashSet<Integer>());
        }

        //N을 1개 이용하여 만들 수 있는 숫자는 N 밖에 없다.
        list.get(1).add(N);

        //N을 i개 이용하여 산술연산(+,-,*,/)한 값을 저장
        for(int i = 2; i < 9; i++){
            for(int j = 1; j < i; j++){
                addToSet(list.get(i), list.get(i-j), list.get(j));
            }

            // N을 i개 연속해서 적은 숫자 저장(예:N=5, i=3 일 때에 repeated = 555)
            String s = Integer.toString(N);
            int repeated = Integer.parseInt(s.repeat(i));
            list.get(i).add(repeated);

            // N을 i개 이용하여 만든 숫자 중 number와 같은 수가 있는지 확인, 만약 있다면 반환
            for(int num : list.get(i)){
                if(num == number){
                    return i;
                }
            }
        }

        // 8개를 이용하여 구한 값 중에서도 찾지 못했다면 -1 반환
        return -1;
    }
}
