package level3;

class Main {
    public static void main(String[] args) throws Exception {
        int N = 5;
        int number = 2;

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(N, number));
    }
}

class Solution {
    int answer = 9;
    int N = -1;
    int number = -1;

    public int solution(int N1, int number1) {
        N = N1;
        number = number1;

        cal(0, 0);
        return answer<9?answer:-1;
    }

    public void cal(int cnt, int currNum){
        if(currNum == number){
            answer = cnt;
            return;

        }
        else if(cnt >= answer) return;
         else {
            int op = N;
            for(int i = 0; i<8-cnt; i++ ) {
                cal(cnt+1+i, currNum+op);
                cal(cnt+1+i, currNum-op);
                cal(cnt+1+i, currNum*op);
                cal(cnt+1+i, currNum/op);

                op = (op*10)+N;
            }
        }
    }
}