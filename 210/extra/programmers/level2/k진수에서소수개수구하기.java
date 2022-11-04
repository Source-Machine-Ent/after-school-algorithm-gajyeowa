// 20220915
package extra.level2;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 110011;
        int k = 10;

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(n, k));
    }
}

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        int currNum = n;
        String num = "";
        while (currNum != 0) {
            num = String.valueOf(currNum % k) + num;
            currNum /= k;
        }

        String[] nums = num.split("0");
        int numsLength = nums.length;

        for (int i = 0; i < numsLength; i++) {
            if (nums[i].equals("1") || nums[i].equals(""))
                continue;

            else if (isPrime(nums[i])) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPrime(String numString) {
        long num = Long.parseLong(numString);
        if(num == 2) return true;

        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}