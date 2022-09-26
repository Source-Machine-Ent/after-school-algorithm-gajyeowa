package level1;

class Main {
    public static void main(String[] args) throws Exception {
        int[] nums = {1,2,3,4};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(nums));
    }
}

class Solution {    
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum % 2 != 0)
                        answer += isPrime(sum);
                }
            }
        }
        return answer;
    }
    
        public int isPrime(int num){
        boolean isPrime = true;
        if(num <= 7) return 1;
        for(int i = 3; i < num; i+=2){
            if(num % i == 0) isPrime = false;
        }
        
        if (isPrime) return 1;
        return 0;
    }
}