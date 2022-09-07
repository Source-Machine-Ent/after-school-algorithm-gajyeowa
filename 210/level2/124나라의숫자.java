// 20220831

package level2;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 1;
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(n));
    }
}

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] nums ={"4","1","2"};
        while(n>0){
            answer=nums[n%3]+answer;
            if(n%3==0) n--;
            n/=3;
        }
        return answer;
    }
}
