// 20220815
package level1;

class Main {
    public static void main(String[] args) throws Exception {
        String s = "one4seveneight";

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(s));
    }
}


class Solution {
    public int solution(String s) {
        String arr[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0;i<10;i++){
            s=s.replace(arr[i],Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
